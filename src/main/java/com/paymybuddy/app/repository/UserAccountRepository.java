package com.paymybuddy.app.repository;

import java.sql.ResultSet;
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

	public boolean insertUserAccount(String emailAddress, String password, String firstName, String lastName) {
        logger.info("insertUserAccount(" + emailAddress + "," + password + "," + firstName + "," + lastName + ")");
		
		String query 	= "INSERT "
						+ "INTO user_account (email_address,password,first_name,last_name,balance) " 
						+ "VALUES ('" + emailAddress + "','" + password + "','" + firstName + "','" + lastName + "'," + 0.00 + ");";

		boolean successfullyInserted = false;
		
		if (dataBaseConfig.insertQuery(query) > 0) {
			
			successfullyInserted = true;
		}
		
		return (dataBaseConfig.isQueryExecutedSuccessfully() && successfullyInserted);
	}

	public boolean selectUserAccount(String emailAddress, String password) {
        logger.info("selectUserAccount(" + emailAddress + "," + password + ")");
		
		String query 	= "SELECT * "
						+ "FROM user_account " 
						+ "WHERE "
						
							+ "user_account.email_address = '" + emailAddress + "'"
							
							+ "AND "
						
							+ "user_account.password = '" + password + "'"
							
						+ ";";
		
		boolean successfullySelected = false;

		ResultSet resultSet = dataBaseConfig.selectQuery(query);
		
    	try {

			if (resultSet.next()) {

				successfullySelected = true;
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
		
		return (dataBaseConfig.isQueryExecutedSuccessfully() && successfullySelected);
	}

	public boolean selectUserAccount(String emailAddress, UserAccount userAccount) {
        logger.info("selectUserAccount(" + emailAddress + "," + userAccount + ")");
		
		String query 	= "SELECT * "
						+ "FROM user_account " 
						+ "WHERE email_address='" + emailAddress + "';";
		
		boolean successfullySelected = false;

		ResultSet resultSet = dataBaseConfig.selectQuery(query);
				
    	try {

			if (resultSet.next()) {

				userAccount.setEmailAddress(resultSet.getString("email_address"));
				userAccount.setPassword(resultSet.getString("password"));
				userAccount.setFirstName(resultSet.getString("first_name"));
				userAccount.setLastName(resultSet.getString("last_name"));
				userAccount.setBalanceAmount(resultSet.getFloat("balance"));
				
				successfullySelected = true;
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
		
		return (dataBaseConfig.isQueryExecutedSuccessfully() && successfullySelected);
	}

	public boolean updateUserAccount(String emailAddress, String password, String firstName, String lastName) {
        logger.info("updateUserAccount(" + emailAddress + "," + password + "," + firstName + "," + lastName + ")");        
		
		String query 	= "UPDATE user_account "
						+ "SET password='" + password + "'," + "first_name='" + firstName + "'," + "last_name='" + lastName + "'" 
						+ "WHERE email_address='" + emailAddress + "';";

		boolean successfullyUpdated = false;
		
		if (dataBaseConfig.updateQuery(query) > 0) {
			
			successfullyUpdated = true;
		}
		
		return (dataBaseConfig.isQueryExecutedSuccessfully() && successfullyUpdated);
	
	}

	public boolean deleteUserAccount(String emailAddress, String password) {
        logger.info("deleteUserAccount(" + emailAddress + "," + password + ")");
	
		String query 	= "DELETE "
						+ "FROM user_account " 
						+ "WHERE "

							+ "user_account.email_address = '" + emailAddress + "'"
							
							+ "AND "
						
							+ "user_account.password = '" + password + "'"
							
						+ ";";

		boolean successfullyDeleted = false;
		
		if (dataBaseConfig.deleteQuery(query) > 0) {
			
			successfullyDeleted = true;
		}
		
		return (dataBaseConfig.isQueryExecutedSuccessfully() && successfullyDeleted);
	}
}
