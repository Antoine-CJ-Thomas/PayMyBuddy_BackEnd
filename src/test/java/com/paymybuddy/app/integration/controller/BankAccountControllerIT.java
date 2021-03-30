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
import com.paymybuddy.app.controller.UserAccountController;
import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.dto.BankAccountRemovingDto;
import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class BankAccountControllerIT {

	@Autowired
	private UserAccountController userAccountController;
	@Autowired
	private BankAccountController bankAccountController;
	
	private String userEmailAddress = "user.test@email";
	private String userPassword = "123";
	private String userFirstName = "user";
	private String userLastName = "test";

	private String bankAccountName = "test account";
	private String bankAccountNumber = "123456";
	private String bankAccountSwiftCode = "456789";
    
	@BeforeEach
	void beforeEach() {

		userAccountController.createUserAccount(new UserAccountCreatingDto(userEmailAddress, userPassword, userFirstName, userLastName));
	}
    
	@AfterAll
	void afterAll() {

		userAccountController.deleteUserAccount(new UserAccountDeletingDto(userEmailAddress));
	}
	
	@Test
    @Order(1)
	void test_addBankAccount() {

    	//GIVEN
		BankAccountAddingDto bankAccountAddingDto = new BankAccountAddingDto(userEmailAddress, bankAccountName, bankAccountNumber, bankAccountSwiftCode);
        
    	//WHEN
		bankAccountController.addBankAccount(bankAccountAddingDto);
	    
    	//THEN
        assertEquals(bankAccountName, bankAccountController.retrieveBankAccountList(userEmailAddress).getBankAccountList().get(0).getAccountName());
	}
	
	@Test
    @Order(2)
	void test_removeBankAccount() {

    	//GIVEN
		BankAccountRemovingDto bankAccountRemovingDto = new BankAccountRemovingDto(userEmailAddress, bankAccountName);
        
    	//WHEN
		bankAccountController.removeBankAccount(bankAccountRemovingDto);
	    
    	//THEN
        assertEquals(0, bankAccountController.retrieveBankAccountList(userEmailAddress).getBankAccountList().size());
	}
}
