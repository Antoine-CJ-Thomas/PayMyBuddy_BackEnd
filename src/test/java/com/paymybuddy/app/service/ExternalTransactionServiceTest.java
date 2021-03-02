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
import com.paymybuddy.app.model.BankAccount;
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
	private BankAccount bankAccount;
	
	private ArrayList<ExternalTransaction> ExternalTransactionList;
    
	@BeforeEach
	void beforeEach() {

		externalTransactionService = new ExternalTransactionService();
		ReflectionTestUtils.setField(externalTransactionService, "externalTransactionRepository", externalTransactionRepository);
		ExternalTransactionList = new ArrayList<ExternalTransaction>();
	}
	
	@Test
	void test_addExternalTransaction_true() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String acountNumber = "acountNumber";
		String swiftCode = "swiftCode";
		String requestDateAndTime = "2021.00.00.00.00.0";
		String transactionDateAndTime = "2021.00.00.00.01.0";
        
    	//WHEN
		when(externalTransactionExecutingDto.getEmailAddress()).thenReturn(userEmailAddress);
		when(externalTransactionExecutingDto.getAccountNumber()).thenReturn(acountNumber);
		when(externalTransactionExecutingDto.getSwiftCode()).thenReturn(swiftCode);
		when(externalTransactionExecutingDto.getDateAndTime()).thenReturn(requestDateAndTime);
		when(externalTransactionExecutingDto.getExternalTransactionList()).thenReturn(ExternalTransactionList);
		when(externalTransaction.getDateAndTime()).thenReturn(transactionDateAndTime);
		when(externalTransaction.getBankAccount()).thenReturn(bankAccount);
		when(bankAccount.getAccountNumber()).thenReturn(acountNumber);
		when(bankAccount.getSwiftCode()).thenReturn(swiftCode);
		ExternalTransactionList.add(externalTransaction);
		
		
		externalTransactionService.executeExternalTransaction(externalTransactionExecutingDto);
	    
    	//THEN
        verify(externalTransactionExecutingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_addExternalTransaction_false() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String acountNumber = "acountNumber";
		String swiftCode = "swiftCode";
		String requestDateAndTime = "2021.00.00.00.02.0";
		String transactionDateAndTime = "2021.00.00.00.01.0";
        
    	//WHEN
		when(externalTransactionExecutingDto.getEmailAddress()).thenReturn(userEmailAddress);
		when(externalTransactionExecutingDto.getAccountNumber()).thenReturn(acountNumber);
		when(externalTransactionExecutingDto.getSwiftCode()).thenReturn(swiftCode);
		when(externalTransactionExecutingDto.getDateAndTime()).thenReturn(requestDateAndTime);
		when(externalTransactionExecutingDto.getExternalTransactionList()).thenReturn(ExternalTransactionList);
		when(externalTransaction.getDateAndTime()).thenReturn(transactionDateAndTime);
		when(externalTransaction.getBankAccount()).thenReturn(bankAccount);
		when(bankAccount.getAccountNumber()).thenReturn(acountNumber);
		when(bankAccount.getSwiftCode()).thenReturn(swiftCode);
		ExternalTransactionList.add(externalTransaction);
		
		
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
		when(externalTransactionRetrievingDto.getExternalTransactionList()).thenReturn(ExternalTransactionList);
		ExternalTransactionList.add(externalTransaction);
		
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
		when(externalTransactionRetrievingDto.getExternalTransactionList()).thenReturn(ExternalTransactionList);
		
		externalTransactionService.retrieveExternalTransactionList(externalTransactionRetrievingDto);
	    
    	//THEN
        verify(externalTransactionRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
