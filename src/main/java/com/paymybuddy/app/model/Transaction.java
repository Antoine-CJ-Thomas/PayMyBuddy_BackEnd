package com.paymybuddy.app.model;

import java.util.Date;

public class Transaction {
	
	protected Date date;
	protected float amount;
	protected String description;
	protected UserAccount userAccount;

	public Date getDate() {
		return date;
	}
	
	public float getAmount() {
		return amount;
	}
	
	public String getDescription() {
		return description;
	}
	
	public UserAccount getUserAccount() {
		return userAccount;
	}
}
