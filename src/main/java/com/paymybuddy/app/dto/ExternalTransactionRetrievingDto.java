package com.paymybuddy.app.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.ExternalTransaction;

@Component
public class ExternalTransactionRetrievingDto {

	private String emailAddress;
	
	private ArrayList<ExternalTransaction> externalTransactionList = new ArrayList<ExternalTransaction>();
	private boolean dataValidated;
	
	public ExternalTransactionRetrievingDto() {}
	
	public ExternalTransactionRetrievingDto(String emailAddress) {
		
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ArrayList<ExternalTransaction> getExternalTransactionList() {
		return externalTransactionList;
	}

	public void setExternalTransactionList(ArrayList<ExternalTransaction> externalTransactionList) {
		this.externalTransactionList = externalTransactionList;
	}

	public boolean isDataValidated() {
		return dataValidated;
	}

	public void setDataValidated(boolean dataValidated) {
		this.dataValidated = dataValidated;
	}
}
