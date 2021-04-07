package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

@Component
public class UserAccount {

	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;
	private float balanceAmount;
	
	public UserAccount() {}

	public UserAccount(String emailAddress, String password, String firstName, String lastName, float balanceAmount) {
		
		this.emailAddress = emailAddress;
		this.password = password;
		this.firstName = firstName;
		this.lastName = lastName;
		this.balanceAmount = balanceAmount;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPassword() {
		return password;
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

	public void setBalanceAmount(float balanceAmount) {
		this.balanceAmount = balanceAmount;
	}

	public float getBalanceAmount() {
		return balanceAmount;
	}
}
