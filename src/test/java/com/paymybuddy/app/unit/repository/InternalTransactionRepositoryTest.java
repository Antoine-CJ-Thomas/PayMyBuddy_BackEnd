package com.paymybuddy.app.unit.repository;

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
import com.paymybuddy.app.model.InternalTransaction;
import com.paymybuddy.app.repository.InternalTransactionRepository;

@SpringBootTest
class InternalTransactionRepositoryTest {

	private InternalTransactionRepository internalTransactionRepository;

	@Mock
	private DataBaseConfig dataBaseConfig;
	@Mock
	private ResultSet resultSet;
	@Mock
	private ArrayList<InternalTransaction> internalTransactionList;
    
	@BeforeEach
	void beforeEach() {

		internalTransactionRepository = new InternalTransactionRepository();
		ReflectionTestUtils.setField(internalTransactionRepository, "dataBaseConfig", dataBaseConfig);
	}
	
	@Test
	void test_insertInternalTransaction() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String contactEmailAddress = "contactEmailAddress";
		String description = "description";
		String sqlState = "00000";
		float amount = 1.0f;
        
    	//WHEN
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, internalTransactionRepository.insertInternalTransaction(userEmailAddress, contactEmailAddress, description, amount));
	}

	@Test
	void test_selectInternalTransactionList() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.executeQuery(any())).thenReturn(resultSet);
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, internalTransactionRepository.selectInternalTransactionList(emailAddress, internalTransactionList));
	}
}
