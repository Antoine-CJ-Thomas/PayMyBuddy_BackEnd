package com.paymybuddy.app.integration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.controller.UserAccountController;
import com.paymybuddy.app.dto.UserAccountBalanceEditingDto;
import com.paymybuddy.app.dto.UserAccountEditingDto;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class UserAccountControllerIT {

	@Autowired
	private UserAccountController userAccountController;
	
	private String userEmailAddress = "user.test@email";
	private String userPassword = "123";
	private String userFirstName = "user";
	private String userLastName = "test";
	
	private String userNewPassword = "456";
	
	private String cardNumber = "1234 1234 1234 1234";
	private String cardExpiration = "01/01";
	private String cardCryptogram = "123";
	private float payementAmount = 10.0f;
	
	@Test
    @Order(1)
	void test_createUserAccount() {

    	//GIVEN
		UserAccountCreatingDto userAccountCreatingDto = new UserAccountCreatingDto(userEmailAddress, userPassword, userFirstName, userLastName);
        
    	//WHEN
		userAccountController.createUserAccount(userAccountCreatingDto);
		userAccountController.retrieveUserAccount(userEmailAddress);
	    
    	//THEN
        assertEquals(userEmailAddress, userAccountController.retrieveUserAccount(userEmailAddress).getUserAccount().getEmailAddress());
	}

	@Test
    @Order(2)
	void test_editUserAccount() {

    	//GIVEN
		UserAccountEditingDto userAccountEditingDto = new UserAccountEditingDto(userEmailAddress, userNewPassword, userFirstName, userLastName);
        
    	//WHEN
		userAccountController.editUserAccount(userAccountEditingDto);
		userAccountController.retrieveUserAccount(userEmailAddress);
	    
    	//THEN
        assertEquals(userNewPassword, userAccountController.retrieveUserAccount(userEmailAddress).getUserAccount().getPassword());
	}

	@Test
    @Order(3)
	void test_editUserAccountBalance() {

    	//GIVEN
		UserAccountBalanceEditingDto userAccountBalanceEditingDto = new UserAccountBalanceEditingDto(userEmailAddress, cardNumber, cardExpiration, cardCryptogram, payementAmount);
        
    	//WHEN
		userAccountController.editUserAccountBalance(userAccountBalanceEditingDto);
		userAccountController.retrieveUserAccount(userEmailAddress);
	    
    	//THEN
        assertEquals(payementAmount, userAccountController.retrieveUserAccount(userEmailAddress).getUserAccount().getBalanceAmount());
	}
	
	@Test
    @Order(4)
	void test_deleteUserAccount() {

    	//GIVEN
		UserAccountDeletingDto userAccountDeletingDto = new UserAccountDeletingDto(userEmailAddress);
        
    	//WHEN
		userAccountController.deleteUserAccount(userAccountDeletingDto);
		userAccountController.retrieveUserAccount(userEmailAddress);
	    
    	//THEN
        assertEquals(null, userAccountController.retrieveUserAccount(userEmailAddress).getUserAccount().getEmailAddress());
	}
}
