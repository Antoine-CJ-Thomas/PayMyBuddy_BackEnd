package com.paymybuddy.app.dto;

import org.springframework.stereotype.Component;

@Component
public class UserAccountDeletingDto {

	private String emailAddress;
	
	private boolean dataValidated;
	private String message;
	
	public UserAccountDeletingDto() {}
	
	public UserAccountDeletingDto(String emailAddress) {
		
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
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
