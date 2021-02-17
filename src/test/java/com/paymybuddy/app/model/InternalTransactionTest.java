package com.paymybuddy.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class InternalTransactionTest {

	private InternalTransaction internalTransaction;
	
	@Mock
	private UserAccount userAccount;
	@Mock
	private UserContact userContact;
    
	@Test
	void test_getDate() {

    	//GIVEN
        
    	//WHEN
		internalTransaction = new InternalTransaction(null, null, null, 0.0f);
    	
    	//THEN
        assertEquals(false, internalTransaction.getDate().equals(null));
	}
    
	@Test
	void test_getUserAccount() {

    	//GIVEN
        
    	//WHEN
		internalTransaction = new InternalTransaction(userAccount, null, null, 0.0f);
    	
    	//THEN
        assertEquals(userAccount, internalTransaction.getUserAccount());
	}
    
	@Test
	void test_getUserContact() {

    	//GIVEN
        
    	//WHEN
		internalTransaction = new InternalTransaction(null, userContact, null, 0.0f);
    	
    	//THEN
        assertEquals(userContact, internalTransaction.getUserContact());
	}
    
	@Test
	void test_getDescription() {

    	//GIVEN
		String description = "descritpion";
        
    	//WHEN
		internalTransaction = new InternalTransaction(null, null, description, 0.0f);
    	
    	//THEN
        assertEquals(description, internalTransaction.getDescription());
	}
    
	@Test
	void test_getAmount() {

    	//GIVEN
		float amount = 1.0f;
        
    	//WHEN
		internalTransaction = new InternalTransaction(null, null, null, amount);
    	
    	//THEN
        assertEquals(amount, internalTransaction.getAmount());
	}
}
