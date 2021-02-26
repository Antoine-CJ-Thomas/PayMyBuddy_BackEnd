package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserAccount;

@SpringBootTest
class UserAccountLoginDtoTest {

	private UserAccountLoginDto userAccountLoginDto;
	
	@Mock
	private UserAccount userAccount;
    
	@BeforeEach
	void beforeEach() {

		userAccountLoginDto = new UserAccountLoginDto(null, null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userAccountLoginDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userAccountLoginDto.getEmailAddress());
	}

	@Test
	void test_setAndGetPassword() {

    	//GIVEN
		String password = "password";
        
    	//WHEN
		userAccountLoginDto.setPassword(password);
    	
    	//THEN
        assertEquals(password, userAccountLoginDto.getPassword());
	}
    
	@Test
	void test_setAndGetUserAccount() {

    	//GIVEN
        
    	//WHEN
		userAccountLoginDto.setUserAccount(userAccount);
    	
    	//THEN
        assertEquals(userAccount, userAccountLoginDto.getUserAccount());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userAccountLoginDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userAccountLoginDto.isDataValidated());
	}
}
