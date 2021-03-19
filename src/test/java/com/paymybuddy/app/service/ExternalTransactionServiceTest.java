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

import com.paymybuddy.app.dto.ExternalTransactionExecutingDto;
import com.paymybuddy.app.dto.ExternalTransactionRetrievingDto;
import com.paymybuddy.app.model.ExternalTransaction;
import com.paymybuddy.app.repository.ExternalTransactionRepository;

@SpringBootTest
class ExternalTransactionServiceTest {

	private ExternalTransactionService externalTransactionService;

	@Mock
	private ExternalTransactionExecutingDto externalTransactionExecutingDto;
	@Mock
	private ExternalTransactionRetrievingDto externalTransactionRetrievingDto;
	@Mock
	private ExternalTransactionRepository externalTransactionRepository;
	@Mock
	private ExternalTransaction externalTransaction;
	@Mock
	private ArrayList<ExternalTransaction> externalTransactionList;
    
	@BeforeEach
	void beforeEach() {

		externalTransactionService = new ExternalTransactionService();
		ReflectionTestUtils.setField(externalTransactionService, "externalTransactionRepository", externalTransactionRepository);
	}
	
	@Test
	void test_addExternalTransaction_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String acountName = "acountName";
		String description = "description";
		float amount = 0.0f;
        
    	//WHEN
		when(externalTransactionExecutingDto.getEmailAddress()).thenReturn(emailAddress);
		when(externalTransactionExecutingDto.getAccountName()).thenReturn(acountName);
		when(externalTransactionExecutingDto.getDescription()).thenReturn(description);
		when(externalTransactionExecutingDto.getAmount()).thenReturn(amount);
		
		when(externalTransactionRepository.insertExternalTransaction(
				externalTransactionExecutingDto.getEmailAddress(), 
				externalTransactionExecutingDto.getAccountName(), 
				externalTransactionExecutingDto.getDescription(),
				externalTransactionExecutingDto.getAmount())).thenReturn(true);		
		
		externalTransactionService.executeExternalTransaction(externalTransactionExecutingDto);
	    
    	//THEN
        verify(externalTransactionExecutingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_addExternalTransaction_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String acountName = "acountName";
		String description = "description";
		float amount = 0.0f;
        
    	//WHEN
		when(externalTransactionExecutingDto.getEmailAddress()).thenReturn(emailAddress);
		when(externalTransactionExecutingDto.getAccountName()).thenReturn(acountName);
		when(externalTransactionExecutingDto.getDescription()).thenReturn(description);
		when(externalTransactionExecutingDto.getAmount()).thenReturn(amount);
		
		when(externalTransactionRepository.insertExternalTransaction(
				externalTransactionExecutingDto.getEmailAddress(), 
				externalTransactionExecutingDto.getAccountName(), 
				externalTransactionExecutingDto.getDescription(),
				externalTransactionExecutingDto.getAmount())).thenReturn(false);		
		
		externalTransactionService.executeExternalTransaction(externalTransactionExecutingDto);
	    
    	//THEN
        verify(externalTransactionExecutingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_retrieveExternalTransactionList_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(externalTransactionRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(externalTransactionRetrievingDto.getExternalTransactionList()).thenReturn(externalTransactionList);

		when(externalTransactionRepository.selectExternalTransactionList(
				externalTransactionRetrievingDto.getEmailAddress(), 
				externalTransactionRetrievingDto.getExternalTransactionList())).thenReturn(true);
		
		externalTransactionService.retrieveExternalTransactionList(externalTransactionRetrievingDto);
	    
    	//THEN
        verify(externalTransactionRetrievingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_retrieveExternalTransactionList_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(externalTransactionRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(externalTransactionRetrievingDto.getExternalTransactionList()).thenReturn(externalTransactionList);
		
		externalTransactionService.retrieveExternalTransactionList(externalTransactionRetrievingDto);
	    
    	//THEN
        verify(externalTransactionRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
