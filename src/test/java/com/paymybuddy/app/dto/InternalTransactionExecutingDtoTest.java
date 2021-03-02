package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.InternalTransaction;

@SpringBootTest
class InternalTransactionExecutingDtoTest {

	private InternalTransactionExecutingDto internalTransactionExecutingDto;
	
	@Mock
	private ArrayList<InternalTransaction> internalTransactionList = new ArrayList<InternalTransaction>();
    
	@BeforeEach
	void beforeEach() {

		internalTransactionExecutingDto = new InternalTransactionExecutingDto(null, null, null, null, 0.0f);
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
	void test_setAndGetDate() {

    	//GIVEN
		String dateAndTime = "dateAndTime";
        
    	//WHEN
		internalTransactionExecutingDto.setDateAndTime(dateAndTime);
    	
    	//THEN
        assertEquals(dateAndTime, internalTransactionExecutingDto.getDateAndTime());
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
	void test_setAndGetInternalTransactionList() {

    	//GIVEN
        
    	//WHEN
		internalTransactionExecutingDto.setInternalTransactionList(internalTransactionList);
    	
    	//THEN
        assertEquals(internalTransactionList, internalTransactionExecutingDto.getInternalTransactionList());
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
}
