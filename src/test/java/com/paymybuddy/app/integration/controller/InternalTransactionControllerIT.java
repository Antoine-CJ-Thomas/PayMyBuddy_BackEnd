package com.paymybuddy.app.integration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.paymybuddy.app.controller.InternalTransactionController;
import com.paymybuddy.app.controller.UserAccountController;
import com.paymybuddy.app.controller.UserContactController;
import com.paymybuddy.app.dto.InternalTransactionExecutingDto;
import com.paymybuddy.app.dto.UserAccountBalanceEditingDto;
import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.dto.UserContactAddingDto;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class InternalTransactionControllerIT {

	@Autowired
	private UserAccountController userAccountController;
	@Autowired
	private UserContactController userContactController;
	@Autowired
	private InternalTransactionController InternalTransactionController;
	
	private String userEmailAddress = "user.test@email";
	private String userPassword = "123";
	private String userFirstName = "user";
	private String userLastName = "test";
	
	private String contactEmailAddress = "contact.test@email";
	private String contactPassword = "123";
	private String contactFirstName = "contact";
	private String contactLastName = "test";
	
	private String cardNumber = "1234 1234 1234 1234";
	private String cardExpiration = "01/01";
	private String cardCryptogram = "123";
	private float payementAmount = 10.0f;
	
	private String description = "Internal transaction test";
	private float amount = 5.0f;
    
	@BeforeEach
	void beforeEach() {

		userAccountController.createUserAccount(new UserAccountCreatingDto(userEmailAddress, userPassword, userFirstName, userLastName));
		userAccountController.createUserAccount(new UserAccountCreatingDto(contactEmailAddress, contactPassword, contactFirstName, contactLastName));
		userAccountController.editUserAccountBalance(new UserAccountBalanceEditingDto(userEmailAddress, cardNumber, cardExpiration, cardCryptogram, payementAmount));
		userContactController.addUserContact(new UserContactAddingDto(userEmailAddress, contactEmailAddress));
	}
    
	@AfterAll
	void afterAll() {

		userAccountController.deleteUserAccount(new UserAccountDeletingDto(userEmailAddress));
		userAccountController.deleteUserAccount(new UserAccountDeletingDto(contactEmailAddress));
	}
	
	@Test
    @Order(1)
	void test_executeInternalTransaction() {
		
    	//GIVEN
		InternalTransactionExecutingDto internalTransactionExecutingDto = new InternalTransactionExecutingDto(userEmailAddress, contactEmailAddress, description, amount);
        
    	//WHEN
		InternalTransactionController.executeInternalTransaction(internalTransactionExecutingDto);
	    
    	//THEN
        assertEquals(description, InternalTransactionController.retrieveInternalTransactionList(userEmailAddress).getInternalTransactionList().get(0).getDescription());
	}
}
