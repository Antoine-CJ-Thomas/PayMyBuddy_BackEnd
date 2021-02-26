package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserAccount;

@SpringBootTest
class UserAccountDeletingDtoTest {

	private UserAccountDeletingDto userAccountDeletingDto;
	
	@Mock
	private UserAccount userAccount;
    
	@BeforeEach
	void beforeEach() {

		userAccountDeletingDto = new UserAccountDeletingDto(null, null);
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
	void test_setAndGetPassword() {

    	//GIVEN
		String password = "password";
        
    	//WHEN
		userAccountDeletingDto.setPassword(password);
    	
    	//THEN
        assertEquals(password, userAccountDeletingDto.getPassword());
	}
    
	@Test
	void test_setAndGetUserAccount() {

    	//GIVEN
        
    	//WHEN
		userAccountDeletingDto.setUserAccount(userAccount);
    	
    	//THEN
        assertEquals(userAccount, userAccountDeletingDto.getUserAccount());
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
}
