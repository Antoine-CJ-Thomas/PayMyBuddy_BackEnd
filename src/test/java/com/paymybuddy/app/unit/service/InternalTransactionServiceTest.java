package com.paymybuddy.app.unit.service;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.dto.InternalTransactionExecutingDto;
import com.paymybuddy.app.dto.InternalTransactionRetrievingDto;
import com.paymybuddy.app.model.InternalTransaction;
import com.paymybuddy.app.repository.InternalTransactionRepository;
import com.paymybuddy.app.service.InternalTransactionService;

@SpringBootTest
class internalTransactionServiceTest {

	private InternalTransactionService internalTransactionService;

	@Mock
	private InternalTransactionExecutingDto internalTransactionExecutingDto;
	@Mock
	private InternalTransactionRetrievingDto internalTransactionRetrievingDto;
	@Mock
	private InternalTransactionRepository internalTransactionRepository;
	@Mock
	private InternalTransaction internalTransaction;
	@Mock
	private ArrayList<InternalTransaction> internalTransactionList;
    
	@BeforeEach
	void beforeEach() {

    	//GIVEN
		internalTransactionService = new InternalTransactionService();
		ReflectionTestUtils.setField(internalTransactionService, "internalTransactionRepository", internalTransactionRepository);
	}
	
	@Test
	void test_addInternalTransaction_OK() {
		
    	//WHEN
		when(internalTransactionExecutingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(internalTransactionExecutingDto.getContactEmailAddress()).thenReturn("contactEmailAddress");
		when(internalTransactionExecutingDto.getDescription()).thenReturn("description");
		when(internalTransactionExecutingDto.getAmount()).thenReturn(0.0f);
	
		when(internalTransactionRepository.insertInternalTransaction(
				internalTransactionExecutingDto.getUserEmailAddress(), 
				internalTransactionExecutingDto.getContactEmailAddress(), 
				internalTransactionExecutingDto.getDescription(),
				internalTransactionExecutingDto.getAmount())).thenReturn("00000");
		
		internalTransactionService.executeInternalTransaction(internalTransactionExecutingDto);
	    
    	//THEN
        verify(internalTransactionExecutingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_addInternalTransaction_NOK_balanceInferiorAmount() {
		
    	//WHEN
		when(internalTransactionExecutingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(internalTransactionExecutingDto.getContactEmailAddress()).thenReturn("contactEmailAddress");
		when(internalTransactionExecutingDto.getDescription()).thenReturn("description");
		when(internalTransactionExecutingDto.getAmount()).thenReturn(0.0f);
	
		when(internalTransactionRepository.insertInternalTransaction(
				internalTransactionExecutingDto.getUserEmailAddress(), 
				internalTransactionExecutingDto.getContactEmailAddress(), 
				internalTransactionExecutingDto.getDescription(),
				internalTransactionExecutingDto.getAmount())).thenReturn("23502");
		
		internalTransactionService.executeInternalTransaction(internalTransactionExecutingDto);
	    
    	//THEN
        verify(internalTransactionExecutingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_addInternalTransaction_NOK() {
		
    	//WHEN
		when(internalTransactionExecutingDto.getUserEmailAddress()).thenReturn("userEmailAddress");
		when(internalTransactionExecutingDto.getContactEmailAddress()).thenReturn("contactEmailAddress");
		when(internalTransactionExecutingDto.getDescription()).thenReturn("description");
		when(internalTransactionExecutingDto.getAmount()).thenReturn(0.0f);
	
		when(internalTransactionRepository.insertInternalTransaction(
				internalTransactionExecutingDto.getUserEmailAddress(), 
				internalTransactionExecutingDto.getContactEmailAddress(), 
				internalTransactionExecutingDto.getDescription(),
				internalTransactionExecutingDto.getAmount())).thenReturn("");
		
		internalTransactionService.executeInternalTransaction(internalTransactionExecutingDto);
	    
    	//THEN
        verify(internalTransactionExecutingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_retrieveInternalTransactionList_OK() {
        
    	//WHEN
		when(internalTransactionRetrievingDto.getEmailAddress()).thenReturn("emailAddress");
		when(internalTransactionRetrievingDto.getInternalTransactionList()).thenReturn(internalTransactionList);

		when(internalTransactionRepository.selectInternalTransactionList(
				internalTransactionRetrievingDto.getEmailAddress(), 
				internalTransactionRetrievingDto.getInternalTransactionList())).thenReturn("00000");
		
		internalTransactionService.retrieveInternalTransactionList(internalTransactionRetrievingDto);
	    
    	//THEN
        verify(internalTransactionRetrievingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_retrieveInternalTransactionList_NOK() {
        
    	//WHEN
		when(internalTransactionRetrievingDto.getEmailAddress()).thenReturn("emailAddress");
		when(internalTransactionRetrievingDto.getInternalTransactionList()).thenReturn(internalTransactionList);

		when(internalTransactionRepository.selectInternalTransactionList(
				internalTransactionRetrievingDto.getEmailAddress(), 
				internalTransactionRetrievingDto.getInternalTransactionList())).thenReturn("");
		
		internalTransactionService.retrieveInternalTransactionList(internalTransactionRetrievingDto);
	    
    	//THEN
        verify(internalTransactionRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
