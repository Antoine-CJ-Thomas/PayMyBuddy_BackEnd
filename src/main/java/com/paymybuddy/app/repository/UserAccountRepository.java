package com.paymybuddy.app.repository;

import java.sql.SQLException;

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

	public void insertUserAccount(String emailAddress, String password, String firstName, String lastName) {
        logger.info("insertUserAccount(" + emailAddress + "," + password + "," + firstName + "," + lastName + ")");
		
		String request 	= "INSERT "
						+ "INTO user_account (email_address,password,first_name,last_name,balance) " 
						+ "VALUES ('" + emailAddress + "','" + password + "','" + firstName + "','" + lastName + "'," + 0.00 + ");";
						
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		dataBaseConfig.disableAutoCommit();
		dataBaseConfig.executeUpdateStatement(request);
		dataBaseConfig.commit();
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();

	}

	public void selectUserAccount(String emailAddress, UserAccount userAccount) {
        logger.info("selectUserAccount(" + emailAddress + ")");
		
		String request 	= "SELECT * "
						+ "FROM user_account " 
						+ "WHERE email_address='" + emailAddress + "';";
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
				
		dataBaseConfig.createResult(request);
				
    	try {

			if (dataBaseConfig.getResult().next()) {

				userAccount.setEmailAddress(dataBaseConfig.getResult().getString("email_address"));
				userAccount.setPassword(dataBaseConfig.getResult().getString("password"));
				userAccount.setFirstName(dataBaseConfig.getResult().getString("first_name"));
				userAccount.setLastName(dataBaseConfig.getResult().getString("last_name"));
				userAccount.setBalanceAmount(dataBaseConfig.getResult().getFloat("balance"));
			}
			
			else {

				userAccount.setEmailAddress("");
				userAccount.setPassword("");
				userAccount.setFirstName("");
				userAccount.setLastName("");
				userAccount.setBalanceAmount(0.0f);
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			dataBaseConfig.closeResult();
	    }
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	}

	public void updateUserAccount(String emailAddress, String password, String firstName, String lastName) {
        logger.info("updateUserAccount(" + emailAddress + "," + password + "," + firstName + "," + lastName + ")");        
		
		String request 	= "UPDATE user_account "
						+ "SET password='" + password + "'," + "first_name='" + firstName + "'," + "last_name='" + lastName + "'" 
						+ "WHERE email_address='" + emailAddress + "';";
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		dataBaseConfig.disableAutoCommit();
		dataBaseConfig.executeUpdateStatement(request);
		dataBaseConfig.commit();
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	
	}

	public void deleteUserAccount(String emailAddress) {
        logger.info("deleteUserAccount(" + emailAddress + ")");
	
		String request 	= "DELETE "
						+ "FROM user_account " 
						+ "WHERE email_address='" + emailAddress + "';";
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		dataBaseConfig.disableAutoCommit();
		dataBaseConfig.executeUpdateStatement(request);
		dataBaseConfig.commit();
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	}
}
