package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

@Component
public class UserContact {

	private String emailAddress;
	private String firstName;
	private String lastName;

	public UserContact() {}
	
	public UserContact(String emailAddress, String firstName, String lastName) {
		
		this.emailAddress = emailAddress;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public void setEmailAddress(String emailAdresse) {
		this.emailAddress = emailAdresse;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getLastName() {
		return lastName;
	}
}
