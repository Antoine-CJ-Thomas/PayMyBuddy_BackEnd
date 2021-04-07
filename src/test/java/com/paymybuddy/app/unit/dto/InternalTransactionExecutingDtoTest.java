package com.paymybuddy.app.unit.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.dto.InternalTransactionExecutingDto;

@SpringBootTest
class InternalTransactionExecutingDtoTest {

	private InternalTransactionExecutingDto internalTransactionExecutingDto;
    
	@BeforeEach
	void beforeEach() {

		internalTransactionExecutingDto = new InternalTransactionExecutingDto(null, null, null, 0.0f);
	}

	@Test
	void test_setAndGetUserEmailAddress() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
        
    	//WHEN
		internalTransactionExecutingDto.setUserEmailAddress(userEmailAddress);
    	
    	//THEN
        assertEquals(userEmailAddress, internalTransactionExecutingDto.getUserEmailAddress());
	}

	@Test
	void test_setAndGetContactEmailAddress() {

    	//GIVEN
		String contactEmailAddress = "contactEmailAddress";
        
    	//WHEN
		internalTransactionExecutingDto.setContactEmailAddress(contactEmailAddress);
    	
    	//THEN
        assertEquals(contactEmailAddress, internalTransactionExecutingDto.getContactEmailAddress());
	}
    
	@Test
	void test_setAndGetDescription() {

    	//GIVEN
		String description = "description";
        
    	//WHEN
		internalTransactionExecutingDto.setDescription(description);
    	
    	//THEN
        assertEquals(description, internalTransactionExecutingDto.getDescription());
	}
    
	@Test
	void test_setAndGetAmount() {

    	//GIVEN
		float amount = 10.0f;
        
    	//WHEN
		internalTransactionExecutingDto.setAmount(amount);
    	
    	//THEN
        assertEquals(amount, internalTransactionExecutingDto.getAmount());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		internalTransactionExecutingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, internalTransactionExecutingDto.isDataValidated());
	}

	@Test
	void test_setAndGetMessage() {

    	//GIVEN
		String message = "message";
        
    	//WHEN
		internalTransactionExecutingDto.setMessage(message);
    	
    	//THEN
        assertEquals(message, internalTransactionExecutingDto.getMessage());
	}
}
