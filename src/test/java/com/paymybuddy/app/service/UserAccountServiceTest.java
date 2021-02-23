package com.paymybuddy.app.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.UserAccountRepository;

@SpringBootTest
class UserAccountServiceTest {

	private UserAccountService userAccountService;
	
	@Mock
	private UserAccount userAccount, anotherUserAccount;
	
	@Mock
	private UserAccountRepository userAccountRepository;
    
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
		when(userAccount.getEmailAddress()).thenReturn(emailAddress);
		when(userAccount.getPassword()).thenReturn(password);
		when(userAccount.getFirstName()).thenReturn(firstName);
		when(userAccount.getLastName()).thenReturn(lastName);
		when(userAccountRepository.selectUserAcount(emailAddress)).thenReturn(userAccount);
	    
    	//THEN
        assertEquals(true, userAccountService.createUserAccount(userAccount));
	}

	@Test
	void test_createUserAccount_false() {

    	//GIVEN
		String anotherEmailAddress = "anotherEmailAddress";
		String password = "password";
		String anotherPassword = "anotherPassword";
		String firstName = "firstName";
		String anotherFirstName = "anotherFirstName";
		String lastName = "lastName";
		String anotherLastName = "anotherLastName";
        
    	//WHEN
		when(userAccount.getEmailAddress()).thenReturn(anotherEmailAddress);
		when(userAccount.getPassword()).thenReturn(password);
		when(userAccount.getFirstName()).thenReturn(firstName);
		when(userAccount.getLastName()).thenReturn(lastName);
		
		when(anotherUserAccount.getPassword()).thenReturn(anotherPassword);
		when(anotherUserAccount.getFirstName()).thenReturn(anotherFirstName);
		when(anotherUserAccount.getLastName()).thenReturn(anotherLastName);
		
		when(userAccountRepository.selectUserAcount(anotherEmailAddress)).thenReturn(anotherUserAccount);
	       	
    	//THEN
        assertEquals(false, userAccountService.createUserAccount(userAccount));
	}
	
	@Test
	void test_getUserAccount() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(userAccountRepository.selectUserAcount(emailAddress)).thenReturn(userAccount);
	    
    	//THEN
        assertEquals(userAccount, userAccountService.getUserAccount(emailAddress));
	}
	
	@Test
	void test_editUserAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String password = "password";
		String firstName = "firstName";
		String lastName = "lastName";
        
    	//WHEN
		when(userAccount.getEmailAddress()).thenReturn(emailAddress);
		when(userAccount.getPassword()).thenReturn(password);
		when(userAccount.getFirstName()).thenReturn(firstName);
		when(userAccount.getLastName()).thenReturn(lastName);
		when(userAccountRepository.selectUserAcount(emailAddress)).thenReturn(userAccount);
	    
    	//THEN
        assertEquals(true, userAccountService.editUserAccount(userAccount));
	}

	@Test
	void test_editUserAccount_false() {

    	//GIVEN
		String anotherEmailAddress = "anotherEmailAddress";
		String password = "password";
		String anotherPassword = "anotherPassword";
		String firstName = "firstName";
		String anotherFirstName = "anotherFirstName";
		String lastName = "lastName";
		String anotherLastName = "anotherLastName";
        
    	//WHEN
		when(userAccount.getEmailAddress()).thenReturn(anotherEmailAddress);
		when(userAccount.getPassword()).thenReturn(password);
		when(userAccount.getFirstName()).thenReturn(firstName);
		when(userAccount.getLastName()).thenReturn(lastName);
		
		when(anotherUserAccount.getPassword()).thenReturn(anotherPassword);
		when(anotherUserAccount.getFirstName()).thenReturn(anotherFirstName);
		when(anotherUserAccount.getLastName()).thenReturn(anotherLastName);
		
		when(userAccountRepository.selectUserAcount(anotherEmailAddress)).thenReturn(anotherUserAccount);
	       	
    	//THEN
        assertEquals(false, userAccountService.editUserAccount(userAccount));
	}
	
	@Test
	void test_deleteUserAccount_true() {

    	//GIVEN
		int id = -1;
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(userAccount.getId()).thenReturn(id);
		when(userAccountRepository.selectUserAcount(emailAddress)).thenReturn(userAccount);
	    
    	//THEN
        assertEquals(true, userAccountService.deleteUserAccount(emailAddress));
	}
	
	@Test
	void test_deleteUserAccount_false() {

    	//GIVEN
		int anotherId = 1;
		String anotherEmailAddress = "anotherEmailAddress";
        
    	//WHEN
		when(anotherUserAccount.getId()).thenReturn(anotherId);
		when(userAccountRepository.selectUserAcount(anotherEmailAddress)).thenReturn(anotherUserAccount);
	    
    	//THEN
        assertEquals(false, userAccountService.deleteUserAccount(anotherEmailAddress));
	}
	
	@Test
	void test_loginUserAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String password = "password";
        
    	//WHEN
		when(userAccount.getPassword()).thenReturn(password);
		when(userAccountRepository.selectUserAcount(emailAddress)).thenReturn(userAccount);
	    
    	//THEN
        assertEquals(true, userAccountService.loginUserAccount(emailAddress, password));
	}
	
	@Test
	void test_loginUserAccount_false() {

    	//GIVEN
		String anotherEmailAddress = "anotherEmailAddress";
		String password = "password";
		String anotherPassword = "anotherPassword";
        
    	//WHEN
		when(anotherUserAccount.getPassword()).thenReturn(anotherPassword);
		when(userAccountRepository.selectUserAcount(anotherEmailAddress)).thenReturn(anotherUserAccount);
	    
    	//THEN
        assertEquals(false, userAccountService.loginUserAccount(anotherEmailAddress, password));
	}
}
