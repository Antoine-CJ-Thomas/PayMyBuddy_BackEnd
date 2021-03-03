package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ExternalTransactionExecutingDtoTest {

	private ExternalTransactionExecutingDto externalTransactionExecutingDto;
    
	@BeforeEach
	void beforeEach() {

		externalTransactionExecutingDto = new ExternalTransactionExecutingDto(null, null, null, null, null, 0.0f);
	}

	@Test
	void test_setAndGetUserEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		externalTransactionExecutingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, externalTransactionExecutingDto.getEmailAddress());
	}

	@Test
	void test_setAndGetAccountNumber() {

    	//GIVEN
		String accountNumber = "accountNumber";
        
    	//WHEN
		externalTransactionExecutingDto.setAccountNumber(accountNumber);
    	
    	//THEN
        assertEquals(accountNumber, externalTransactionExecutingDto.getAccountNumber());
	}

	@Test
	void test_setAndGetSwiftCode() {

    	//GIVEN
		String swiftCode = "swiftCode";
        
    	//WHEN
		externalTransactionExecutingDto.setSwiftCode(swiftCode);
    	
    	//THEN
        assertEquals(swiftCode, externalTransactionExecutingDto.getSwiftCode());
	}
    
	@Test
	void test_setAndGetDate() {

    	//GIVEN
		String dateAndTime = "dateAndTime";
        
    	//WHEN
		externalTransactionExecutingDto.setDateAndTime(dateAndTime);
    	
    	//THEN
        assertEquals(dateAndTime, externalTransactionExecutingDto.getDateAndTime());
	}
    
	@Test
	void test_setAndGetDescription() {

    	//GIVEN
		String description = "description";
        
    	//WHEN
		externalTransactionExecutingDto.setDescription(description);
    	
    	//THEN
        assertEquals(description, externalTransactionExecutingDto.getDescription());
	}
    
	@Test
	void test_setAndGetAmount() {

    	//GIVEN
		float amount = 10.0f;
        
    	//WHEN
		externalTransactionExecutingDto.setAmount(amount);
    	
    	//THEN
        assertEquals(amount, externalTransactionExecutingDto.getAmount());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		externalTransactionExecutingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, externalTransactionExecutingDto.isDataValidated());
	}
}
