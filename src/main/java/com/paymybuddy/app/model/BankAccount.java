package com.paymybuddy.app.model;

import org.springframework.stereotype.Component;

@Component
public class BankAccount {
	
	private int id;
	private String accoundNUmber;
	private String swiftCode;

	public BankAccount() {}
	
	public BankAccount(int id, String accoundNUmber, String swiftCode) {
		
		this.id = id;
		this.accoundNUmber = accoundNUmber;
		this.swiftCode = swiftCode;
	}
	
	public int getId() {
		return id;
	}
	
	public String getAccoundNUmber() {
		return accoundNUmber;
	}
	
	public String getSwiftCode() {
		return swiftCode;
	}
}
