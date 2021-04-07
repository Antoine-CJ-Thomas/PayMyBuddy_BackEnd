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

import com.paymybuddy.app.dto.ExternalTransactionExecutingDto;
import com.paymybuddy.app.dto.ExternalTransactionRetrievingDto;
import com.paymybuddy.app.model.ExternalTransaction;
import com.paymybuddy.app.repository.ExternalTransactionRepository;
import com.paymybuddy.app.service.ExternalTransactionService;

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

    	//GIVEN
		externalTransactionService = new ExternalTransactionService();
		ReflectionTestUtils.setField(externalTransactionService, "externalTransactionRepository", externalTransactionRepository);
	}
	
	@Test
	void test_addExternalTransaction_OK() {
        
    	//WHEN
		when(externalTransactionExecutingDto.getEmailAddress()).thenReturn("emailAddress");
		when(externalTransactionExecutingDto.getAccountName()).thenReturn("acountName");
		when(externalTransactionExecutingDto.getDescription()).thenReturn("description");
		when(externalTransactionExecutingDto.getAmount()).thenReturn(0.0f);
		
		when(externalTransactionRepository.insertExternalTransaction(
				externalTransactionExecutingDto.getEmailAddress(), 
				externalTransactionExecutingDto.getAccountName(), 
				externalTransactionExecutingDto.getDescription(),
				externalTransactionExecutingDto.getAmount())).thenReturn("00000");		
		
		externalTransactionService.executeExternalTransaction(externalTransactionExecutingDto);
	    
    	//THEN
        verify(externalTransactionExecutingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_addExternalTransaction_NOK_balanceInferiorAmount() {
        
    	//WHEN
		when(externalTransactionExecutingDto.getEmailAddress()).thenReturn("emailAddress");
		when(externalTransactionExecutingDto.getAccountName()).thenReturn("acountName");
		when(externalTransactionExecutingDto.getDescription()).thenReturn("description");
		when(externalTransactionExecutingDto.getAmount()).thenReturn(0.0f);
		
		when(externalTransactionRepository.insertExternalTransaction(
				externalTransactionExecutingDto.getEmailAddress(), 
				externalTransactionExecutingDto.getAccountName(), 
				externalTransactionExecutingDto.getDescription(),
				externalTransactionExecutingDto.getAmount())).thenReturn("23502");		
		
		externalTransactionService.executeExternalTransaction(externalTransactionExecutingDto);
	    
    	//THEN
        verify(externalTransactionExecutingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_addExternalTransaction_NOK() {
        
    	//WHEN
		when(externalTransactionExecutingDto.getEmailAddress()).thenReturn("emailAddress");
		when(externalTransactionExecutingDto.getAccountName()).thenReturn("acountName");
		when(externalTransactionExecutingDto.getDescription()).thenReturn("description");
		when(externalTransactionExecutingDto.getAmount()).thenReturn(0.0f);
		
		when(externalTransactionRepository.insertExternalTransaction(
				externalTransactionExecutingDto.getEmailAddress(), 
				externalTransactionExecutingDto.getAccountName(), 
				externalTransactionExecutingDto.getDescription(),
				externalTransactionExecutingDto.getAmount())).thenReturn("");		
		
		externalTransactionService.executeExternalTransaction(externalTransactionExecutingDto);
	    
    	//THEN
        verify(externalTransactionExecutingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_retrieveExternalTransactionList_OK() {
        
    	//WHEN
		when(externalTransactionRetrievingDto.getEmailAddress()).thenReturn("emailAddress");
		when(externalTransactionRetrievingDto.getExternalTransactionList()).thenReturn(externalTransactionList);

		when(externalTransactionRepository.selectExternalTransactionList(
				externalTransactionRetrievingDto.getEmailAddress(), 
				externalTransactionRetrievingDto.getExternalTransactionList())).thenReturn("00000");
		
		externalTransactionService.retrieveExternalTransactionList(externalTransactionRetrievingDto);
	    
    	//THEN
        verify(externalTransactionRetrievingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_retrieveExternalTransactionList_NOK() {
        
    	//WHEN
		when(externalTransactionRetrievingDto.getEmailAddress()).thenReturn("emailAddress");
		when(externalTransactionRetrievingDto.getExternalTransactionList()).thenReturn(externalTransactionList);

		when(externalTransactionRepository.selectExternalTransactionList(
				externalTransactionRetrievingDto.getEmailAddress(), 
				externalTransactionRetrievingDto.getExternalTransactionList())).thenReturn("");
		
		externalTransactionService.retrieveExternalTransactionList(externalTransactionRetrievingDto);
	    
    	//THEN
        verify(externalTransactionRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
