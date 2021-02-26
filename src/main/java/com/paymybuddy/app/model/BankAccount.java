package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {

	private String accoundNUmber;
	private String swiftCode;

	public BankAccount() {}
	
	public BankAccount(String accoundNUmber, String swiftCode) {
		
		this.accoundNUmber = accoundNUmber;
		this.swiftCode = swiftCode;
	}
	
	public void setAccoundNUmber(String accoundNUmber) {
		this.accoundNUmber = accoundNUmber;
	}
	
	public String getAccoundNUmber() {
		return accoundNUmber;
	}

	public void setSwiftCode(String swiftCode) {
		this.swiftCode = swiftCode;
	}
	
	public String getSwiftCode() {
		return swiftCode;
	}
}
