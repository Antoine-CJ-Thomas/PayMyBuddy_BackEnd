package com.paymybuddy.app.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.UserContact;

/**
 * This class stores the data of a request to retrieve a list of contact of an user
 */
@Component
public class UserContactRetrievingDto {

	private String emailAddress;
	
	private ArrayList<UserContact> userContactList = new ArrayList<UserContact>();
	private boolean dataValidated;
	private String message;
	
	public UserContactRetrievingDto() {}
	
	public UserContactRetrievingDto(String emailAddress) {
		
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ArrayList<UserContact> getUserContactList() {
		return userContactList;
	}

	public void setUserContactList(ArrayList<UserContact> userContactList) {
		this.userContactList = userContactList;
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
