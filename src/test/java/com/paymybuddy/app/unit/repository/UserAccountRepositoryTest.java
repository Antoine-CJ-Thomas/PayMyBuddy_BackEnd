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

import com.paymybuddy.app.config.PostgreConfig;
import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.UserAccountRepository;

@SpringBootTest
class UserAccountRepositoryTest {

	private UserAccountRepository userAccountRepository;

	@Mock
	private PostgreConfig dataBaseConfig;
	@Mock
	private ResultSet resultSet;
	@Mock
	private UserAccount userAccount;
    
	@BeforeEach
	void beforeEach() {

		userAccountRepository = new UserAccountRepository();
		ReflectionTestUtils.setField(userAccountRepository, "dataBaseConfig", dataBaseConfig);
	}
	
	@Test
	void test_insertUserAccount() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String password = "password";
		String firstName = "firstName";
		String lastName = "lastName";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, userAccountRepository.insertUserAccount(emailAddress, password, firstName, lastName));
	}

	@Test
	void test_selectUserAccountList() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.executeQuery(any(ArrayList.class))).thenReturn(resultSet);
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, userAccountRepository.selectUserAccount(emailAddress, userAccount));
	}
	
	@Test
	void test_updateUserAccount() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String password = "password";
		String firstName = "firstName";
		String lastName = "lastName";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, userAccountRepository.updateUserAccount(emailAddress, password, firstName, lastName));
	}
	
	@Test
	void test_deleteUserAccount() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, userAccountRepository.deleteUserAccount(emailAddress));
	}
	
	@Test
	void test_updateUserAccountBalance() {

    	//GIVEN
		String emailAddress = "emailAddress";
		float payementAmount = 10.0f;
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, userAccountRepository.updateUserAccountBalance(emailAddress, payementAmount));
	}
}
