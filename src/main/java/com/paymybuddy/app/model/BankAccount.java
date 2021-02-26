package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {

	private String accoundNumber;
	private String swiftCode;

	public BankAccount() {}
	
	public BankAccount(String accoundNumber, String swiftCode) {
		
		this.accoundNumber = accoundNumber;
		this.swiftCode = swiftCode;
	}
	
	public void setAccoundNumber(String accoundNUmber) {
		this.accoundNumber = accoundNUmber;
	}
	
	public String getAccoundNumber() {
		return accoundNumber;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
	
	public String getSwiftCode() {
		return swiftCode;
	}
}
