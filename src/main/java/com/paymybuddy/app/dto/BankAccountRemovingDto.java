package com.paymybuddy.app.dto;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.BankAccount;

@Component
public class BankAccountRemovingDto {

	private String emailAddress;
	private String accoundNumber;
	private String swiftCode;
	
	private ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();
	private boolean dataValidated;
	
	public BankAccountRemovingDto() {}
	
	public BankAccountRemovingDto(String emailAddress, String accoundNumber, String swiftCode) {
		
		this.emailAddress = emailAddress;
		this.accoundNumber = accoundNumber;
		this.swiftCode = swiftCode;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getAccoundNumber() {
		return accoundNumber;
	}

	public void setAccoundNumber(String accoundNUmber) {
		this.accoundNumber = accoundNUmber;
	}

	public String getSwiftCode() {
		return swiftCode;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
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
