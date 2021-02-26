package com.paymybuddy.app.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.BankAccount;

@Component
public class BankAccountRetrievingDto {

	private String emailAddress;
	
	private ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
	private boolean dataValidated;
	
	public BankAccountRetrievingDto() {}
	
	public BankAccountRetrievingDto(String emailAddress) {
		
		this.emailAddress = emailAddress;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public ArrayList<BankAccount> getBankAccountList() {
		return bankAccountList;
	}

	public void setBankAccountList(ArrayList<BankAccount> bankAccountList) {
		this.bankAccountList = bankAccountList;
	}

	public boolean isDataValidated() {
		return dataValidated;
	}

	public void setDataValidated(boolean dataValidated) {
		this.dataValidated = dataValidated;
	}
}
