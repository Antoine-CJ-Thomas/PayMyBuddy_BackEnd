package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankAccountAddingDtoTest {

	private BankAccountAddingDto bankAccountAddingDto;
    
	@BeforeEach
	void beforeEach() {

		bankAccountAddingDto = new BankAccountAddingDto(null, null, null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		bankAccountAddingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, bankAccountAddingDto.getEmailAddress());
	}

	@Test
	void test_setAndGetAccountNumber() {

    	//GIVEN
		String AccountNumber = "AccountNumber";
        
    	//WHEN
		bankAccountAddingDto.setAccountNumber(AccountNumber);
    	
    	//THEN
        assertEquals(AccountNumber, bankAccountAddingDto.getAccountNumber());
	}

	@Test
	void test_setAndGetSwiftCode() {

    	//GIVEN
		String swiftCode = "swiftCode";
        
    	//WHEN
		bankAccountAddingDto.setSwiftCode(swiftCode);
    	
    	//THEN
        assertEquals(swiftCode, bankAccountAddingDto.getSwiftCode());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		bankAccountAddingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, bankAccountAddingDto.isDataValidated());
	}
}
