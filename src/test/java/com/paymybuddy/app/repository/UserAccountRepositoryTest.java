package com.paymybuddy.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserAccount;

@SpringBootTest
class UserAccountRepositoryTest {

	private UserAccountRepository userAccountRepository;
	
	@Mock
	UserAccount userAccount;
    
	@Test
	void test_setUserAccount() {

    	//GIVEN
		userAccountRepository = new UserAccountRepository();
        
    	//WHEN
    	
    	//THEN
	}

	@Test
	void test_resetAccount() {

    	//GIVEN
		userAccountRepository = new UserAccountRepository();
        
    	//WHEN
    	
    	//THEN
	}
}
