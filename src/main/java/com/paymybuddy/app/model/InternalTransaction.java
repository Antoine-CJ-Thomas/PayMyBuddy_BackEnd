package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

@Component
public class InternalTransaction extends Transaction {

	private UserContact userContact;

	public InternalTransaction() {}
	
	public InternalTransaction(UserContact userContact, String dateAndTime, String description, float amount) {
		
		this.userContact = userContact;
		this.dateAndTime = dateAndTime;
		this.description = description;
		this.amount = amount;
	}

	public UserContact getUserContact() {
		return userContact;
	}

	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}
}
