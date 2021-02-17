package com.paymybuddy.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExternalTransactionTest {

	private ExternalTransaction externalTransaction;
	
	@Mock
	private UserAccount userAccount;
	@Mock
	private BankAccount bankAccount;
    
	@Test
	void test_getDate() {

    	//GIVEN
        
    	//WHEN
		externalTransaction = new ExternalTransaction(null, null, null, 0.0f);
    	
    	//THEN
        assertEquals(false, externalTransaction.getDate().equals(null));
	}
    
	@Test
	void test_getUserAccount() {

    	//GIVEN
        
    	//WHEN
		externalTransaction = new ExternalTransaction(userAccount, null, null, 0.0f);
    	
    	//THEN
        assertEquals(userAccount, externalTransaction.getUserAccount());
	}
    
	@Test
	void test_getBankAccount() {

    	//GIVEN
        
    	//WHEN
		externalTransaction = new ExternalTransaction(null, bankAccount, null, 0.0f);
    	
    	//THEN
        assertEquals(bankAccount, externalTransaction.getBankAccount());
	}
    
	@Test
	void test_getDescription() {

    	//GIVEN
		String description = "descritpion";
        
    	//WHEN
		externalTransaction = new ExternalTransaction(null, null, description, 0.0f);
    	
    	//THEN
        assertEquals(description, externalTransaction.getDescription());
	}
    
	@Test
	void test_getAmount() {

    	//GIVEN
		float amount = 1.0f;
        
    	//WHEN
		externalTransaction = new ExternalTransaction(null, null, null, amount);
    	
    	//THEN
        assertEquals(amount, externalTransaction.getAmount());
	}
}
