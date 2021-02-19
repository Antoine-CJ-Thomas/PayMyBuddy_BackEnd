package com.paymybuddy.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.BankAccount;

@SpringBootTest
class BankAccountRepositoryTest {

	private BankAccountRepository bankAccountRepository;
	
	@Mock
	private BankAccount bankAccount;

	@Test
	void test_resetAccount() {

    	//GIVEN
		bankAccountRepository = new BankAccountRepository();
        
    	//WHEN
		bankAccountRepository.addBankAccount(bankAccount);
		bankAccountRepository.resetBankAccountList();
    	
    	//THEN
        assertEquals(false, bankAccountRepository.getBankAccountList().contains(bankAccount));
	}
    
	@Test
	void test_addBankAccount() {

    	//GIVEN
		bankAccountRepository = new BankAccountRepository();
        
    	//WHEN
		bankAccountRepository.addBankAccount(bankAccount);
    	
    	//THEN
        assertEquals(true, bankAccountRepository.getBankAccountList().contains(bankAccount));
	}

	@Test
	void test_removeBankAccount() {

    	//GIVEN
		bankAccountRepository = new BankAccountRepository();
        
    	//WHEN
		bankAccountRepository.addBankAccount(bankAccount);
		bankAccountRepository.removeBankAccount(0);
    	
    	//THEN
        assertEquals(false, bankAccountRepository.getBankAccountList().contains(bankAccount));
	}
}
