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
