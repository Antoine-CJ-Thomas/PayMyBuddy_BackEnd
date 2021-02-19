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
		userAccountRepository.setUserAccount(userAccount);
    	
    	//THEN
        assertEquals(userAccount, userAccountRepository.getUserAccount());
	}

	@Test
	void test_resetAccount() {

    	//GIVEN
		userAccountRepository = new UserAccountRepository();
        
    	//WHEN
		userAccountRepository.setUserAccount(userAccount);
		userAccountRepository.resetAccount();
    	
    	//THEN
        assertEquals(null, userAccountRepository.getUserAccount());
	}
}
