package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {

	private String accountNumber;
	private String swiftCode;

	public BankAccount() {}
	
	public BankAccount(String accountNumber, String swiftCode) {
		
		this.accountNumber = accountNumber;
		this.swiftCode = swiftCode;
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
}
