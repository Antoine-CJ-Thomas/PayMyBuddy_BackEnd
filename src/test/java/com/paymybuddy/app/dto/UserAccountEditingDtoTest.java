package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserAccount;

@SpringBootTest
class UserAccountEditingDtoTest {

	private UserAccountEditingDto userAccountEditingDto;
	
	@Mock
	private UserAccount userAccount;
    
	@BeforeEach
	void beforeEach() {

		userAccountEditingDto = new UserAccountEditingDto(null, null, null, null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userAccountEditingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userAccountEditingDto.getEmailAddress());
	}

	@Test
	void test_setAndGetPassword() {

    	//GIVEN
		String password = "password";
        
    	//WHEN
		userAccountEditingDto.setPassword(password);
    	
    	//THEN
        assertEquals(password, userAccountEditingDto.getPassword());
	}

	@Test
	void test_setAndGetFirstName() {

    	//GIVEN
		String firstName = "firstName";
        
    	//WHEN
		userAccountEditingDto.setFirstName(firstName);
    	
    	//THEN
        assertEquals(firstName, userAccountEditingDto.getFirstName());
	}

	@Test
	void test_setAndGetLastName() {

    	//GIVEN
		String lastName = "lastName";
        
    	//WHEN
		userAccountEditingDto.setLastName(lastName);
    	
    	//THEN
        assertEquals(lastName, userAccountEditingDto.getLastName());
	}
    
	@Test
	void test_setAndGetUserAccount() {

    	//GIVEN
        
    	//WHEN
		userAccountEditingDto.setUserAccount(userAccount);
    	
    	//THEN
        assertEquals(userAccount, userAccountEditingDto.getUserAccount());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userAccountEditingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userAccountEditingDto.isDataValidated());
	}
}
