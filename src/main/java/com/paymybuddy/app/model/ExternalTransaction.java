package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

@Component
public class ExternalTransaction extends Transaction {

	private BankAccount bankAccount;

	public ExternalTransaction() {}
	
	public ExternalTransaction(BankAccount bankAccount, String description, String dateAndTime, float amount) {

		this.bankAccount = bankAccount;
		this.description = description;
		this.dateAndTime = dateAndTime;
		this.amount = amount;
	}

	public BankAccount getBankAccount() {
		return bankAccount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
}
