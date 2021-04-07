package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

/**
 * This class stores the data of a request to create an user account
 */
@Component
public class UserAccountCreatingDto {

	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;

	private boolean dataValidated;
	private String message;
	
	public UserAccountCreatingDto() {}
	
	public UserAccountCreatingDto(String emailAddress, String password, String firstName, String lastName) {
		
		this.emailAddress = emailAddress;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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
