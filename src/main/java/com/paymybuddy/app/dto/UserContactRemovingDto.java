package com.paymybuddy.app.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.UserContact;

@Component
public class UserContactRemovingDto {

	private String userEmailAddress;
	private String contactEmailAddress;
	
	private ArrayList<UserContact> userContactList = new ArrayList<UserContact>();
	private boolean dataValidated;
	
	public UserContactRemovingDto() {}
	
	public UserContactRemovingDto(String userEmailAddress, String contactEmailAddress) {
		
		this.userEmailAddress = userEmailAddress;
		this.contactEmailAddress = contactEmailAddress;
	}

	public String getUserEmailAddress() {
		return userEmailAddress;
	}

	public void setUserEmailAddress(String userEmailAddress) {
		this.userEmailAddress = userEmailAddress;
	}

	public String getContactEmailAddress() {
		return contactEmailAddress;
	}

	public void setContactEmailAddress(String contactEmailAddress) {
		this.contactEmailAddress = contactEmailAddress;
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
}
