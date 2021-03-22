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

		userContactService = new UserContactService();
		ReflectionTestUtils.setField(userContactService, "userContactRepository", userContactRepository);
		userContactList = new ArrayList<UserContact>();
	}
	
	@Test
	void test_addUserContact_true() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String contactEmailAddress = "contactEmailAddress";
        
    	//WHEN
		when(userContactAddingDto.getUserEmailAddress()).thenReturn(userEmailAddress);
		when(userContactAddingDto.getContactEmailAddress()).thenReturn(contactEmailAddress);
		
		when(userContactRepository.insertUserContact(
				userContactAddingDto.getUserEmailAddress(), 
				userContactAddingDto.getContactEmailAddress())).thenReturn("00");
		
		userContactService.addUserContact(userContactAddingDto);
	    
    	//THEN
        verify(userContactAddingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_addUserContact_false() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String contactEmailAddress = "contactEmailAddress";
        
    	//WHEN
		when(userContactAddingDto.getUserEmailAddress()).thenReturn(userEmailAddress);
		when(userContactAddingDto.getContactEmailAddress()).thenReturn(contactEmailAddress);
		
		when(userContactRepository.insertUserContact(
				userContactAddingDto.getUserEmailAddress(), 
				userContactAddingDto.getContactEmailAddress())).thenReturn("");
		
		userContactService.addUserContact(userContactAddingDto);
	    
    	//THEN
        verify(userContactAddingDto, Mockito.times(1)).setDataValidated(false);
	}
	
	@Test
	void test_removeUserContact_true() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String contactEmailAddress = "contactEmailAddress";
        
    	//WHEN
		when(userContactRemovingDto.getUserEmailAddress()).thenReturn(userEmailAddress);
		when(userContactRemovingDto.getContactEmailAddress()).thenReturn(contactEmailAddress);
		
		when(userContactRepository.deleteUserContact(
				userContactRemovingDto.getUserEmailAddress(), 
				userContactRemovingDto.getContactEmailAddress())).thenReturn("00");
		
		userContactService.removeUserContact(userContactRemovingDto);
	    
    	//THEN
        verify(userContactRemovingDto, Mockito.times(1)).setDataValidated(true);
	}
	
	@Test
	void test_removeUserContact_false() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String contactEmailAddress = "contactEmailAddress";
        
    	//WHEN
		when(userContactRemovingDto.getUserEmailAddress()).thenReturn(userEmailAddress);
		when(userContactRemovingDto.getContactEmailAddress()).thenReturn(contactEmailAddress);
		
		when(userContactRepository.deleteUserContact(
				userContactRemovingDto.getUserEmailAddress(), 
				userContactRemovingDto.getContactEmailAddress())).thenReturn("");
		
		userContactService.removeUserContact(userContactRemovingDto);
	    
    	//THEN
        verify(userContactRemovingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_retrieveUserContactList_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(userContactRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(userContactRetrievingDto.getUserContactList()).thenReturn(userContactList);
		
		when(userContactRepository.selectUserContactList(
				userContactRetrievingDto.getEmailAddress(), 
				userContactRetrievingDto.getUserContactList())).thenReturn("00");
		
		userContactService.retrieveUserContactList(userContactRetrievingDto);
	    
    	//THEN
        verify(userContactRetrievingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_retrieveUserContactList_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(userContactRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(userContactRetrievingDto.getUserContactList()).thenReturn(userContactList);
		
		when(userContactRepository.selectUserContactList(
				userContactRetrievingDto.getEmailAddress(), 
				userContactRetrievingDto.getUserContactList())).thenReturn("");
		
		userContactService.retrieveUserContactList(userContactRetrievingDto);
	    
    	//THEN
        verify(userContactRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
