package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

@Component
public class UserAccountDeletingDto {

	private String emailAddress;
	private String password;
	
	private boolean dataValidated;
	
	public UserAccountDeletingDto() {}
	
	public UserAccountDeletingDto(String emailAddress, String password) {
		
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

	public boolean isDataValidated() {
		return dataValidated;
	}

	public void setDataValidated(boolean dataValidated) {
		this.dataValidated = dataValidated;
	}
}
