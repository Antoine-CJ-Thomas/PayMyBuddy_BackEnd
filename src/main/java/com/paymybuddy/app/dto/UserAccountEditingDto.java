package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.UserAccount;

@Component
public class UserAccountEditingDto {

	private String emailAddress;
	private String password;
	private String firstName;
	private String lastName;
	
	private UserAccount userAccount = new UserAccount();
	private boolean dataValidated;
	
	public UserAccountEditingDto() {}
	
	public UserAccountEditingDto(String emailAddress, String password, String firstName, String lastName) {
		
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

	public UserAccount getUserAccount() {
		return userAccount;
	}

	public void setUserAccount(UserAccount userAccount) {
		this.userAccount = userAccount;
	}

	public boolean isDataValidated() {
		return dataValidated;
	}

	public void setDataValidated(boolean dataValidated) {
		this.dataValidated = dataValidated;
	}
}
