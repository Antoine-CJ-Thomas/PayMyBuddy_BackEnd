package com.paymybuddy.app.model;

public class UserAccount {

	private int id;
	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;
	private float balanceAmount;

	public UserAccount(int id, String emailAddress, String password, String firstName, String lastName, float balanceAmount) {
		
		this.id = id;
		this.emailAddress = emailAddress;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balanceAmount = balanceAmount;
	}

	public int getId() {
		return id;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public String getPassword() {
		return password;
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
