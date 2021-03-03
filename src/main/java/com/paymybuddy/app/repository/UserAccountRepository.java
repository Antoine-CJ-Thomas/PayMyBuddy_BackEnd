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

		dataBaseConfig.insertQuery(query);
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
	}

	public boolean selectUserAccount(String emailAddress, UserAccount userAccount) {
        logger.info("selectUserAccount(" + emailAddress + ")");
		
		String query 	= "SELECT * "
						+ "FROM user_account " 
						+ "WHERE email_address='" + emailAddress + "';";

		ResultSet resultSet = dataBaseConfig.selectQuery(query);
				
    	try {

			if (resultSet.next()) {

				userAccount.setEmailAddress(resultSet.getString("email_address"));
				userAccount.setPassword(resultSet.getString("password"));
				userAccount.setFirstName(resultSet.getString("first_name"));
				userAccount.setLastName(resultSet.getString("last_name"));
				userAccount.setBalanceAmount(resultSet.getFloat("balance"));
			}
			
			else {

				userAccount.setEmailAddress("");
				userAccount.setPassword("");
				userAccount.setFirstName("");
				userAccount.setLastName("");
				userAccount.setBalanceAmount(0.0f);
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

	public boolean updateUserAccount(String emailAddress, String password, String firstName, String lastName) {
        logger.info("updateUserAccount(" + emailAddress + "," + password + "," + firstName + "," + lastName + ")");        
		
		String query 	= "UPDATE user_account "
						+ "SET password='" + password + "'," + "first_name='" + firstName + "'," + "last_name='" + lastName + "'" 
						+ "WHERE email_address='" + emailAddress + "';";
        
		dataBaseConfig.updateQuery(query);
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
	
	}

	public boolean deleteUserAccount(String emailAddress) {
        logger.info("deleteUserAccount(" + emailAddress + ")");
	
		String query 	= "DELETE "
						+ "FROM user_account " 
						+ "WHERE email_address='" + emailAddress + "';";
        
		dataBaseConfig.deleteQuery(query);
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
	}
}
