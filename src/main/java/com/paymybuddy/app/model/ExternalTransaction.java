package com.paymybuddy.app.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class ExternalTransaction extends Transaction {

	private BankAccount bankAccount;

	public ExternalTransaction() {}
	
	public ExternalTransaction(UserAccount userAccount, BankAccount bankAccount, String description, float amount) {
		
		date = new Date();
		
		this.userAccount = userAccount;
		this.bankAccount = bankAccount;
		this.description = description;
		this.amount = amount;
	}

	public void setBankAccount(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}
	
	public BankAccount getBankAccount() {
		return bankAccount;
	}
}
