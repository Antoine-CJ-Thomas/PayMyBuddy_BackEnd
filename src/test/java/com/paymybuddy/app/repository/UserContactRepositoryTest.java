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

import com.paymybuddy.app.config.PostgreConfig;
import com.paymybuddy.app.model.UserContact;

@SpringBootTest
class UserContactServiceTest {

	private UserContactRepository userContactRepository;

	@Mock
	private PostgreConfig dataBaseConfig;
	@Mock
	private ResultSet resultSet;
	@Mock
	private ArrayList<UserContact> userContactList;
    
	@BeforeEach
	void beforeEach() {

		userContactRepository = new UserContactRepository();
		ReflectionTestUtils.setField(userContactRepository, "dataBaseConfig", dataBaseConfig);
	}
	
	@Test
	void test_insertUserContact() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String contactEmailAddress = "contactEmailAddress";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, userContactRepository.insertUserContact(userEmailAddress, contactEmailAddress));
	}

	@Test
	void test_selectUserContactList() {

    	//GIVEN
		String emailAddress = "emailAddress";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.executeQuery(any(ArrayList.class))).thenReturn(resultSet);
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, userContactRepository.selectUserContactList(emailAddress, userContactList));
	}
	
	@Test
	void test_deleteUserContact() {

    	//GIVEN
		String userEmailAddress = "userEmailAddress";
		String contactEmailAddress = "contactEmailAddress";
		String sqlState = "00000";
        
    	//WHEN
		when(dataBaseConfig.getSQLExceptionState()).thenReturn(sqlState);
	    
    	//THEN
        assertEquals(sqlState, userContactRepository.deleteUserContact(userEmailAddress, contactEmailAddress));
	}
}
