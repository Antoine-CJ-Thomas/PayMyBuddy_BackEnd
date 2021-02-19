package com.paymybuddy.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.InternalTransaction;

@SpringBootTest
class InternalTransactionRepositoryTest {

	private InternalTransactionRepository internalTransactionRepository;
	
	@Mock
	private InternalTransaction internalTransaction;

	@Test
	void test_resetAccount() {

    	//GIVEN
		internalTransactionRepository = new InternalTransactionRepository();
        
    	//WHEN
		internalTransactionRepository.addInternalTransaction(internalTransaction);
		internalTransactionRepository.resetInternalTransactionList();
    	
    	//THEN
        assertEquals(false, internalTransactionRepository.getInternalTransactionList().contains(internalTransaction));
	}
    
	@Test
	void test_addInternalTransaction() {

    	//GIVEN
		internalTransactionRepository = new InternalTransactionRepository();
        
    	//WHEN
		internalTransactionRepository.addInternalTransaction(internalTransaction);
    	
    	//THEN
        assertEquals(true, internalTransactionRepository.getInternalTransactionList().contains(internalTransaction));
	}

	@Test
	void test_removeInternalTransaction() {

    	//GIVEN
		internalTransactionRepository = new InternalTransactionRepository();
        
    	//WHEN
		internalTransactionRepository.addInternalTransaction(internalTransaction);
		internalTransactionRepository.removeInternalTransaction(0);
    	
    	//THEN
        assertEquals(false, internalTransactionRepository.getInternalTransactionList().contains(internalTransaction));
	}
}
