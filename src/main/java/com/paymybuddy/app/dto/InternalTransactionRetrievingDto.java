package com.paymybuddy.app.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.InternalTransaction;

/**
 * This class stores the data of a request to retrieve an user internal transaction list
 */
@Component
public class InternalTransactionRetrievingDto {

	private String emailAddress;
	
	private ArrayList<InternalTransaction> internalTransactionList = new ArrayList<InternalTransaction>();
	private boolean dataValidated;
	private String message;
	
	public InternalTransactionRetrievingDto() {}
	
	public InternalTransactionRetrievingDto(String emailAddress) {
		
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ArrayList<InternalTransaction> getInternalTransactionList() {
		return internalTransactionList;
	}

	public void setInternalTransactionList(ArrayList<InternalTransaction> internalTransactionList) {
		this.internalTransactionList = internalTransactionList;
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
