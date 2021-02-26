package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.paymybuddy.app.model.BankAccount;

@SpringBootTest
class BankAccountAddingDtoTest {

	private BankAccountAddingDto bankAccountAddingDto;
	
	@Mock
	private ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
    
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
	void test_setAndGetAccoundNumber() {

    	//GIVEN
		String accoundNumber = "accoundNumber";
        
    	//WHEN
		bankAccountAddingDto.setAccoundNumber(accoundNumber);
    	
    	//THEN
        assertEquals(accoundNumber, bankAccountAddingDto.getAccoundNumber());
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
	void test_setAndGetBankAccountList() {

    	//GIVEN
        
    	//WHEN
		bankAccountAddingDto.setBankAccountList(bankAccountList);
    	
    	//THEN
        assertEquals(bankAccountList, bankAccountAddingDto.getBankAccountList());
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
