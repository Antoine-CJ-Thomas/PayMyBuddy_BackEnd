package com.paymybuddy.app.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.dto.UserAccountBalanceEditingDto;
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
	private UserAccountBalanceEditingDto userAccountBalanceEditingDto;
	@Mock
	private UserAccountRepository userAccountRepository;
	@Mock
	private UserAccount userAccount;
    
	@BeforeEach
	void beforeEach() {

    	//GIVEN
		userAccountService = new UserAccountService();
		ReflectionTestUtils.setField(userAccountService, "userAccountRepository", userAccountRepository);
	}
	
	@Test
	void test_createUserAccount_OK() {
        
    	//WHEN
		when(userAccountCreatingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userAccountCreatingDto.getPassword()).thenReturn("password");
		when(userAccountCreatingDto.getFirstName()).thenReturn("firstName");
		when(userAccountCreatingDto.getLastName()).thenReturn("lastName");
		
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
	void test_createUserAccount_NOK_emailAddressAlreadyUsed() {
        
    	//WHEN
		when(userAccountCreatingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userAccountCreatingDto.getPassword()).thenReturn("password");
		when(userAccountCreatingDto.getFirstName()).thenReturn("firstName");
		when(userAccountCreatingDto.getLastName()).thenReturn("lastName");
		
		when(userAccountRepository.insertUserAccount(
				userAccountCreatingDto.getEmailAddress(), 
				userAccountCreatingDto.getPassword(), 
				userAccountCreatingDto.getFirstName(), 
				userAccountCreatingDto.getLastName())).thenReturn("23505");
		
		userAccountService.createUserAccount(userAccountCreatingDto);
	    
    	//THEN
        verify(userAccountCreatingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_createUserAccount_NOK() {
        
    	//WHEN
		when(userAccountCreatingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userAccountCreatingDto.getPassword()).thenReturn("password");
		when(userAccountCreatingDto.getFirstName()).thenReturn("firstName");
		when(userAccountCreatingDto.getLastName()).thenReturn("lastName");
		
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
	void test_deleteUserAccount_OK() {
        
    	//WHEN
		when(userAccountDeletingDto.getEmailAddress()).thenReturn("emailAddress");
		
		when(userAccountRepository.deleteUserAccount(
				userAccountDeletingDto.getEmailAddress())).thenReturn("00000");
		
		userAccountService.deleteUserAccount(userAccountDeletingDto);
	    
    	//THEN
        verify(userAccountDeletingDto, Mockito.times(1)).setDataValidated(true);
	}
	
	@Test
	void test_deleteUserAccount_NOK() {
        
    	//WHEN
		when(userAccountDeletingDto.getEmailAddress()).thenReturn("emailAddress");
		
		when(userAccountRepository.deleteUserAccount(
				userAccountDeletingDto.getEmailAddress())).thenReturn("");
		
		userAccountService.deleteUserAccount(userAccountDeletingDto);
	    
    	//THEN
        verify(userAccountDeletingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_editUserAccount_OK() {
        
    	//WHEN
		when(userAccountEditingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userAccountEditingDto.getPassword()).thenReturn("password");
		when(userAccountEditingDto.getFirstName()).thenReturn("firstName");
		when(userAccountEditingDto.getLastName()).thenReturn("lastName");
		
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
	void test_editUserAccount_NOK() {
        
    	//WHEN
		when(userAccountEditingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userAccountEditingDto.getPassword()).thenReturn("password");
		when(userAccountEditingDto.getFirstName()).thenReturn("firstName");
		when(userAccountEditingDto.getLastName()).thenReturn("lastName");
		
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
	void test_retrieveUserAccount_OK() {
        
    	//WHEN
		when(userAccountRetrievingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userAccountRetrievingDto.getUserAccount()).thenReturn(userAccount);
		
		when(userAccountRepository.selectUserAccount(
				userAccountRetrievingDto.getEmailAddress(), 
				userAccountRetrievingDto.getUserAccount())).thenReturn("00000");
		
		userAccountService.retrieveUserAccount(userAccountRetrievingDto);
	    
    	//THEN
        verify(userAccountRetrievingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_retrieveUserAccount_NOK() {
        
    	//WHEN
		when(userAccountRetrievingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userAccountRetrievingDto.getUserAccount()).thenReturn(userAccount);
		
		when(userAccountRepository.selectUserAccount(
				userAccountRetrievingDto.getEmailAddress(), 
				userAccountRetrievingDto.getUserAccount())).thenReturn("");
		
		userAccountService.retrieveUserAccount(userAccountRetrievingDto);
	    
    	//THEN
        verify(userAccountRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_editUserAccountBalance_OK() {
        
    	//WHEN
		when(userAccountBalanceEditingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userAccountBalanceEditingDto.getCardNumber()).thenReturn("cardNumber");
		when(userAccountBalanceEditingDto.getCardExpiration()).thenReturn("cardExpiration");
		when(userAccountBalanceEditingDto.getCardCryptogram()).thenReturn("cardCryptogram");
		when(userAccountBalanceEditingDto.getPayementAmount()).thenReturn(10.0f);
		
		when(userAccountRepository.updateUserAccountBalance(
				userAccountBalanceEditingDto.getEmailAddress(), 
				userAccountBalanceEditingDto.getCardNumber(), 
				userAccountBalanceEditingDto.getCardExpiration(), 
				userAccountBalanceEditingDto.getCardCryptogram(), 
				userAccountBalanceEditingDto.getPayementAmount())).thenReturn("00000");
		
		userAccountService.editUserAccountBalance(userAccountBalanceEditingDto);
	    
    	//THEN
        verify(userAccountBalanceEditingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_editUserAccountBalance_NOK() {
        
    	//WHEN
		when(userAccountBalanceEditingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userAccountBalanceEditingDto.getCardNumber()).thenReturn("cardNumber");
		when(userAccountBalanceEditingDto.getCardExpiration()).thenReturn("cardExpiration");
		when(userAccountBalanceEditingDto.getCardCryptogram()).thenReturn("cardCryptogram");
		when(userAccountBalanceEditingDto.getPayementAmount()).thenReturn(10.0f);
		
		when(userAccountRepository.updateUserAccountBalance(
				userAccountBalanceEditingDto.getEmailAddress(), 
				userAccountBalanceEditingDto.getCardNumber(), 
				userAccountBalanceEditingDto.getCardExpiration(), 
				userAccountBalanceEditingDto.getCardCryptogram(), 
				userAccountBalanceEditingDto.getPayementAmount())).thenReturn("");
		
		userAccountService.editUserAccountBalance(userAccountBalanceEditingDto);
	    
    	//THEN
        verify(userAccountBalanceEditingDto, Mockito.times(1)).setDataValidated(false);
	}
}
