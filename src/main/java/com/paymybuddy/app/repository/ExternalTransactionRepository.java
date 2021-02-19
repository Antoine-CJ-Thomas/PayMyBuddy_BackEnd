package com.paymybuddy.app.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.ExternalTransaction;

/**
*
*/
@Component
public class ExternalTransactionRepository {

   private static final Logger logger = LogManager.getLogger("UserAccountRepository");

	private ArrayList<ExternalTransaction> externalTransactionList = new ArrayList<ExternalTransaction>();

	public void resetExternalTransactionList() {
        logger.info("resetExternalTransactionList()");
        externalTransactionList = new ArrayList<ExternalTransaction>();
	}
	
	public ArrayList<ExternalTransaction> getExternalTransactionList() {
       logger.info("getExternalTransactionList()");
       return externalTransactionList;
	}

	public void addExternalTransaction(ExternalTransaction externalTransaction) {
       logger.info("addExternalTransaction(" + externalTransaction + ")");
       externalTransactionList.add(externalTransaction);
	}

	public void removeExternalTransaction(int index) {
       logger.info("removeExternalTransaction(" + index + ")");
       externalTransactionList.remove(index);
	}
}