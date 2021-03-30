package com.paymybuddy.app.unit.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.dto.ExternalTransactionRetrievingDto;
import com.paymybuddy.app.model.ExternalTransaction;

@SpringBootTest
class ExternalTransactionRetrievingDtoTest {

	private ExternalTransactionRetrievingDto externalTransactionRetrievingDto;
	
	@Mock
	private ArrayList<ExternalTransaction> externalTransactionList = new ArrayList<ExternalTransaction>();
    
	@BeforeEach
	void beforeEach() {

		externalTransactionRetrievingDto = new ExternalTransactionRetrievingDto(null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		externalTransactionRetrievingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, externalTransactionRetrievingDto.getEmailAddress());
	}
	
	@Test
	void test_setAndGetExternalTransactionList() {

    	//GIVEN
        
    	//WHEN
		externalTransactionRetrievingDto.setExternalTransactionList(externalTransactionList);
    	
    	//THEN
        assertEquals(externalTransactionList, externalTransactionRetrievingDto.getExternalTransactionList());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		externalTransactionRetrievingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, externalTransactionRetrievingDto.isDataValidated());
	}

	@Test
	void test_setAndGetMessage() {

    	//GIVEN
		String message = "message";
        
    	//WHEN
		externalTransactionRetrievingDto.setMessage(message);
    	
    	//THEN
        assertEquals(message, externalTransactionRetrievingDto.getMessage());
	}
}
