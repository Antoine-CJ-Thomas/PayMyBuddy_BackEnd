package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

@Component
public class InternalTransactionExecutingDto {

	private String userEmailAddress;
	private String contactEmailAddress;
	protected String dateAndTime;
	private String description;
	private float amount;
	
	private boolean dataValidated;
	
	public InternalTransactionExecutingDto() {}
	
	public InternalTransactionExecutingDto(String userEmailAddress, String contactEmailAddress, String dateAndTime, String description, float amount) {

		this.userEmailAddress = userEmailAddress;
		this.contactEmailAddress = contactEmailAddress;
		this.dateAndTime = dateAndTime;
		this.description = description;
		this.amount = amount;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	public String getContactEmailAddress() {
		return contactEmailAddress;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
	}

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

	public boolean isDataValidated() {
		return dataValidated;
	}

	public void setDataValidated(boolean dataValidated) {
		this.dataValidated = dataValidated;
	}
}
