package com.paymybuddy.app.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.InternalTransaction;

/**
*
*/
@Component
public class InternalTransactionRepository {

   private static final Logger logger = LogManager.getLogger("UserAccountRepository");

	private ArrayList<InternalTransaction> internalTransactionList = new ArrayList<InternalTransaction>();

	public void resetInternalTransactionList() {
        logger.info("resetInternalTransactionList()");
        internalTransactionList = new ArrayList<InternalTransaction>();
	}
	
	public ArrayList<InternalTransaction> getInternalTransactionList() {
       logger.info("getInternalTransactionList()");
       return internalTransactionList;
	}

	public void addInternalTransaction(InternalTransaction internalTransaction) {
       logger.info("addInternalTransaction(" + internalTransaction + ")");
       internalTransactionList.add(internalTransaction);
	}

	public void removeInternalTransaction(int index) {
       logger.info("removeInternalTransaction(" + index + ")");
       internalTransactionList.remove(index);
	}
}