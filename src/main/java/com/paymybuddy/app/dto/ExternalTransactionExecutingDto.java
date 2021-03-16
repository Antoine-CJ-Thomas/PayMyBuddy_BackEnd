package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

@Component
public class ExternalTransactionExecutingDto {

	private String emailAddress;
	private String accountNumber;
	private String swiftCode;
	private String description;
	private float amount;
	
	private boolean dataValidated;
	private String message;
	
	public ExternalTransactionExecutingDto() {}
	
	public ExternalTransactionExecutingDto(String emailAddress, String accountNumber, String swiftCode, String description, float amount) {

		this.emailAddress = emailAddress;
		this.accountNumber = accountNumber;
		this.swiftCode = swiftCode;
		this.description = description;
		this.amount = amount;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
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
