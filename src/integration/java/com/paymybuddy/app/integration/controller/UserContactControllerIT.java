package com.paymybuddy.app.integration.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.TestMethodOrder;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.controller.UserAccountController;
import com.paymybuddy.app.controller.UserContactController;
import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.dto.UserContactAddingDto;
import com.paymybuddy.app.dto.UserContactRemovingDto;

@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
@TestInstance(Lifecycle.PER_CLASS)
class UserContactControllerIT {

	@Autowired
	private UserAccountController userAccountController;
	@Autowired
	private UserContactController userContactController;
	
	private String userEmailAddress = "user.test@email";
	private String userPassword = "123";
	private String userFirstName = "user";
	private String userLastName = "test";
	
	private String contactEmailAddress = "contact.test@email";
	private String contactPassword = "123";
	private String contactFirstName = "contact";
	private String contactLastName = "test";
    
	@BeforeEach
	void beforeEach() {

		userAccountController.createUserAccount(new UserAccountCreatingDto(userEmailAddress, userPassword, userFirstName, userLastName));
		userAccountController.createUserAccount(new UserAccountCreatingDto(contactEmailAddress, contactPassword, contactFirstName, contactLastName));
	}
    
	@AfterAll
	void afterAll() {

		userAccountController.deleteUserAccount(new UserAccountDeletingDto(userEmailAddress));
		userAccountController.deleteUserAccount(new UserAccountDeletingDto(contactEmailAddress));	
	}
	
	
	@Test
    @Order(1)
	void test_addUserContact() {

    	//GIVEN
		UserContactAddingDto userContactAddingDto = new UserContactAddingDto(userEmailAddress, contactEmailAddress);
        
    	//WHEN
		userContactController.addUserContact(userContactAddingDto);
	    
    	//THEN
        assertEquals(contactEmailAddress, userContactController.retrieveUserContactList(userEmailAddress).getUserContactList().get(0).getEmailAddress());
	}
	
	@Test
    @Order(2)
	void test_removeUserContact() {

    	//GIVEN
		UserContactRemovingDto userContactRemovingDto = new UserContactRemovingDto(userEmailAddress, contactEmailAddress);
        
    	//WHEN
		userContactController.removeUserContact(userContactRemovingDto);
	    
    	//THEN
        assertEquals(0, userContactController.retrieveUserContactList(userEmailAddress).getUserContactList().size());
	}
}
