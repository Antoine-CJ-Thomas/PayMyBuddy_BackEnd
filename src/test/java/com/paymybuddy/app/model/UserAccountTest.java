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

		userAccount = new UserAccount(0, null, null, null, null, 0.0f);
	}
    
	@Test
	void test_getId() {

    	//GIVEN
		int id = 1;
        
    	//WHEN
		userAccount.setId(id);
    	
    	//THEN
        assertEquals(id, userAccount.getId());
	}

	@Test
	void test_getEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAdress";
        
    	//WHEN
		userAccount.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userAccount.getEmailAddress());
	}

	@Test
	void test_getPassword() {

    	//GIVEN
		String password = "password";
        
    	//WHEN
		userAccount.setPassword(password);
    	
    	//THEN
        assertEquals(password, userAccount.getPassword());
	}

	@Test
	void test_getFirstName() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
		userAccount.setFirstName(firstName);
    	
    	//THEN
        assertEquals(firstName, userAccount.getFirstName());
	}

	@Test
	void test_getLastName() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
		userAccount.setLastName(lastName);
    	
    	//THEN
        assertEquals(lastName, userAccount.getLastName());
	}

	@Test
	void test_getBalanceAmount() {

    	//GIVEN
		float balanceAmount = 1.0f;
        
    	//WHEN
		userAccount.setBalanceAmount(balanceAmount);
    	
    	//THEN
        assertEquals(balanceAmount, userAccount.getBalanceAmount());
	}
}
