package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserContact;

@SpringBootTest
class UserContactRemovingDtoTest {

	private UserContactRemovingDto userContactRemovingDto;
	
	@Mock
	private ArrayList<UserContact> userContactList = new ArrayList<UserContact>();
    
	@BeforeEach
	void beforeEach() {

		userContactRemovingDto = new UserContactRemovingDto(null, null);
	}

	@Test
	void test_setAndGetUserEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userContactRemovingDto.setUserEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userContactRemovingDto.getUserEmailAddress());
	}

	@Test
	void test_setAndGetContactEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userContactRemovingDto.setContactEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userContactRemovingDto.getContactEmailAddress());
	}
    
	@Test
	void test_setAndGetUserContactList() {

    	//GIVEN
        
    	//WHEN
		userContactRemovingDto.setUserContactList(userContactList);
    	
    	//THEN
        assertEquals(userContactList, userContactRemovingDto.getUserContactList());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userContactRemovingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userContactRemovingDto.isDataValidated());
	}
}
