package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.UserAccount;

@Component
public class UserAccountRetrievingDto {

	private String emailAddress;
	
	private UserAccount userAccount = new UserAccount();
	private boolean dataValidated;
	private String message;
	
	public UserAccountRetrievingDto() {}
	
	public UserAccountRetrievingDto(String emailAddress) {
		
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
