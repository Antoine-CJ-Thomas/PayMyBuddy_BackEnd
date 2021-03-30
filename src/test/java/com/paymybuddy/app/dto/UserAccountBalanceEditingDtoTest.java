package com.paymybuddy.app.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UserAccountBalanceEditingDtoTest {

	private UserAccountBalanceEditingDto userAccountBalanceEditingDto;
    
	@BeforeEach
	void beforeEach() {

		userAccountBalanceEditingDto = new UserAccountBalanceEditingDto(null, null, null, null, 0.0f);
	}

	@Test
	void test_setAndGetEmailAddress() {

    	//GIVEN
		String emailAddress = "emailAddress";
        
    	//WHEN
		userAccountBalanceEditingDto.setEmailAddress(emailAddress);
    	
    	//THEN
        assertEquals(emailAddress, userAccountBalanceEditingDto.getEmailAddress());
	}

	@Test
	void test_setAndGetCardNumber() {

    	//GIVEN
		String cardNumber = "cardNumber";
        
    	//WHEN
		userAccountBalanceEditingDto.setCardNumber(cardNumber);
    	
    	//THEN
        assertEquals(cardNumber, userAccountBalanceEditingDto.getCardNumber());
	}

	@Test
	void test_setAndGetCardExpiration() {

    	//GIVEN
		String cardExpiration = "cardExpiration";
        
    	//WHEN
		userAccountBalanceEditingDto.setCardExpiration(cardExpiration);
    	
    	//THEN
        assertEquals(cardExpiration, userAccountBalanceEditingDto.getCardExpiration());
	}

	@Test
	void test_setAndGetCardCryptogram() {

    	//GIVEN
		String cardCryptogram = "cardCryptogram";
        
    	//WHEN
		userAccountBalanceEditingDto.setCardCryptogram(cardCryptogram);
    	
    	//THEN
        assertEquals(cardCryptogram, userAccountBalanceEditingDto.getCardCryptogram());
	}

	@Test
	void test_setAndGetPayementAmount() {

    	//GIVEN
		float payementAmount = 10.0f;
        
    	//WHEN
		userAccountBalanceEditingDto.setPayementAmount(payementAmount);
    	
    	//THEN
        assertEquals(payementAmount, userAccountBalanceEditingDto.getPayementAmount());
	}

	@Test
	void test_setAndGetDataValidated() {

    	//GIVEN
		boolean dataValidated = true;
        
    	//WHEN
		userAccountBalanceEditingDto.setDataValidated(dataValidated);
    	
    	//THEN
        assertEquals(dataValidated, userAccountBalanceEditingDto.isDataValidated());
	}

	@Test
	void test_setAndGetMessage() {

    	//GIVEN
		String message = "message";
        
    	//WHEN
		userAccountBalanceEditingDto.setMessage(message);
    	
    	//THEN
        assertEquals(message, userAccountBalanceEditingDto.getMessage());
	}
}
