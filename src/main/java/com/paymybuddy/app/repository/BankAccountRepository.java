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
 * This class allows to prepare queries for the bank account table and send them to the DataBaseConfig
 */
@Component
public class BankAccountRepository {

    private static final Logger logger = LogManager.getLogger("BankAccountRepository");

    private DataBaseConfig dataBaseConfig;
    
    public BankAccountRepository() {
        logger.info("BankAccountRepository()");
    	dataBaseConfig = new PostgreConfig();
    }

	public String insertBankAccount(String userEmailAddress, String accountName, String accountNumber, String swiftCode) {
        logger.info("insertBankAccount(" + userEmailAddress + "," + accountNumber + "," + swiftCode + ")");
        
        ArrayList<String> queryList = new ArrayList<String>();
				
		String insertBankAccountQuery
		
			= "INSERT INTO bank_account (user_id,account_name,account_number,swift_code) VALUES ("
			
				+ "(SELECT user_account.id FROM user_account WHERE user_account.email_address = '" + userEmailAddress + "'),"
				+ "('" + accountName + "'),"
				+ "('" + accountNumber + "'),"
				+ "('" + swiftCode + "'));";

		queryList.add(insertBankAccountQuery);
        
		dataBaseConfig.executeUpdate(queryList);
		
		return dataBaseConfig.getSQLExceptionState();
	}

	public String selectBankAccountList(String emailAddress, ArrayList<BankAccount> bankAccountList) {
        logger.info("selectBankAccountList(" + emailAddress + "," + bankAccountList + ")");
        
        ArrayList<String> queryList = new ArrayList<String>();
		
		String selectBankAccountListQuery 	
		
			= "SELECT * FROM bank_account INNER JOIN user_account ON bank_account.user_id = user_account.id WHERE "
			
				+ "user_account.id = (SELECT user_account.id FROM user_account WHERE user_account.email_address = '" + emailAddress + "');";

		queryList.add(selectBankAccountListQuery);

		ResultSet resultSet = dataBaseConfig.executeQuery(queryList);
		
    	try {
    		
			while (resultSet.next()) {
				
				bankAccountList.add(new BankAccount(
						resultSet.getString("account_name"), 
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
		
		return dataBaseConfig.getSQLExceptionState();
	}

	public String deleteBankAccount(String userEmailAddress, String accountName) {
        logger.info("deleteBankAccount(" + userEmailAddress + "," + accountName + ")");
        
        ArrayList<String> queryList = new ArrayList<String>();
        
		String deleteBankAccountQuery 
		
			= "DELETE FROM bank_account WHERE "
			
				+ "bank_account.user_id = (SELECT user_account.id FROM user_account WHERE user_account.email_address = '" + userEmailAddress + "') AND "
				+ "bank_account.account_name ='" + accountName + "';";

		queryList.add(deleteBankAccountQuery);
        
		dataBaseConfig.executeUpdate(queryList);
		
		return dataBaseConfig.getSQLExceptionState();
	}
}
