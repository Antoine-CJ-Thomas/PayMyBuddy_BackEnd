package com.paymybuddy.app.model;

import java.util.Date;

public class ExternalTransaction extends Transaction {

	private BankAccount bankAccount;

	public ExternalTransaction(UserAccount userAccount, BankAccount bankAccount, String description, float amount) {
		
		date = new Date();
		
		this.userAccount = userAccount;
		this.bankAccount = bankAccount;
		this.description = description;
		this.amount = amount;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
}
