package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserContactAddingDtoTest {

	private UserContactAddingDto userContactAddingDto;
    
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
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userContactAddingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userContactAddingDto.isDataValidated());
	}
}
