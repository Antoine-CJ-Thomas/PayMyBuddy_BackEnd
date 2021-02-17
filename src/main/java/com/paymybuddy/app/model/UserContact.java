package com.paymybuddy.app.model;

public class UserContact {

	private int id;
	private String emailAdresse;
	private String firstName;
	private String lastName;

	public UserContact(int id, String emailAdresse, String firstName, String lastName) {
		
		this.id = id;
		this.emailAdresse = emailAdresse;
		this.firstName = firstName;
		this.lastName = lastName;
	}

	public int getId() {
		return id;
	}

	public String getEmailAdresse() {
		return emailAdresse;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}
}
