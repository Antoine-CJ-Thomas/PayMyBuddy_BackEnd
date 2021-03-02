package com.paymybuddy.app.repository;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.BankAccount;
import com.paymybuddy.app.model.ExternalTransaction;
import com.paymybuddy.app.config.DataBaseConfig;
import com.paymybuddy.app.config.PostgreConfig;

/**
 *
 */
@Component
public class ExternalTransactionRepository {

    private static final Logger logger = LogManager.getLogger("ExternalTransactionRepository");

    private DataBaseConfig dataBaseConfig;
    
    public ExternalTransactionRepository() {
        logger.info("UserContactRepository()");
    	dataBaseConfig = new PostgreConfig();
    }

	public void insertExternalTransaction(String userEmailAddress, String accountNumber, String swiftCode, float amount, String description) {
        logger.info("insertExternalTransaction(" + userEmailAddress + "," + accountNumber + "," + swiftCode + "," + amount + "," + description + ")");
				
		String request 	= "INSERT "
						+ "INTO external_transaction (user_id,bank_id,date_time,amount,description) "
						+ "VALUES ("
						
							+ "("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + userEmailAddress + "'"
								
							+ "),("
							
								+ "SELECT bank_account.id "
								+ "FROM bank_account "
								+ "WHERE ("
								
									+ "bank_account.account_number = '" + accountNumber + "'"
									+ "AND "
									+ "bank_account.swift_code = '" + swiftCode + "'"
									+ "AND "						
									+ "bank_account.user_id = ("
							
										+ "SELECT user_account.id "
										+ "FROM user_account "
										+ "WHERE user_account.email_address = '" + userEmailAddress + "'"
								
									+ ")"
									
								+ ")"
								
							+ "),("
							
								+ "'" + new Timestamp(System.currentTimeMillis()) + "'"
								
							+ "),("
							
								+ amount
							
							+ "),("
							
								+ "'" + description + "'"
							
							+ ")"
							
						+ ");";
		
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		dataBaseConfig.disableAutoCommit();
		dataBaseConfig.executeUpdateStatement(request);
		dataBaseConfig.commit();
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	}

	public void selectExternalTransaction(String emailAddress, ArrayList<ExternalTransaction> externalTransactionList) {
        logger.info("selectExternalTransactionFromUser(" + emailAddress + "," + externalTransactionList + ")");
		
		String request 	= "SELECT * "
						+ "FROM external_transaction "
						+ "INNER JOIN bank_account ON external_transaction.bank_id = bank_account.id "
						+ "WHERE "
						
							+ "external_transaction.user_id = ("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + emailAddress + "'"
								
							+ ")"
						+ ";";
		
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
				
		dataBaseConfig.createResult(request);
				
    	try {
    		
			while (dataBaseConfig.getResult().next()) {
				
				externalTransactionList.add(new ExternalTransaction(
						
						new BankAccount(dataBaseConfig.getResult().getString("account_number"), dataBaseConfig.getResult().getString("swift_code")), 
						new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(dataBaseConfig.getResult().getTimestamp("date_time")), 
						dataBaseConfig.getResult().getString("description"),
						(dataBaseConfig.getResult().getFloat("amount")*(-1))));
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			dataBaseConfig.closeResult();
	    }
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	}
}
