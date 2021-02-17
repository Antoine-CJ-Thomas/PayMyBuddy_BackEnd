package com.paymybuddy.app.model;

public class UserAccount {

	private int id;
	private String emailAdress;
	private String password;
	private String firstName;
	private String lastName;
	private float balanceAmount;

	public UserAccount(int id, String emailAdress, String password, String firstName, String lastName, float balanceAmount) {
		
		this.id = id;
		this.emailAdress = emailAdress;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balanceAmount = balanceAmount;
	}

	public int getId() {
		return id;
	}

	public String getEmailAdress() {
		return emailAdress;
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
