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
	private BankAccount bankAccount;
	
	private ArrayList<BankAccount> bankAccountList;
    
	@BeforeEach
	void beforeEach() {

		bankAccountService = new BankAccountService();
		ReflectionTestUtils.setField(bankAccountService, "bankAccountRepository", bankAccountRepository);
		bankAccountList = new ArrayList<BankAccount>();
	}
	
	@Test
	void test_addBankAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountNumber = "accountNumber";
		String swiftCode = "swiftCode";
        
    	//WHEN
		when(bankAccountAddingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountAddingDto.getAccountNumber()).thenReturn(accountNumber);
		when(bankAccountAddingDto.getSwiftCode()).thenReturn(swiftCode);
		when(bankAccountAddingDto.getBankAccountList()).thenReturn(bankAccountList);
		when(bankAccount.getAccountNumber()).thenReturn(accountNumber);
		when(bankAccount.getSwiftCode()).thenReturn(swiftCode);
		bankAccountList.add(bankAccount);
		
		bankAccountService.addBankAccount(bankAccountAddingDto);
	    
    	//THEN
        verify(bankAccountAddingDto, Mockito.times(1)).setDataValidated(true);
	}

	@Test
	void test_addBankAccount_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountNumber = "accountNumber";
		String differentAccountNumber = "differentAccountNumber";
		String swiftCode = "swiftCode";
		String differentSwiftCode = "differentSwiftCode";
        
    	//WHEN
		when(bankAccountAddingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountAddingDto.getAccountNumber()).thenReturn(accountNumber);
		when(bankAccountAddingDto.getSwiftCode()).thenReturn(swiftCode);
		when(bankAccountAddingDto.getBankAccountList()).thenReturn(bankAccountList);
		when(bankAccount.getAccountNumber()).thenReturn(differentAccountNumber);
		when(bankAccount.getSwiftCode()).thenReturn(differentSwiftCode);
		bankAccountList.add(bankAccount);
		
		bankAccountService.addBankAccount(bankAccountAddingDto);
	    
    	//THEN
        verify(bankAccountAddingDto, Mockito.times(1)).setDataValidated(false);
	}
	
	@Test
	void test_removeBankAccount_true() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountNumber = "accountNumber";
		String differentAccountNumber = "differentAccountNumber";
		String swiftCode = "swiftCode";
		String differentSwiftCode = "differentSwiftCode";
        
    	//WHEN
		when(bankAccountRemovingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountRemovingDto.getAccountNumber()).thenReturn(accountNumber);
		when(bankAccountRemovingDto.getSwiftCode()).thenReturn(swiftCode);
		when(bankAccountRemovingDto.getBankAccountList()).thenReturn(bankAccountList);
		when(bankAccount.getAccountNumber()).thenReturn(differentAccountNumber);
		when(bankAccount.getSwiftCode()).thenReturn(differentSwiftCode);
		bankAccountList.add(bankAccount);
		
		bankAccountService.removeBankAccount(bankAccountRemovingDto);
	    
    	//THEN
        verify(bankAccountRemovingDto, Mockito.times(1)).setDataValidated(true);
	}
	
	@Test
	void test_removeBankAccount_false() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountNumber = "accountNumber";
		String swiftCode = "swiftCode";
        
    	//WHEN
		when(bankAccountRemovingDto.getEmailAddress()).thenReturn(emailAddress);
		when(bankAccountRemovingDto.getAccountNumber()).thenReturn(accountNumber);
		when(bankAccountRemovingDto.getSwiftCode()).thenReturn(swiftCode);
		when(bankAccountRemovingDto.getBankAccountList()).thenReturn(bankAccountList);
		when(bankAccount.getAccountNumber()).thenReturn(accountNumber);
		when(bankAccount.getSwiftCode()).thenReturn(swiftCode);
		bankAccountList.add(bankAccount);
		
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
		bankAccountList.add(bankAccount);
		
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
		
		bankAccountService.retrieveBankAccountList(bankAccountRetrievingDto);
	    
    	//THEN
        verify(bankAccountRetrievingDto, Mockito.times(1)).setDataValidated(false);
	}
}
