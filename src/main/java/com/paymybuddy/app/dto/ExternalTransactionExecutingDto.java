package com.paymybuddy.app.dto;

import java.util.ArrayList;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.ExternalTransaction;

@Component
public class ExternalTransactionExecutingDto {

	private String emailAddress;
	private String accountNumber;
	private String swiftCode;
	protected String dateAndTime;
	private String description;
	private float amount;
	
	private ArrayList<ExternalTransaction> externalTransactionList = new ArrayList<ExternalTransaction>();
	private boolean dataValidated;
	
	public ExternalTransactionExecutingDto() {}
	
	public ExternalTransactionExecutingDto(String emailAddress, String accountNumber, String swiftCode, String dateAndTime, String description, float amount) {

		this.emailAddress = emailAddress;
		this.accountNumber = accountNumber;
		this.swiftCode = swiftCode;
		this.dateAndTime = dateAndTime;
		this.description = description;
		this.amount = amount;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}

	public String getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(String dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getAmount() {
		return amount;
	}

	public void setAmount(float amount) {
		this.amount = amount;
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
