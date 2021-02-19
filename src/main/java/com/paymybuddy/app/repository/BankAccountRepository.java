package com.paymybuddy.app.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.BankAccount;

/**
*
*/
@Component
public class BankAccountRepository {

   private static final Logger logger = LogManager.getLogger("UserAccountRepository");

	private ArrayList<BankAccount> bankAccountList = new ArrayList<BankAccount>();

	public void resetBankAccountList() {
        logger.info("removeUserAccount()");
        bankAccountList = new ArrayList<BankAccount>();
	}
	
	public ArrayList<BankAccount> getBankAccountList() {
       logger.info("getBankAccountList()");
       return bankAccountList;
	}

	public void addBankAccount(BankAccount bankAccount) {
       logger.info("addBankAccount(" + bankAccount + ")");
       bankAccountList.add(bankAccount);
	}

	public void removeBankAccount(int index) {
       logger.info("removeBankAccount(" + index + ")");
       bankAccountList.remove(index);
	}
}