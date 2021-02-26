package com.paymybuddy.app.model;

import java.util.Date;

import org.springframework.stereotype.Component;

@Component
public class InternalTransaction extends Transaction {

	private UserContact userContact;

	public InternalTransaction() {}
	
	public InternalTransaction(UserAccount userAccount, UserContact userContact, String description, float amount) {
		
		date = new Date();
		
		this.userAccount = userAccount;
		this.userContact = userContact;
		this.description = description;
		this.amount = amount;
	}

	public void setUserContact(UserContact userContact) {
		this.userContact = userContact;
	}

	public UserContact getUserContact() {
		return userContact;
	}
}
