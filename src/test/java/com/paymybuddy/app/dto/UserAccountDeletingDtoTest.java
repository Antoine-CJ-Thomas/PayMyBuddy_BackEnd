package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserAccountDeletingDtoTest {

	private UserAccountDeletingDto userAccountDeletingDto;
    
	@BeforeEach
	void beforeEach() {

		userAccountDeletingDto = new UserAccountDeletingDto(null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userAccountDeletingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userAccountDeletingDto.getEmailAddress());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userAccountDeletingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userAccountDeletingDto.isDataValidated());
	}

	@Test
	void test_setAndGetMessage() {

    	//GIVEN
		String message = "message";
        
    	//WHEN
		userAccountDeletingDto.setMessage(message);
    	
    	//THEN
        assertEquals(message, userAccountDeletingDto.getMessage());
	}
}
