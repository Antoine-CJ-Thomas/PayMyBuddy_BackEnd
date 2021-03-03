package com.paymybuddy.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.BankAccount;
import com.paymybuddy.app.config.DataBaseConfig;
import com.paymybuddy.app.config.PostgreConfig;

/**
 *
 */
@Component
public class BankAccountRepository {

    private static final Logger logger = LogManager.getLogger("BankAccountRepository");

    private DataBaseConfig dataBaseConfig;
    
    public BankAccountRepository() {
        logger.info("BankAccountRepository()");
    	dataBaseConfig = new PostgreConfig();
    }

	public boolean insertBankAccount(String userEmailAddress, String accountNumber, String swiftCode) {
        logger.info("insertBankAccount(" + userEmailAddress + "," + accountNumber + "," + swiftCode + ")");
				
		String query 	= "INSERT "
						+ "INTO bank_account (user_id,account_number,swift_code) "
						+ "VALUES ("
						
							+ "("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + userEmailAddress + "'"
								
							+ "),("
							
								+ "'" + accountNumber + "'"
								
							+ "),("
							
								+ "'" + swiftCode + "'"
							
							+ ")"
							
						+ ");";
        
		dataBaseConfig.insertQuery(query);
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
	}

	public boolean selectBankAccountList(String emailAddress, ArrayList<BankAccount> bankAccountList) {
        logger.info("selectBankAccountList(" + emailAddress + "," + bankAccountList + ")");
		
		String query 	= "SELECT * "
						+ "FROM bank_account "
						+ "INNER JOIN user_account ON bank_account.user_id = user_account.id "
						+ "WHERE "
						
							+ "user_account.id = ("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + emailAddress + "'"
								
							+ ")"
						+ ";";

		ResultSet resultSet = dataBaseConfig.selectQuery(query);
		
    	try {
    		
			while (resultSet.next()) {
				
				bankAccountList.add(new BankAccount(
						resultSet.getString("account_number"), 
						resultSet.getString("swift_code")));
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

	public boolean deleteBankAccount(String userEmailAddress, String accountNumber, String swiftCode) {
        logger.info("deleteBankAccount(" + userEmailAddress + "," + accountNumber + "," + swiftCode + ")");
        
		String query 	= "DELETE "
						+ "FROM bank_account "
						+ "WHERE "
						
							+ "bank_account.user_id = ("
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + userEmailAddress + "'"
							+ ") "
								
							+ "AND "
							
								+ "bank_account.account_number ='" + accountNumber + "' "
								
							+ "AND "
							
								+ "bank_account.swift_code ='" + swiftCode + "'"
						+ ";";
        
		dataBaseConfig.deleteQuery(query);
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
	}
}
