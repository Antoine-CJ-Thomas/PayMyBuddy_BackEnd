package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

@Component
public class Transaction {

	protected String description;
	protected float amount;
	protected String dateAndTime;

	public Transaction() {}

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

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
}
