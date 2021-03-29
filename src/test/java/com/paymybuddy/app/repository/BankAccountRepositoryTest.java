package com.paymybuddy.app.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.sql.ResultSet;
import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.util.ReflectionTestUtils;

import com.paymybuddy.app.config.DataBaseConfig;
import com.paymybuddy.app.model.BankAccount;

@SpringBootTest
class BankAccountRepositoryTest {

	private BankAccountRepository bankAccountRepository;

	@Mock
	private DataBaseConfig dataBaseConfig;
	@Mock
	private ResultSet resultSet;
	@Mock
	private ArrayList<BankAccount> bankAccountList;
    
	@BeforeEach
	void beforeEach() {

		bankAccountRepository = new BankAccountRepository();
		ReflectionTestUtils.setField(bankAccountRepository, "dataBaseConfig", dataBaseConfig);
	}
	
	@Test
	void test_insertBankAccount() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountName = "accountName";
		String accountNumber = "accountNumber";
		String swiftCode = "swiftCode";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, bankAccountRepository.insertBankAccount(emailAddress, accountName, accountNumber, swiftCode));
	}

	@Test
	void test_selectBankAccountList() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.executeQuery(any(ArrayList.class))).thenReturn(resultSet);
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, bankAccountRepository.selectBankAccountList(emailAddress, bankAccountList));
	}
	
	@Test
	void test_deleteBankAccount() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String accountName = "accountName";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, bankAccountRepository.deleteBankAccount(emailAddress, accountName));
	}
}
