package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.model.BankAccount;

@SpringBootTest
class BankAccountRetrievingDtoTest {

	private BankAccountRetrievingDto bankAccountRetrievingDto;
	
	@Mock
	private ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
    
	@BeforeEach
	void beforeEach() {

		bankAccountRetrievingDto = new BankAccountRetrievingDto(null);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		bankAccountRetrievingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, bankAccountRetrievingDto.getEmailAddress());
	}
	
	@Test
	void test_setAndGetBankAccountList() {

    	//GIVEN
        
    	//WHEN
		bankAccountRetrievingDto.setBankAccountList(bankAccountList);
    	
    	//THEN
        assertEquals(bankAccountList, bankAccountRetrievingDto.getBankAccountList());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		bankAccountRetrievingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, bankAccountRetrievingDto.isDataValidated());
	}
}
