package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserAccount;

@SpringBootTest
class UserAccountCreatingDtoTest {

	private UserAccountCreatingDto userAccountCreatingDto;
	
	@Mock
	private UserAccount userAccount;
    
	@BeforeEach
	void beforeEach() {

		userAccountCreatingDto = new UserAccountCreatingDto(null, null, null, null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userAccountCreatingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userAccountCreatingDto.getEmailAddress());
	}

	@Test
	void test_setAndGetPassword() {

    	//GIVEN
		String password = "password";
        
    	//WHEN
		userAccountCreatingDto.setPassword(password);
    	
    	//THEN
        assertEquals(password, userAccountCreatingDto.getPassword());
	}

	@Test
	void test_setAndGetFirstName() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
		userAccountCreatingDto.setFirstName(firstName);
    	
    	//THEN
        assertEquals(firstName, userAccountCreatingDto.getFirstName());
	}

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
		userAccountCreatingDto.setLastName(lastName);
    	
    	//THEN
        assertEquals(lastName, userAccountCreatingDto.getLastName());
	}
    
	@Test
	void test_setAndGetUserAccount() {

    	//GIVEN
        
    	//WHEN
		userAccountCreatingDto.setUserAccount(userAccount);
    	
    	//THEN
        assertEquals(userAccount, userAccountCreatingDto.getUserAccount());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userAccountCreatingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userAccountCreatingDto.isDataValidated());
	}
}
