package com.paymybuddy.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserAccountTest {

	private UserAccount userAccount;
    
	@Test
	void test_getId() {

    	//GIVEN
		int id = 1;
        
    	//WHEN
		userAccount = new UserAccount(id, null, null, null, null, 0.0f);
    	
    	//THEN
        assertEquals(id, userAccount.getId());
	}

	@Test
	void test_getEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAdress";
        
    	//WHEN
		userAccount = new UserAccount(0, emailAddress, null, null, null, 0.0f);
    	
    	//THEN
        assertEquals(emailAddress, userAccount.getEmailAddress());
	}

	@Test
	void test_getPassword() {

    	//GIVEN
		String password = "password";
        
    	//WHEN
		userAccount = new UserAccount(0, null, password, null, null, 0.0f);
    	
    	//THEN
        assertEquals(password, userAccount.getPassword());
	}

	@Test
	void test_getFirstName() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
		userAccount = new UserAccount(0, null, null, firstName, null, 0.0f);
    	
    	//THEN
        assertEquals(firstName, userAccount.getFirstName());
	}

	@Test
	void test_getLastName() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
		userAccount = new UserAccount(0, null, null, null, lastName, 0.0f);
    	
    	//THEN
        assertEquals(lastName, userAccount.getLastName());
	}

	@Test
	void test_getBalanceAmount() {

    	//GIVEN
		float balanceAmount = 1.0f;
        
    	//WHEN
		userAccount = new UserAccount(0, null, null, null, null, balanceAmount);
    	
    	//THEN
        assertEquals(balanceAmount, userAccount.getBalanceAmount());
	}
}
