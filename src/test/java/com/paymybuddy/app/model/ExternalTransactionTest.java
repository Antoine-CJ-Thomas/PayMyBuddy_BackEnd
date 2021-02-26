package com.paymybuddy.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExternalTransactionTest {

	private ExternalTransaction externalTransaction;
	
	@Mock
	private BankAccount bankAccount;
    
	@BeforeEach
	void beforeEach() {

		externalTransaction = new ExternalTransaction(null, null, null, 0.0f);
	}
    
	@Test
	void test_setAndGetBankAccount() {

    	//GIVEN
        
    	//WHEN
		externalTransaction.setBankAccount(bankAccount);
    	
    	//THEN
        assertEquals(bankAccount, externalTransaction.getBankAccount());
	}
}
