package com.paymybuddy.app.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.dto.UserContactAddingDto;
import com.paymybuddy.app.dto.UserContactRemovingDto;
import com.paymybuddy.app.dto.UserContactRetrievingDto;
import com.paymybuddy.app.model.UserContact;
import com.paymybuddy.app.repository.UserContactRepository;

@SpringBootTest
class UserContactServiceTest {

	private UserContactService userContactService;

	@Mock
	private UserContactAddingDto userContactAddingDto;
	@Mock
	private UserContactRemovingDto userContactRemovingDto;
	@Mock
	private UserContactRetrievingDto userContactRetrievingDto;
	@Mock
	private UserContactRepository userContactRepository;
	@Mock
	private ArrayList<UserContact> userContactList;
    
	@BeforeEach
	void beforeEach() {

    	//GIVEN
		userContactService = new UserContactService();
		ReflectionTestUtils.setField(userContactService, "userContactRepository", userContactRepository);
		userContactList = new ArrayList<UserContact>();
	}
	
	@Test
	void test_addUserContact_OK() {
        
    	//WHEN
		when(userContactAddingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(userContactAddingDto.getContactEmailAddress()).thenReturn("contactEmailAddress");
		
		when(userContactRepository.insertUserContact(
				userContactAddingDto.getUserEmailAddress(), 
				userContactAddingDto.getContactEmailAddress())).thenReturn("00000");
		
		userContactService.addUserContact(userContactAddingDto);
	    
    	//THEN
        verify(userContactAddingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_addUserContact_false_userEmailAddressEqualContactEmailAddress() {
        
    	//WHEN
		when(userContactAddingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(userContactAddingDto.getContactEmailAddress()).thenReturn("userEmailAddress");
		
		userContactService.addUserContact(userContactAddingDto);
	    
    	//THEN
        verify(userContactAddingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_addUserContact_false_contactEmailAddressDoesNotExist() {
        
    	//WHEN
		when(userContactAddingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(userContactAddingDto.getContactEmailAddress()).thenReturn("contactEmailAddress");
		
		when(userContactRepository.insertUserContact(
				userContactAddingDto.getUserEmailAddress(), 
				userContactAddingDto.getContactEmailAddress())).thenReturn("23502");
		
		userContactService.addUserContact(userContactAddingDto);
	    
    	//THEN
        verify(userContactAddingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_addUserContact_false_contactAlreadyInContactList() {
        
    	//WHEN
		when(userContactAddingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(userContactAddingDto.getContactEmailAddress()).thenReturn("contactEmailAddress");
		
		when(userContactRepository.insertUserContact(
				userContactAddingDto.getUserEmailAddress(), 
				userContactAddingDto.getContactEmailAddress())).thenReturn("23505");
		
		userContactService.addUserContact(userContactAddingDto);
	    
    	//THEN
        verify(userContactAddingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_addUserContact_NOK() {
        
    	//WHEN
		when(userContactAddingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(userContactAddingDto.getContactEmailAddress()).thenReturn("contactEmailAddress");
		
		when(userContactRepository.insertUserContact(
				userContactAddingDto.getUserEmailAddress(), 
				userContactAddingDto.getContactEmailAddress())).thenReturn("");
		
		userContactService.addUserContact(userContactAddingDto);
	    
    	//THEN
        verify(userContactAddingDto, Mockito.times(1)).setDataValidated(false);
	}
	
	@Test
	void test_removeUserContact_OK() {
        
    	//WHEN
		when(userContactRemovingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(userContactRemovingDto.getContactEmailAddress()).thenReturn("contactEmailAddress");
		
		when(userContactRepository.deleteUserContact(
				userContactRemovingDto.getUserEmailAddress(), 
				userContactRemovingDto.getContactEmailAddress())).thenReturn("00000");
		
		userContactService.removeUserContact(userContactRemovingDto);
	    
    	//THEN
        verify(userContactRemovingDto, Mockito.times(1)).setDataValidated(true);
	}
	
	@Test
	void test_removeUserContact_NOK() {
        
    	//WHEN
		when(userContactRemovingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(userContactRemovingDto.getContactEmailAddress()).thenReturn("contactEmailAddress");
		
		when(userContactRepository.deleteUserContact(
				userContactRemovingDto.getUserEmailAddress(), 
				userContactRemovingDto.getContactEmailAddress())).thenReturn("");
		
		userContactService.removeUserContact(userContactRemovingDto);
	    
    	//THEN
        verify(userContactRemovingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_retrieveUserContactList_OK() {
		
    	//WHEN
		when(userContactRetrievingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userContactRetrievingDto.getUserContactList()).thenReturn(userContactList);
		
		when(userContactRepository.selectUserContactList(
				userContactRetrievingDto.getEmailAddress(), 
				userContactRetrievingDto.getUserContactList())).thenReturn("00000");
		
		userContactService.retrieveUserContactList(userContactRetrievingDto);
	    
    	//THEN
        verify(userContactRetrievingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_retrieveUserContactList_NOK() {
		
    	//WHEN
		when(userContactRetrievingDto.getEmailAddress()).thenReturn("emailAddress");
		when(userContactRetrievingDto.getUserContactList()).thenReturn(userContactList);
		
		when(userContactRepository.selectUserContactList(
				userContactRetrievingDto.getEmailAddress(), 
				userContactRetrievingDto.getUserContactList())).thenReturn("");
		
		userContactService.retrieveUserContactList(userContactRetrievingDto);
	    
    	//THEN
        verify(userContactRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
