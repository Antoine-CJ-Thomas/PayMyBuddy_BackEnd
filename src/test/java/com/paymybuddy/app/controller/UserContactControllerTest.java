package com.paymybuddy.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.dto.UserContactAddingDto;
import com.paymybuddy.app.dto.UserContactRemovingDto;
import com.paymybuddy.app.dto.UserContactRetrievingDto;
import com.paymybuddy.app.service.UserContactService;

@SpringBootTest
class UserContactControllerTest {

	private UserContactController userContactController;

	@Mock
	private UserContactAddingDto userContactAddingDto;
	@Mock
	private UserContactRemovingDto userContactRemovingDto;
	@Mock
	private UserContactRetrievingDto userContactRetrievingDto;
	@Mock
	private UserContactService userContactService;
    
	@BeforeEach
	void beforeEach() {

		userContactController = new UserContactController();
		ReflectionTestUtils.setField(userContactController, "userContactService", userContactService);
	}
	
	@Test
	void test_addUserContact() {

    	//GIVEN
        
    	//WHEN
		when(userContactService.addUserContact(userContactAddingDto)).thenReturn(userContactAddingDto);
	    
    	//THEN
        assertEquals(userContactAddingDto, userContactController.addUserContact(userContactAddingDto));
	}
	
	@Test
	void test_removeUserContact() {

    	//GIVEN
        
    	//WHEN
		when(userContactService.removeUserContact(userContactRemovingDto)).thenReturn(userContactRemovingDto);
	    
    	//THEN
        assertEquals(userContactRemovingDto, userContactController.removeUserContact(userContactRemovingDto));
	}

	@Test
	void test_retrieveUserContactList() {

    	//GIVEN
		String emailAdress = "emailAdress";
        
    	//WHEN
		when(userContactService.retrieveUserContactList(any())).thenReturn(userContactRetrievingDto);
	    
    	//THEN
        assertEquals(userContactRetrievingDto, userContactController.retrieveUserContactList(emailAdress));
	}
}
