package com.paymybuddy.app.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.InternalTransaction;

@Component
public class InternalTransactionRetrievingDto {

	private String emailAddress;
	
	private ArrayList<InternalTransaction> internalTransactionList = new ArrayList<InternalTransaction>();
	private boolean dataValidated;
	
	public InternalTransactionRetrievingDto() {}
	
	public InternalTransactionRetrievingDto(String emailAddress, String accoundNumber, String swiftCode) {
		
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
}
