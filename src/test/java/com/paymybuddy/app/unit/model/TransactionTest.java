package com.paymybuddy.app.unit.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.Transaction;
import com.paymybuddy.app.model.UserAccount;

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
	void test_setAndGetDescription() {

    	//GIVEN
		String description = "description";
        
    	//WHEN
		transaction.setDescription(description);
    	
    	//THEN
        assertEquals(description, transaction.getDescription());
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
	void test_setAndGetDate() {

    	//GIVEN
		String dateAndTime = "dateAndTime";
        
    	//WHEN
		transaction.setDateAndTime(dateAndTime);
    	
    	//THEN
        assertEquals(dateAndTime, transaction.getDateAndTime());
	}
}
