package com.paymybuddy.app.repository;

import java.sql.ResultSet;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.config.DataBaseConfig;
import com.paymybuddy.app.config.PostgreConfig;

/**
 *
 */
@Component
public class UserAccountRepository {

    private static final Logger logger = LogManager.getLogger("UserAccountRepository");

    private DataBaseConfig dataBaseConfig;
    
    public UserAccountRepository() {
        logger.info("UserAccountRepository()");
    	dataBaseConfig = new PostgreConfig();
    }

	public void insertUserAcount(UserAccount userAccount) {
        logger.info("insertUserAcount( " + userAccount + " )");
		
		String tableName = "user_account";
		String columnList = "(email_address,password,first_name,last_name,balance)";
		String valueList = "('" + userAccount.getEmailAddress() + "','" + userAccount.getPassword() + "','" + userAccount.getFirstName() + "','" + userAccount.getLastName() + "'," + 0.00 + ")";
		
		String request = ("INSERT INTO " + tableName + " " + columnList + " VALUES " + valueList + ";");
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		dataBaseConfig.disableAutoCommit();
		dataBaseConfig.executeUpdateStatement(request);
		dataBaseConfig.commit();
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();

	}

	public ResultSet selectUserAcount(String emailAddress) {
        logger.info("selectUserAcount( " + emailAddress + " )");
                
		String tableName = "user_account";
		String whereCondition = "email_address='" + emailAddress + "'";
		
		String request = ("SELECT * FROM " + tableName + " WHERE " + whereCondition + ";");
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		ResultSet resultSet = dataBaseConfig.executeQueryStatement(request);
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
		
		return resultSet;
	}

	public void updateUserAcount(UserAccount userAccount) {
        logger.info("updateUserAcount( " + userAccount + " )");
        
		String tableName = "user_account";
		String setAction = "password='" + userAccount.getPassword() + "'," + "first_name='" + userAccount.getFirstName() + "'," + "last_name='" + userAccount.getLastName() + "'";
		String whereCondition = "email_address='" + userAccount.getEmailAddress() + "'";
		
        String request = ("UPDATE " + tableName + " SET " + setAction + " WHERE " + whereCondition + ";");
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		dataBaseConfig.disableAutoCommit();
		dataBaseConfig.executeUpdateStatement(request);
		dataBaseConfig.commit();
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	
	}

	public void deleteUserAcount(String emailAddress) {
        logger.info("deleteUserAcount( " + emailAddress + " )");
        
		String tableName = "user_account";
		String whereCondition = "email_address='" + emailAddress + "'";
		
        String request = ("DELETE FROM " + tableName + " WHERE " + whereCondition + ";");
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		dataBaseConfig.disableAutoCommit();
		dataBaseConfig.executeUpdateStatement(request);
		dataBaseConfig.commit();
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	}
}
