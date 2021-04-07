package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

/**
 * This class stores the data of a request to execute an user internal transaction
 */
@Component
public class InternalTransactionExecutingDto {

	private String userEmailAddress;
	private String contactEmailAddress;
	private String description;
	private float amount;
	
	private boolean dataValidated;
	private String message;
	
	public InternalTransactionExecutingDto() {}
	
	public InternalTransactionExecutingDto(String userEmailAddress, String contactEmailAddress, String description, float amount) {

		this.userEmailAddress = userEmailAddress;
		this.contactEmailAddress = contactEmailAddress;
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

	public boolean isDataValidated() {
		return dataValidated;
	}

	public void setDataValidated(boolean dataValidated) {
		this.dataValidated = dataValidated;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
