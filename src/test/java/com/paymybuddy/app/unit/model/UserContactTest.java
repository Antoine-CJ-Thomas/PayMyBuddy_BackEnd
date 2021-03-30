package com.paymybuddy.app.unit.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserContact;

@SpringBootTest
class UserContactTest {

	private UserContact userContact;
    
	@BeforeEach
	void beforeEach() {

		userContact = new UserContact(null, null, null);
	}

	@Test
	void test_setAndGetEmailAdresse() {

    	//GIVEN
		String emailAddress = "emailAdress";
        
    	//WHEN
		userContact.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userContact.getEmailAddress());
	}

	@Test
	void test_setAndGetFirstName() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
		userContact.setFirstName(firstName);
    	
    	//THEN
        assertEquals(firstName, userContact.getFirstName());
	}

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
		userContact.setLastName(lastName);
    	
    	//THEN
        assertEquals(lastName, userContact.getLastName());
	}
}
