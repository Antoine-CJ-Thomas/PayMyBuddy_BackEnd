package com.paymybuddy.app.unit.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.BankAccount;

@SpringBootTest
class BankAccountTest {

	private BankAccount bankAccount;
    
	@BeforeEach
	void beforeEach() {

		bankAccount = new BankAccount(null, null, null);
	}

	@Test
	void test_setAndGetAccountName() {

    	//GIVEN
		String accountName = "accountName";
        
    	//WHEN
		bankAccount.setAccountName(accountName);
    	
    	//THEN
        assertEquals(accountName, bankAccount.getAccountName());
	}

	@Test
	void test_setAndGetAccountNumber() {

    	//GIVEN
		String accountNumber = "accountNumber";
        
    	//WHEN
		bankAccount.setAccountNumber(accountNumber);
    	
    	//THEN
        assertEquals(accountNumber, bankAccount.getAccountNumber());
	}

	@Test
	void test_setAndGetSwiftCode() {

    	//GIVEN
		String swiftCode = "swiftCode";
        
    	//WHEN
		bankAccount.setSwiftCode(swiftCode);
    	
    	//THEN
        assertEquals(swiftCode, bankAccount.getSwiftCode());
	}
}
