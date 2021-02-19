package com.paymybuddy.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserContact;

@SpringBootTest
class UserContactRepositoryTest {

	private UserContactRepository userContactRepository;
	
	@Mock
	private UserContact userContact;

	@Test
	void test_resetAccount() {

    	//GIVEN
		userContactRepository = new UserContactRepository();
        
    	//WHEN
		userContactRepository.addUserContact(userContact);
		userContactRepository.resetUserContactList();
    	
    	//THEN
        assertEquals(false, userContactRepository.getUserContactList().contains(userContact));
	}
    
	@Test
	void test_addUserContact() {

    	//GIVEN
		userContactRepository = new UserContactRepository();
        
    	//WHEN
		userContactRepository.addUserContact(userContact);
    	
    	//THEN
        assertEquals(true, userContactRepository.getUserContactList().contains(userContact));
	}

	@Test
	void test_removeUserContact() {

    	//GIVEN
		userContactRepository = new UserContactRepository();
        
    	//WHEN
		userContactRepository.addUserContact(userContact);
		userContactRepository.removeUserContact(0);
    	
    	//THEN
        assertEquals(false, userContactRepository.getUserContactList().contains(userContact));
	}
}
