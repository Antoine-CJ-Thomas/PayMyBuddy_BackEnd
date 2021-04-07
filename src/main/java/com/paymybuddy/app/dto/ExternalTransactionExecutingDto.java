package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

@Component
public class ExternalTransactionExecutingDto {

	private String emailAddress;
	private String accountName;
	private String description;
	private float amount;
	
	private boolean dataValidated;
	private String message;
	
	public ExternalTransactionExecutingDto() {}
	
	public ExternalTransactionExecutingDto(String emailAddress, String accountName, String description, float amount) {

		this.emailAddress = emailAddress;
		this.accountName = accountName;
		this.description = description;
		this.amount = amount;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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
