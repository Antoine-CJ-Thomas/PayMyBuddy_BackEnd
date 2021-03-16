package com.paymybuddy.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.dto.UserAccountEditingDto;
import com.paymybuddy.app.dto.UserAccountLoginDto;
import com.paymybuddy.app.dto.UserAccountRetrievingDto;
import com.paymybuddy.app.service.UserAccountService;

@SpringBootTest
class UserAccountControllerTest {

	private UserAccountController userAccountController;

	@Mock
	private UserAccountCreatingDto userAccountCreatingDto;
	@Mock
	private UserAccountDeletingDto userAccountDeletingDto;
	@Mock
	private UserAccountEditingDto userAccountEditingDto;
	@Mock
	private UserAccountLoginDto userAccountLoginDto;
	@Mock
	private UserAccountRetrievingDto userAccountRetrievingDto;
	@Mock
    private UserAccountService userAccountService;
    
	@BeforeEach
	void beforeEach() {

		userAccountController = new UserAccountController();
		ReflectionTestUtils.setField(userAccountController, "userAccountService", userAccountService);
	}
	
	@Test
	void test_createUserAccount() {

    	//GIVEN
        
    	//WHEN
		when(userAccountService.createUserAccount(userAccountCreatingDto)).thenReturn(userAccountCreatingDto);
	    
    	//THEN
        assertEquals(userAccountCreatingDto, userAccountController.createUserAccount(userAccountCreatingDto));
	}
	
	@Test
	void test_deleteUserAccount() {

    	//GIVEN
        
    	//WHEN
		when(userAccountService.deleteUserAccount(userAccountDeletingDto)).thenReturn(userAccountDeletingDto);
	    
    	//THEN
        assertEquals(userAccountDeletingDto, userAccountController.deleteUserAccount(userAccountDeletingDto));
	}

	@Test
	void test_editUserAccount() {

    	//GIVEN
        
    	//WHEN
		when(userAccountService.editUserAccount(userAccountEditingDto)).thenReturn(userAccountEditingDto);
	    
    	//THEN
        assertEquals(userAccountEditingDto, userAccountController.editUserAccount(userAccountEditingDto));
	}
	
	@Test
	void test_loginUserAccount() {		

    	//GIVEN
        
    	//WHEN
		when(userAccountService.loginUserAccount(userAccountLoginDto)).thenReturn(userAccountLoginDto);
	    
    	//THEN
        assertEquals(userAccountLoginDto, userAccountController.loginUserAccount(userAccountLoginDto));
	}

	@Test
	void test_retrieveUserAccount() {

    	//GIVEN
		String emailAdress = "emailAdress";
        
    	//WHEN
		when(userAccountService.retrieveUserAccount(any())).thenReturn(userAccountRetrievingDto);
	    
    	//THEN
        assertEquals(userAccountRetrievingDto, userAccountController.retrieveUserAccount(emailAdress));
	}
}
