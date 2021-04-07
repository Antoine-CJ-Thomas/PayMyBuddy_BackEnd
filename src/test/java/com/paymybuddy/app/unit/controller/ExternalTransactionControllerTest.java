package com.paymybuddy.app.unit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.controller.ExternalTransactionController;
import com.paymybuddy.app.dto.ExternalTransactionExecutingDto;
import com.paymybuddy.app.dto.ExternalTransactionRetrievingDto;
import com.paymybuddy.app.service.ExternalTransactionService;

@SpringBootTest
class ExternalTransactionControllerTest {

	private ExternalTransactionController externalTransactionController;

	@Mock
	private ExternalTransactionExecutingDto externalTransactionExecutingDto;
	@Mock
	private ExternalTransactionRetrievingDto externalTransactionRetrievingDto;
	@Mock
	private ExternalTransactionService externalTransactionService;
    
	@BeforeEach
	void beforeEach() {

		externalTransactionController = new ExternalTransactionController();
		ReflectionTestUtils.setField(externalTransactionController, "externalTransactionService", externalTransactionService);
	}
	
	@Test
	void test_executeExternalTransaction() {

    	//GIVEN
        
    	//WHEN
		when(externalTransactionService.executeExternalTransaction(externalTransactionExecutingDto)).thenReturn(externalTransactionExecutingDto);
	    
    	//THEN
        assertEquals(externalTransactionExecutingDto, externalTransactionController.executeExternalTransaction(externalTransactionExecutingDto));
	}

	@Test
	void test_retrieveExternalTransactionList() {

    	//GIVEN
		String emailAdress = "emailAdress";
        
    	//WHEN
		when(externalTransactionService.retrieveExternalTransactionList(any())).thenReturn(externalTransactionRetrievingDto);
	    
    	//THEN
        assertEquals(externalTransactionRetrievingDto, externalTransactionController.retrieveExternalTransactionList(emailAdress));
	}
}
