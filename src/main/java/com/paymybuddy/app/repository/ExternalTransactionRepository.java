package com.paymybuddy.app.repository;

import java.sql.ResultSet;
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
        logger.info("ExternalTransactionRepository()");
    	dataBaseConfig = new PostgreConfig();
    }

	public boolean insertExternalTransaction(String userEmailAddress, String accountNumber, String swiftCode, String description, float amount) {
        logger.info("insertExternalTransaction(" + userEmailAddress + "," + accountNumber + "," + swiftCode + "," + description + "," + amount + ")");
				
		String query 	= "INSERT "
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
		
		dataBaseConfig.insertQuery(query);
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
	}

	public boolean selectExternalTransactionList(String emailAddress, ArrayList<ExternalTransaction> externalTransactionList) {
        logger.info("selectExternalTransactionList(" + emailAddress + "," + externalTransactionList + ")");
		
		String query 	= "SELECT * "
						+ "FROM external_transaction "
						+ "INNER JOIN bank_account ON external_transaction.bank_id = bank_account.id "
						+ "WHERE "
						
							+ "external_transaction.user_id = ("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + emailAddress + "'"
								
							+ ")"
						+ ";";

		ResultSet resultSet = dataBaseConfig.selectQuery(query);
		
    	try {
    		
			while (resultSet.next()) {
				
				externalTransactionList.add(new ExternalTransaction(
						
						new BankAccount(resultSet.getString("account_name"), resultSet.getString("account_number"), resultSet.getString("swift_code")), 
						new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(resultSet.getTimestamp("date_time")), 
						resultSet.getString("description"),
						(resultSet.getFloat("amount")*(-1))));
			}

		} catch (SQLException e) {
			e.printStackTrace();
            
		} finally {
			
			try {
				
				if (resultSet != null) {
					resultSet.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
	}
}
