package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

@Component
public class BankAccountRemovingDto {

	private String emailAddress;
	private String accountName;
	
	private boolean dataValidated;
	private String message;
	
	public BankAccountRemovingDto() {}
	
	public BankAccountRemovingDto(String emailAddress, String accountName) {
		
		this.emailAddress = emailAddress;
		this.accountName = accountName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
