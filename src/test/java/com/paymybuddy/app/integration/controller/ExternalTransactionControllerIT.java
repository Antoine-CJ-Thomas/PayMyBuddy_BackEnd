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
import com.paymybuddy.app.controller.BankAccountController;
import com.paymybuddy.app.controller.ExternalTransactionController;
import com.paymybuddy.app.controller.UserAccountController;
import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.dto.ExternalTransactionExecutingDto;
import com.paymybuddy.app.dto.UserAccountBalanceEditingDto;
import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class ExternalTransactionControllerIT {

	@Autowired
	private UserAccountController userAccountController;
	@Autowired
	private BankAccountController bankAccountController;
	@Autowired
	private ExternalTransactionController externalTransactionController;
	
	private String userEmailAddress = "user.test@email";
	private String userPassword = "123";
	private String userFirstName = "user";
	private String userLastName = "test";

	private String bankAccountName = "test account";
	private String bankAccountNumber = "123456";
	private String bankAccountSwiftCode = "456789";
	
	private String cardNumber = "1234 1234 1234 1234";
	private String cardExpiration = "01/01";
	private String cardCryptogram = "123";
	private float payementAmount = 10.0f;
	
	private String description = "External transaction test";
	private float amount = 5.0f;
    
	@BeforeEach
	void beforeEach() {

		userAccountController.createUserAccount(new UserAccountCreatingDto(userEmailAddress, userPassword, userFirstName, userLastName));
		userAccountController.editUserAccountBalance(new UserAccountBalanceEditingDto(userEmailAddress, cardNumber, cardExpiration, cardCryptogram, payementAmount));
		bankAccountController.addBankAccount(new BankAccountAddingDto(userEmailAddress, bankAccountName, bankAccountNumber, bankAccountSwiftCode));
	}
    
	@AfterAll
	void afterAll() {

		userAccountController.deleteUserAccount(new UserAccountDeletingDto(userEmailAddress));
	}
	
	@Test
    @Order(1)
	void test_executeExternalTransaction() {
		
    	//GIVEN
		ExternalTransactionExecutingDto externalTransactionExecutingDto = new ExternalTransactionExecutingDto(userEmailAddress, bankAccountName, description, amount);
        
    	//WHEN
		externalTransactionController.executeExternalTransaction(externalTransactionExecutingDto);
	    
    	//THEN
        assertEquals(description, externalTransactionController.retrieveExternalTransactionList(userEmailAddress).getExternalTransactionList().get(0).getDescription());
	}
}
