package com.paymybuddy.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserContactTest {

	private UserContact userContact;
    
	@Test
	void test_getId() {

    	//GIVEN
		int id = 1;
        
    	//WHEN
		userContact = new UserContact(id, null, null, null);
    	
    	//THEN
        assertEquals(id, userContact.getId());
	}

	@Test
	void test_getEmailAdresse() {

    	//GIVEN
		String emailAdresse = "emailAdresse";
        
    	//WHEN
		userContact = new UserContact(0, emailAdresse, null, null);
    	
    	//THEN
        assertEquals(emailAdresse, userContact.getEmailAdresse());
	}

	@Test
	void test_getFirstName() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
		userContact = new UserContact(0, null, firstName, null);
    	
    	//THEN
        assertEquals(firstName, userContact.getFirstName());
	}

	@Test
	void test_getLastName() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
		userContact = new UserContact(0, null, null, lastName);
    	
    	//THEN
        assertEquals(lastName, userContact.getLastName());
	}
}
