package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

/**
 * This class stores the data of a bank account
 */
@Component
public class BankAccount {

	private String accountName;
	private String accountNumber;
	private String swiftCode;

	public BankAccount() {}
	
	public BankAccount(String accountName, String accountNumber, String swiftCode) {

		this.accountName = accountName;
		this.accountNumber = accountNumber;
		this.swiftCode = swiftCode;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
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
