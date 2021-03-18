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

import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.dto.BankAccountRemovingDto;
import com.paymybuddy.app.dto.BankAccountRetrievingDto;
import com.paymybuddy.app.model.BankAccount;
import com.paymybuddy.app.repository.BankAccountRepository;

@SpringBootTest
class bankAccountServiceTest {

	private BankAccountService bankAccountService;

	@Mock
	private BankAccountAddingDto bankAccountAddingDto;
	@Mock
	private BankAccountRemovingDto bankAccountRemovingDto;
	@Mock
	private BankAccountRetrievingDto bankAccountRetrievingDto;
	@Mock
	private BankAccountRepository bankAccountRepository;
	@Mock
	private ArrayList<BankAccount> bankAccountList;
    
	@BeforeEach
	void beforeEach() {

		bankAccountService = new BankAccountService();
		ReflectionTestUtils.setField(bankAccountService, "bankAccountRepository", bankAccountRepository);
	}
	
	@Test
	void test_addBankAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountName = "accountName";
		String accountNumber = "accountNumber";
		String swiftCode = "swiftCode";
        
    	//WHEN
		when(bankAccountAddingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountAddingDto.getAccountName()).thenReturn(accountName);
		when(bankAccountAddingDto.getAccountNumber()).thenReturn(accountNumber);
		when(bankAccountAddingDto.getSwiftCode()).thenReturn(swiftCode);
		
		when(bankAccountRepository.insertBankAccount(
				bankAccountAddingDto.getEmailAddress(), 
				bankAccountAddingDto.getAccountName(), 
				bankAccountAddingDto.getAccountNumber(), 
				bankAccountAddingDto.getSwiftCode())).thenReturn(true);
		
		bankAccountService.addBankAccount(bankAccountAddingDto);
	    
    	//THEN
        verify(bankAccountAddingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_addBankAccount_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountName = "accountName";
		String accountNumber = "accountNumber";
		String swiftCode = "swiftCode";
        
    	//WHEN
		when(bankAccountAddingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountAddingDto.getAccountName()).thenReturn(accountName);
		when(bankAccountAddingDto.getAccountNumber()).thenReturn(accountNumber);
		when(bankAccountAddingDto.getSwiftCode()).thenReturn(swiftCode);
		
		when(bankAccountRepository.insertBankAccount(
				bankAccountAddingDto.getEmailAddress(), 
				bankAccountAddingDto.getAccountName(), 
				bankAccountAddingDto.getAccountNumber(), 
				bankAccountAddingDto.getSwiftCode())).thenReturn(false);
		
		bankAccountService.addBankAccount(bankAccountAddingDto);
	    
    	//THEN
        verify(bankAccountAddingDto, Mockito.times(1)).setDataValidated(false);
	}
	
	@Test
	void test_removeBankAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountName = "accountName";
        
    	//WHEN
		when(bankAccountRemovingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountRemovingDto.getAccountName()).thenReturn(accountName);
		
		when(bankAccountRepository.deleteBankAccount(
				bankAccountRemovingDto.getEmailAddress(), 
				bankAccountRemovingDto.getAccountName())).thenReturn(true);
		
		bankAccountService.removeBankAccount(bankAccountRemovingDto);
	    
    	//THEN
        verify(bankAccountRemovingDto, Mockito.times(1)).setDataValidated(true);
	}
	
	@Test
	void test_removeBankAccount_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountName = "accountName";
        
    	//WHEN
		when(bankAccountRemovingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountRemovingDto.getAccountName()).thenReturn(accountName);
		
		when(bankAccountRepository.deleteBankAccount(
				bankAccountRemovingDto.getEmailAddress(), 
				bankAccountRemovingDto.getAccountName())).thenReturn(false);
		
		bankAccountService.removeBankAccount(bankAccountRemovingDto);
	    
    	//THEN
        verify(bankAccountRemovingDto, Mockito.times(1)).setDataValidated(false);
	}

	@Test
	void test_retrieveBankAccountList_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(bankAccountRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountRetrievingDto.getBankAccountList()).thenReturn(bankAccountList);
		
		when(bankAccountRepository.selectBankAccountList(
				bankAccountRetrievingDto.getEmailAddress(), 
				bankAccountRetrievingDto.getBankAccountList())).thenReturn(true);
		
		bankAccountService.retrieveBankAccountList(bankAccountRetrievingDto);
	    
    	//THEN
        verify(bankAccountRetrievingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_retrieveBankAccountList_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		when(bankAccountRetrievingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountRetrievingDto.getBankAccountList()).thenReturn(bankAccountList);
		
		when(bankAccountRepository.selectBankAccountList(
				bankAccountRetrievingDto.getEmailAddress(), 
				bankAccountRetrievingDto.getBankAccountList())).thenReturn(false);
		
		bankAccountService.retrieveBankAccountList(bankAccountRetrievingDto);
	    
    	//THEN
        verify(bankAccountRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
