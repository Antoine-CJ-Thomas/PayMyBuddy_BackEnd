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

		externalTransactionExecutingDto = new ExternalTransactionExecutingDto(null, null, null, 0.0f);
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
	void test_setAndGetAccountName() {

    	//GIVEN
		String accountName = "accountName";
        
    	//WHEN
		externalTransactionExecutingDto.setAccountName(accountName);
    	
    	//THEN
        assertEquals(accountName, externalTransactionExecutingDto.getAccountName());
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
