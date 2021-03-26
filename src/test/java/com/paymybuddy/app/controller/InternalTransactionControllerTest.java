package com.paymybuddy.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.dto.InternalTransactionExecutingDto;
import com.paymybuddy.app.dto.InternalTransactionRetrievingDto;
import com.paymybuddy.app.service.InternalTransactionService;

@SpringBootTest
class InternalTransactionControllerTest {

	private InternalTransactionController internalTransactionController;

	@Mock
	private InternalTransactionExecutingDto internalTransactionExecutingDto;
	@Mock
	private InternalTransactionRetrievingDto internalTransactionRetrievingDto;
	@Mock
	private InternalTransactionService internalTransactionService;
    
	@BeforeEach
	void beforeEach() {

		internalTransactionController = new InternalTransactionController();
		ReflectionTestUtils.setField(internalTransactionController, "internalTransactionService", internalTransactionService);
	}
	
	@Test
	void test_executeInternalTransaction() {

    	//GIVEN
        
    	//WHEN
		when(internalTransactionService.executeInternalTransaction(internalTransactionExecutingDto)).thenReturn(internalTransactionExecutingDto);
	    
    	//THEN
        assertEquals(internalTransactionExecutingDto, internalTransactionController.executeInternalTransaction(internalTransactionExecutingDto));
	}

	@Test
	void test_retrieveInternalTransactionList() {

    	//GIVEN
		String emailAdress = "emailAdress";
        
    	//WHEN
		when(internalTransactionService.retrieveInternalTransactionList(any())).thenReturn(internalTransactionRetrievingDto);
	    
    	//THEN
        assertEquals(internalTransactionRetrievingDto, internalTransactionController.retrieveInternalTransactionList(emailAdress));
	}
}
