package com.paymybuddy.app.model;

public class UserAccount {

	private int id;
	private String emailAdresse;
	private String firstName;
	private String lastName;
	private float balanceAmount;

	public UserAccount(int id, String emailAdresse, String firstName, String lastName, float balanceAmount) {
		
		this.id = id;
		this.emailAdresse = emailAdresse;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balanceAmount = balanceAmount;
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

	public float getBalanceAmount() {
		return balanceAmount;
	}
}
