package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.BankAccount;

@SpringBootTest
class BankAccountRemovingDtoTest {

	private BankAccountRemovingDto bankAccountRemovingDto;
	
	@Mock
	private ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
    
	@BeforeEach
	void beforeEach() {

		bankAccountRemovingDto = new BankAccountRemovingDto(null, null, null);
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
	void test_setAndGetAccountNumber() {

    	//GIVEN
		String AccountNumber = "AccountNumber";
        
    	//WHEN
		bankAccountRemovingDto.setAccountNumber(AccountNumber);
    	
    	//THEN
        assertEquals(AccountNumber, bankAccountRemovingDto.getAccountNumber());
	}

	@Test
	void test_setAndGetSwiftCode() {

    	//GIVEN
		String swiftCode = "swiftCode";
        
    	//WHEN
		bankAccountRemovingDto.setSwiftCode(swiftCode);
    	
    	//THEN
        assertEquals(swiftCode, bankAccountRemovingDto.getSwiftCode());
	}
    
	@Test
	void test_setAndGetBankAccountList() {

    	//GIVEN
        
    	//WHEN
		bankAccountRemovingDto.setBankAccountList(bankAccountList);
    	
    	//THEN
        assertEquals(bankAccountList, bankAccountRemovingDto.getBankAccountList());
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
}
