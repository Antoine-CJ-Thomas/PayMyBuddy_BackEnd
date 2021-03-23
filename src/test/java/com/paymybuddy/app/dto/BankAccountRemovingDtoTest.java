package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BankAccountRemovingDtoTest {

	private BankAccountRemovingDto bankAccountRemovingDto;
    
	@BeforeEach
	void beforeEach() {

		bankAccountRemovingDto = new BankAccountRemovingDto(null, null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		bankAccountRemovingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, bankAccountRemovingDto.getEmailAddress());
	}

	@Test
	void test_setAndGetAccountName() {

    	//GIVEN
		String AccountName = "AccountName";
        
    	//WHEN
		bankAccountRemovingDto.setAccountName(AccountName);
    	
    	//THEN
        assertEquals(AccountName, bankAccountRemovingDto.getAccountName());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		bankAccountRemovingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, bankAccountRemovingDto.isDataValidated());
	}

	@Test
	void test_setAndGetMessage() {

    	//GIVEN
		String message = "message";
        
    	//WHEN
		bankAccountRemovingDto.setMessage(message);
    	
    	//THEN
        assertEquals(message, bankAccountRemovingDto.getMessage());
	}
}
