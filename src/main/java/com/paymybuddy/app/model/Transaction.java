package com.paymybuddy.app.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class Transaction {

	protected Date date;
	protected float amount;
	protected String description;
	protected UserAccount userAccount;

	public Transaction() {}
	
	public void setDate(Date date) {
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}

	public void setAmount(float amount) {
		this.amount = amount;
	}
	
	public float getAmount() {
		return amount;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getDescription() {
		return description;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}
	
	public UserAccount getUserAccount() {
		return userAccount;
	}
}
