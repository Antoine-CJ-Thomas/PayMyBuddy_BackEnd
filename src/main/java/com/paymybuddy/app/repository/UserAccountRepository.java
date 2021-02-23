package com.paymybuddy.app.repository;

<<<<<<< HEAD
import java.sql.SQLException;
=======
import java.sql.ResultSet;
>>>>>>> refs/remotes/origin/develop

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
    
<<<<<<< HEAD
    private UserAccount userAccount = new UserAccount();
    
=======
>>>>>>> refs/remotes/origin/develop
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

<<<<<<< HEAD
	public UserAccount selectUserAcount(String emailAddress) {
        logger.info("selectUserAcount( " + emailAddress + " )");
                
		String tableName = "user_account";
		String whereCondition = "email_address='" + emailAddress + "'";
		
		String request = ("SELECT * FROM " + tableName + " WHERE " + whereCondition + ";");
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
				
		dataBaseConfig.createResult(request);
		
    	try {
=======
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
>>>>>>> refs/remotes/origin/develop

<<<<<<< HEAD
			if (dataBaseConfig.getResult().next()) {

				userAccount.setId(dataBaseConfig.getResult().getInt("id"));
				userAccount.setEmailAddress(dataBaseConfig.getResult().getString("email_address"));
				userAccount.setPassword(dataBaseConfig.getResult().getString("password"));
				userAccount.setFirstName(dataBaseConfig.getResult().getString("first_name"));
				userAccount.setLastName(dataBaseConfig.getResult().getString("last_name"));
				userAccount.setBalanceAmount(dataBaseConfig.getResult().getFloat("balance"));
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			dataBaseConfig.closeResult();
	    }
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
		
		return userAccount;
=======
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
>>>>>>> refs/remotes/origin/develop
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
