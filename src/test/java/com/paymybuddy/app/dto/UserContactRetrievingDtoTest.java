package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserContact;

@SpringBootTest
class UserContactRetrievingDtoTest {

	private UserContactRetrievingDto userContactRetrievingDto;
	
	@Mock
	private ArrayList<UserContact> userContactList = new ArrayList<UserContact>();
    
	@BeforeEach
	void beforeEach() {

		userContactRetrievingDto = new UserContactRetrievingDto(null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userContactRetrievingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userContactRetrievingDto.getEmailAddress());
	}
    
	@Test
	void test_setAndGetUserContactList() {

    	//GIVEN
        
    	//WHEN
		userContactRetrievingDto.setUserContactList(userContactList);
    	
    	//THEN
        assertEquals(userContactList, userContactRetrievingDto.getUserContactList());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userContactRetrievingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userContactRetrievingDto.isDataValidated());
	}

	@Test
	void test_setAndGetMessage() {

    	//GIVEN
		String message = "message";
        
    	//WHEN
		userContactRetrievingDto.setMessage(message);
    	
    	//THEN
        assertEquals(message, userContactRetrievingDto.getMessage());
	}
}
