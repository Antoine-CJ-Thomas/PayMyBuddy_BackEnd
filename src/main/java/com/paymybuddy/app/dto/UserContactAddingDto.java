package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

@Component
public class UserContactAddingDto {

	private String userEmailAddress;
	private String contactEmailAddress;
	
	private boolean dataValidated;
	
	public UserContactAddingDto() {}
	
	public UserContactAddingDto(String userEmailAddress, String contactEmailAddress) {
		
		this.userEmailAddress = userEmailAddress;
		this.contactEmailAddress = contactEmailAddress;
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

	public boolean isDataValidated() {
		return dataValidated;
	}

	public void setDataValidated(boolean dataValidated) {
		this.dataValidated = dataValidated;
	}
}
