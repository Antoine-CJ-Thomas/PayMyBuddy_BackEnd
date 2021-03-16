package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

@Component
public class BankAccountAddingDto {

	private String emailAddress;
	private String accountNumber;
	private String swiftCode;
	
	private boolean dataValidated;
	private String message;
	
	public BankAccountAddingDto() {}
	
	public BankAccountAddingDto(String emailAddress, String accountNumber, String swiftCode) {
		
		this.emailAddress = emailAddress;
		this.accountNumber = accountNumber;
		this.swiftCode = swiftCode;
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
