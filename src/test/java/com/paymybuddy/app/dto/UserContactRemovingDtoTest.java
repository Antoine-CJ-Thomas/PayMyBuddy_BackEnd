package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserContactRemovingDtoTest {

	private UserContactRemovingDto userContactRemovingDto;
    
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
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userContactRemovingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userContactRemovingDto.isDataValidated());
	}
}
