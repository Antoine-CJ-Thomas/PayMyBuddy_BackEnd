package com.paymybuddy.app.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.dto.BankAccountRemovingDto;
import com.paymybuddy.app.dto.BankAccountRetrievingDto;
import com.paymybuddy.app.service.BankAccountService;

@SpringBootTest
class BankAccountControllerTest {

	private BankAccountController bankAccountController;

	@Mock
	private BankAccountAddingDto bankAccountAddingDto;
	@Mock
	private BankAccountRemovingDto bankAccountRemovingDto;
	@Mock
	private BankAccountRetrievingDto bankAccountRetrievingDto;
	@Mock
	private BankAccountService bankAccountService;
    
	@BeforeEach
	void beforeEach() {

		bankAccountController = new BankAccountController();
		ReflectionTestUtils.setField(bankAccountController, "bankAccountService", bankAccountService);
	}
	
	@Test
	void test_addBankAccount() {

    	//GIVEN
        
    	//WHEN
		when(bankAccountService.addBankAccount(bankAccountAddingDto)).thenReturn(bankAccountAddingDto);
	    
    	//THEN
        assertEquals(bankAccountAddingDto, bankAccountController.addBankAccount(bankAccountAddingDto));
	}
	
	@Test
	void test_removeBankAccount() {

    	//GIVEN
        
    	//WHEN
		when(bankAccountService.removeBankAccount(bankAccountRemovingDto)).thenReturn(bankAccountRemovingDto);
	    
    	//THEN
        assertEquals(bankAccountRemovingDto, bankAccountController.removeBankAccount(bankAccountRemovingDto));
	}

	@Test
	void test_retrieveBankAccountList() {

    	//GIVEN
		String emailAdress = "emailAdress";
        
    	//WHEN
		when(bankAccountService.retrieveBankAccountList(any())).thenReturn(bankAccountRetrievingDto);
	    
    	//THEN
        assertEquals(bankAccountRetrievingDto, bankAccountController.retrieveBankAccountList(emailAdress));
	}
}
