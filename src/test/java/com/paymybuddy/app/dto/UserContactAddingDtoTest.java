package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserContact;

@SpringBootTest
class UserContactAddingDtoTest {

	private UserContactAddingDto userContactAddingDto;
	
	@Mock
	private ArrayList<UserContact> userContactList = new ArrayList<UserContact>();
    
	@BeforeEach
	void beforeEach() {

		userContactAddingDto = new UserContactAddingDto(null, null);
	}

	@Test
	void test_setAndGetUserEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userContactAddingDto.setUserEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userContactAddingDto.getUserEmailAddress());
	}

	@Test
	void test_setAndGetContactEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userContactAddingDto.setContactEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userContactAddingDto.getContactEmailAddress());
	}
    
	@Test
	void test_setAndGetUserContactList() {

    	//GIVEN
        
    	//WHEN
		userContactAddingDto.setUserContactList(userContactList);
    	
    	//THEN
        assertEquals(userContactList, userContactAddingDto.getUserContactList());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userContactAddingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userContactAddingDto.isDataValidated());
	}
}
