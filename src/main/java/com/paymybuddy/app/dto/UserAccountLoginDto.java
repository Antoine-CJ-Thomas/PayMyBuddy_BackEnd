package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.UserAccount;

@Component
public class UserAccountLoginDto {

	private String emailAddress;
	private String password;

	private UserAccount userAccount = new UserAccount();
	private boolean dataValidated;
	
	public UserAccountLoginDto() {}
	
	public UserAccountLoginDto(String emailAddress, String password) {
		
		this.emailAddress = emailAddress;
		this.password = password;
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
