package com.paymybuddy.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.ExternalTransaction;

@SpringBootTest
class ExternalTransactionRepositoryTest {

	private ExternalTransactionRepository externalTransactionRepository;
	
	@Mock
	private ExternalTransaction externalTransaction;

	@Test
	void test_resetAccount() {

    	//GIVEN
		externalTransactionRepository = new ExternalTransactionRepository();
        
    	//WHEN
		externalTransactionRepository.addExternalTransaction(externalTransaction);
		externalTransactionRepository.resetExternalTransactionList();
    	
    	//THEN
        assertEquals(false, externalTransactionRepository.getExternalTransactionList().contains(externalTransaction));
	}
    
	@Test
	void test_addExternalTransaction() {

    	//GIVEN
		externalTransactionRepository = new ExternalTransactionRepository();
        
    	//WHEN
		externalTransactionRepository.addExternalTransaction(externalTransaction);
    	
    	//THEN
        assertEquals(true, externalTransactionRepository.getExternalTransactionList().contains(externalTransaction));
	}

	@Test
	void test_removeExternalTransaction() {

    	//GIVEN
		externalTransactionRepository = new ExternalTransactionRepository();
        
    	//WHEN
		externalTransactionRepository.addExternalTransaction(externalTransaction);
		externalTransactionRepository.removeExternalTransaction(0);
    	
    	//THEN
        assertEquals(false, externalTransactionRepository.getExternalTransactionList().contains(externalTransaction));
	}
}
