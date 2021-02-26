package com.paymybuddy.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserAccountTest {

	private UserAccount userAccount;
    
	@BeforeEach
	void beforeEach() {

		userAccount = new UserAccount(null, null, null, null, 0.0f);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAdress";
        
    	//WHEN
		userAccount.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userAccount.getEmailAddress());
	}

	@Test
	void test_setAndGetPassword() {

    	//GIVEN
		String password = "password";
        
    	//WHEN
		userAccount.setPassword(password);
    	
    	//THEN
        assertEquals(password, userAccount.getPassword());
	}

	@Test
	void test_setAndGetFirstName() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
		userAccount.setFirstName(firstName);
    	
    	//THEN
        assertEquals(firstName, userAccount.getFirstName());
	}

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
		userAccount.setLastName(lastName);
    	
    	//THEN
        assertEquals(lastName, userAccount.getLastName());
	}

	@Test
	void test_setAndGetBalanceAmount() {

    	//GIVEN
		float balanceAmount = 1.0f;
        
    	//WHEN
		userAccount.setBalanceAmount(balanceAmount);
    	
    	//THEN
        assertEquals(balanceAmount, userAccount.getBalanceAmount());
	}
}
