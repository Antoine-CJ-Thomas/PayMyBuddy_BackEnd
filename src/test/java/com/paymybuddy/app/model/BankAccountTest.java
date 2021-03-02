package com.paymybuddy.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankAccountTest {

	private BankAccount bankAccount;
    
	@BeforeEach
	void beforeEach() {

		bankAccount = new BankAccount(null, null);
	}

	@Test
	void test_setAndGetAccountNumber() {

    	//GIVEN
		String AccountNumber = "AccountNumber";
        
    	//WHEN
		bankAccount.setAccountNumber(AccountNumber);
    	
    	//THEN
        assertEquals(AccountNumber, bankAccount.getAccountNumber());
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
