package com.paymybuddy.app.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankAccountTest {

	private BankAccount bankAccount;
    
	@Test
	void test_getId() {

    	//GIVEN
		int id = 1;
        
    	//WHEN
		bankAccount = new BankAccount(id, null, null);
    	
    	//THEN
        assertEquals(id, bankAccount.getId());
	}

	@Test
	void test_getAccoundNUmber() {

    	//GIVEN
		String accoundNUmber = "accoundNUmber";
        
    	//WHEN
		bankAccount = new BankAccount(0, accoundNUmber, null);
    	
    	//THEN
        assertEquals(accoundNUmber, bankAccount.getAccoundNUmber());
	}

	@Test
	void test_getSwiftCode() {

    	//GIVEN
		String swiftCode = "swiftCode";
        
    	//WHEN
		bankAccount = new BankAccount(0, null, swiftCode);
    	
    	//THEN
        assertEquals(swiftCode, bankAccount.getSwiftCode());
	}
}
