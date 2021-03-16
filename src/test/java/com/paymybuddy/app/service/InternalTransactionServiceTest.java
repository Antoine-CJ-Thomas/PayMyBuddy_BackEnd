package com.paymybuddy.app.service;

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

		internalTransactionService = new InternalTransactionService();
		ReflectionTestUtils.setField(internalTransactionService, "internalTransactionRepository", internalTransactionRepository);
	}
	
	@Test
	void test_addInternalTransaction_true() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String contactEmailAddress = "contactEmailAddress";
		String description = "description";
		float amount = 0.0f;
        
    	//WHEN
		when(internalTransactionExecutingDto.getUserEmailAddress()).thenReturn(userEmailAddress);
		when(internalTransactionExecutingDto.getContactEmailAddress()).thenReturn(contactEmailAddress);
		when(internalTransactionExecutingDto.getDescription()).thenReturn(description);
		when(internalTransactionExecutingDto.getAmount()).thenReturn(amount);
	
		when(internalTransactionRepository.insertInternalTransaction(
				internalTransactionExecutingDto.getUserEmailAddress(), 
				internalTransactionExecutingDto.getContactEmailAddress(), 
				internalTransactionExecutingDto.getDescription(),
				internalTransactionExecutingDto.getAmount())).thenReturn(true);
		
		internalTransactionService.executeInternalTransaction(internalTransactionExecutingDto);
	    
    	//THEN
        verify(internalTransactionExecutingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_addInternalTransaction_false() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String contactEmailAddress = "contactEmailAddress";
		String description = "description";
		float amount = 0.0f;
        
    	//WHEN
		when(internalTransactionExecutingDto.getUserEmailAddress()).thenReturn(userEmailAddress);
		when(internalTransactionExecutingDto.getContactEmailAddress()).thenReturn(contactEmailAddress);
		when(internalTransactionExecutingDto.getDescription()).thenReturn(description);
		when(internalTransactionExecutingDto.getAmount()).thenReturn(amount);
	
		when(internalTransactionRepository.insertInternalTransaction(
				internalTransactionExecutingDto.getUserEmailAddress(), 
				internalTransactionExecutingDto.getContactEmailAddress(), 
				internalTransactionExecutingDto.getDescription(),
				internalTransactionExecutingDto.getAmount())).thenReturn(false);
		
		internalTransactionService.executeInternalTransaction(internalTransactionExecutingDto);
	    
    	//THEN
        verify(internalTransactionExecutingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_retrieveInternalTransactionList_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(internalTransactionRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(internalTransactionRetrievingDto.getInternalTransactionList()).thenReturn(internalTransactionList);

		when(internalTransactionRepository.selectInternalTransactionList(
				internalTransactionRetrievingDto.getEmailAddress(), 
				internalTransactionRetrievingDto.getInternalTransactionList())).thenReturn(true);
		
		internalTransactionService.retrieveInternalTransactionList(internalTransactionRetrievingDto);
	    
    	//THEN
        verify(internalTransactionRetrievingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_retrieveInternalTransactionList_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(internalTransactionRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(internalTransactionRetrievingDto.getInternalTransactionList()).thenReturn(internalTransactionList);

		when(internalTransactionRepository.selectInternalTransactionList(
				internalTransactionRetrievingDto.getEmailAddress(), 
				internalTransactionRetrievingDto.getInternalTransactionList())).thenReturn(false);
		
		internalTransactionService.retrieveInternalTransactionList(internalTransactionRetrievingDto);
	    
    	//THEN
        verify(internalTransactionRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
