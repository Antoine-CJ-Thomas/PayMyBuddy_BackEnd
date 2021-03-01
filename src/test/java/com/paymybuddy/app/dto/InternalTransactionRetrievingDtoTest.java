package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.InternalTransaction;

@SpringBootTest
class InternalTransactionRetrievingDtoTest {

	private InternalTransactionRetrievingDto internalTransactionRetrievingDto;
	
	@Mock
	private ArrayList<InternalTransaction> internalTransactionList = new ArrayList<InternalTransaction>();
    
	@BeforeEach
	void beforeEach() {

		internalTransactionRetrievingDto = new InternalTransactionRetrievingDto(null, null, null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		internalTransactionRetrievingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, internalTransactionRetrievingDto.getEmailAddress());
	}
	
	@Test
	void test_setAndGetInternalTransactionList() {

    	//GIVEN
        
    	//WHEN
		internalTransactionRetrievingDto.setInternalTransactionList(internalTransactionList);
    	
    	//THEN
        assertEquals(internalTransactionList, internalTransactionRetrievingDto.getInternalTransactionList());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		internalTransactionRetrievingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, internalTransactionRetrievingDto.isDataValidated());
	}
}
