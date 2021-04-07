package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

/**
 * This class stores the data of a request to edit an user account balance
 */
@Component
public class UserAccountBalanceEditingDto {

	private String emailAddress;
	private String cardNumber;
	private String cardExpiration;
	private String cardCryptogram;
	private float payementAmount;
	
	private boolean dataValidated;
	private String message;
	
	public UserAccountBalanceEditingDto() {}
	
	public UserAccountBalanceEditingDto(String emailAddress, String cardNumber, String cardExpiration, String cardCryptogram, float payementAmount) {

		this.emailAddress = emailAddress;
		this.cardNumber = cardNumber;
		this.cardExpiration = cardExpiration;
		this.cardCryptogram = cardCryptogram;
		this.payementAmount = payementAmount;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getCardNumber() {
		return cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public String getCardExpiration() {
		return cardExpiration;
	}

	public void setCardExpiration(String cardExpiration) {
		this.cardExpiration = cardExpiration;
	}

	public String getCardCryptogram() {
		return cardCryptogram;
	}

	public void setCardCryptogram(String cardCryptogram) {
		this.cardCryptogram = cardCryptogram;
	}

	public float getPayementAmount() {
		return payementAmount;
	}

	public void setPayementAmount(float payementAmount) {
		this.payementAmount = payementAmount;
	}

	public boolean isDataValidated() {
		return dataValidated;
	}

	public void setDataValidated(boolean dataValidated) {
		this.dataValidated = dataValidated;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
