package com.paymybuddy.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Date;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TransactionTest {

	private Transaction transaction;
	
	@Mock
	private UserAccount userAccount;
    
	@BeforeEach
	void beforeEach() {

		transaction = new Transaction();
	}
    
	@Test
	void test_setAndGetDate() {

    	//GIVEN
		Date date = new Date();
        
    	//WHEN
		transaction.setDate(date);
    	
    	//THEN
        assertEquals(date, transaction.getDate());
	}
    
	@Test
	void test_setAndGetAmount() {

    	//GIVEN
		float amount = 10.0f;
        
    	//WHEN
		transaction.setAmount(amount);
    	
    	//THEN
        assertEquals(amount, transaction.getAmount());
	}
    
	@Test
	void test_setAndGetDescription() {

    	//GIVEN
		String description = "description";
        
    	//WHEN
		transaction.setDescription(description);
    	
    	//THEN
        assertEquals(description, transaction.getDescription());
	}
    
	@Test
	void test_setAndGetUserAccount() {

    	//GIVEN
        
    	//WHEN
		transaction.setUserAccount(userAccount);
    	
    	//THEN
        assertEquals(userAccount, transaction.getUserAccount());
	}
}
