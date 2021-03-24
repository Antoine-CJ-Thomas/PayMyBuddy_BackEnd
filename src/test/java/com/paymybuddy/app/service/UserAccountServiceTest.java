package com.paymybuddy.app.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.dto.UserAccountEditingDto;
import com.paymybuddy.app.dto.UserAccountRetrievingDto;
import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.UserAccountRepository;

@SpringBootTest
class UserAccountServiceTest {

	private UserAccountService userAccountService;

	@Mock
	private UserAccountCreatingDto userAccountCreatingDto;
	@Mock
	private UserAccountDeletingDto userAccountDeletingDto;
	@Mock
	private UserAccountEditingDto userAccountEditingDto;
	@Mock
	private UserAccountRetrievingDto userAccountRetrievingDto;
	@Mock
	private UserAccountRepository userAccountRepository;
	@Mock
	private UserAccount userAccount;
    
	@BeforeEach
	void beforeEach() {

		userAccountService = new UserAccountService();
		ReflectionTestUtils.setField(userAccountService, "userAccountRepository", userAccountRepository);
	}
	
	@Test
	void test_createUserAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String password = "password";
		String firstName = "firstName";
		String lastName = "lastName";
        
    	//WHEN
		when(userAccountCreatingDto.getEmailAddress()).thenReturn(emailAddress);
		when(userAccountCreatingDto.getPassword()).thenReturn(password);
		when(userAccountCreatingDto.getFirstName()).thenReturn(firstName);
		when(userAccountCreatingDto.getLastName()).thenReturn(lastName);
		
		when(userAccountRepository.insertUserAccount(
				userAccountCreatingDto.getEmailAddress(), 
				userAccountCreatingDto.getPassword(), 
				userAccountCreatingDto.getFirstName(), 
				userAccountCreatingDto.getLastName())).thenReturn("00000");
		
		userAccountService.createUserAccount(userAccountCreatingDto);
	    
    	//THEN
        verify(userAccountCreatingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_createUserAccount_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String password = "password";
		String firstName = "firstName";
		String lastName = "lastName";
        
    	//WHEN
		when(userAccountCreatingDto.getEmailAddress()).thenReturn(emailAddress);
		when(userAccountCreatingDto.getPassword()).thenReturn(password);
		when(userAccountCreatingDto.getFirstName()).thenReturn(firstName);
		when(userAccountCreatingDto.getLastName()).thenReturn(lastName);
		
		when(userAccountRepository.insertUserAccount(
				userAccountCreatingDto.getEmailAddress(), 
				userAccountCreatingDto.getPassword(), 
				userAccountCreatingDto.getFirstName(), 
				userAccountCreatingDto.getLastName())).thenReturn("");
		
		userAccountService.createUserAccount(userAccountCreatingDto);
	    
    	//THEN
        verify(userAccountCreatingDto, Mockito.times(1)).setDataValidated(false);
	}
	
	@Test
	void test_deleteUserAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(userAccountDeletingDto.getEmailAddress()).thenReturn(emailAddress);
		
		when(userAccountRepository.deleteUserAccount(
				userAccountDeletingDto.getEmailAddress())).thenReturn("00000");
		
		userAccountService.deleteUserAccount(userAccountDeletingDto);
	    
    	//THEN
        verify(userAccountDeletingDto, Mockito.times(1)).setDataValidated(true);
	}
	
	@Test
	void test_deleteUserAccount_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(userAccountDeletingDto.getEmailAddress()).thenReturn(emailAddress);
		
		when(userAccountRepository.deleteUserAccount(
				userAccountDeletingDto.getEmailAddress())).thenReturn("");
		
		userAccountService.deleteUserAccount(userAccountDeletingDto);
	    
    	//THEN
        verify(userAccountDeletingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_editUserAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String password = "password";
		String firstName = "firstName";
		String lastName = "lastName";
        
    	//WHEN
		when(userAccountEditingDto.getEmailAddress()).thenReturn(emailAddress);
		when(userAccountEditingDto.getPassword()).thenReturn(password);
		when(userAccountEditingDto.getFirstName()).thenReturn(firstName);
		when(userAccountEditingDto.getLastName()).thenReturn(lastName);
		
		when(userAccountRepository.updateUserAccount(
				userAccountEditingDto.getEmailAddress(), 
				userAccountEditingDto.getPassword(), 
				userAccountEditingDto.getFirstName(), 
				userAccountEditingDto.getLastName())).thenReturn("00000");
		
		userAccountService.editUserAccount(userAccountEditingDto);
	    
    	//THEN
        verify(userAccountEditingDto, Mockito.times(1)).setDataValidated(true);
	}
	
	@Test
	void test_editUserAccount_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String password = "password";
		String firstName = "firstName";
		String lastName = "lastName";
        
    	//WHEN
		when(userAccountEditingDto.getEmailAddress()).thenReturn(emailAddress);
		when(userAccountEditingDto.getPassword()).thenReturn(password);
		when(userAccountEditingDto.getFirstName()).thenReturn(firstName);
		when(userAccountEditingDto.getLastName()).thenReturn(lastName);
		
		when(userAccountRepository.updateUserAccount(
				userAccountEditingDto.getEmailAddress(), 
				userAccountEditingDto.getPassword(), 
				userAccountEditingDto.getFirstName(), 
				userAccountEditingDto.getLastName())).thenReturn("");
		
		userAccountService.editUserAccount(userAccountEditingDto);
	    
    	//THEN
        verify(userAccountEditingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_retrieveUserAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(userAccountRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(userAccountRetrievingDto.getUserAccount()).thenReturn(userAccount);
		
		when(userAccountRepository.selectUserAccount(
				userAccountRetrievingDto.getEmailAddress(), 
				userAccountRetrievingDto.getUserAccount())).thenReturn("00000");
		
		userAccountService.retrieveUserAccount(userAccountRetrievingDto);
	    
    	//THEN
        verify(userAccountRetrievingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_retrieveUserAccount_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(userAccountRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(userAccountRetrievingDto.getUserAccount()).thenReturn(userAccount);
		
		when(userAccountRepository.selectUserAccount(
				userAccountRetrievingDto.getEmailAddress(), 
				userAccountRetrievingDto.getUserAccount())).thenReturn("");
		
		userAccountService.retrieveUserAccount(userAccountRetrievingDto);
	    
    	//THEN
        verify(userAccountRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
