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
<<<<<<< HEAD
		userAccount = new UserAccount(id, null, null, null, null, 0.0f);
    	
    	//THEN
        assertEquals(id, userAccount.getId());
	}

	@Test
	void test_getEmailAdress() {

    	//GIVEN
		String emailAdresse = "emailAdresse";
        
    	//WHEN
		userAccount = new UserAccount(0, emailAdresse, null, null, null, 0.0f);
    	
    	//THEN
        assertEquals(emailAdresse, userAccount.getEmailAdress());
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
=======
		userAccount = new UserAccount(id, null, null, null, 0.0f);
    	
    	//THEN
        assertEquals(id, userAccount.getId());
	}

	@Test
	void test_getEmailAdresse() {

    	//GIVEN
		String emailAdresse = "emailAdresse";
        
    	//WHEN
		userAccount = new UserAccount(0, emailAdresse, null, null, 0.0f);
    	
    	//THEN
        assertEquals(emailAdresse, userAccount.getEmailAdresse());
	}

	@Test
	void test_getFirstName() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
		userAccount = new UserAccount(0, null, firstName, null, 0.0f);
    	
    	//THEN
        assertEquals(firstName, userAccount.getFirstName());
	}

	@Test
	void test_getLastName() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
		userAccount = new UserAccount(0, null, null, lastName, 0.0f);
    	
    	//THEN
        assertEquals(lastName, userAccount.getLastName());
	}

	@Test
	void test_getBalanceAmount() {

    	//GIVEN
		float balanceAmount = 1.0f;
        
    	//WHEN
		userAccount = new UserAccount(0, null, null, null, balanceAmount);
>>>>>>> refs/remotes/origin/develop
    	
    	//THEN
        assertEquals(balanceAmount, userAccount.getBalanceAmount());
	}
}
