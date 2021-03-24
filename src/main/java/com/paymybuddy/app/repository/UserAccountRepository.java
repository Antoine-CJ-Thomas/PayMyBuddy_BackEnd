package com.paymybuddy.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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

	public String insertUserAccount(String emailAddress, String password, String firstName, String lastName) {
        logger.info("insertUserAccount(" + emailAddress + "," + password + "," + firstName + "," + lastName + ")");
        
        ArrayList<String> queryList = new ArrayList<String>();
		
		String insertUserAccountQuery 	
		
			= "INSERT INTO user_account (email_address,password,first_name,last_name,balance) VALUES ("
			
				+ "'" + emailAddress + "',"
				+ "'" + password + "',"
				+ "'" + firstName + "',"
				+ "'" + lastName + "',"
				+ "" + 0.00 + ");";

		queryList.add(insertUserAccountQuery);

		dataBaseConfig.executeUpdate(queryList);
		
		return dataBaseConfig.getSQLExceptionState();
	}

	public String selectUserAccount(String emailAddress, UserAccount userAccount) {
        logger.info("selectUserAccount(" + emailAddress + "," + userAccount + ")");
        
        ArrayList<String> queryList = new ArrayList<String>();
		
		String selectUserAccountQuery	
		
			= "SELECT * FROM user_account WHERE email_address='" + emailAddress + "';";

		queryList.add(selectUserAccountQuery);

		ResultSet resultSet = dataBaseConfig.executeQuery(queryList);
				
    	try {

			if (resultSet.next()) {

				userAccount.setEmailAddress(resultSet.getString("email_address"));
				userAccount.setPassword(resultSet.getString("password"));
				userAccount.setFirstName(resultSet.getString("first_name"));
				userAccount.setLastName(resultSet.getString("last_name"));
				userAccount.setBalanceAmount(resultSet.getFloat("balance"));
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

	public String updateUserAccount(String emailAddress, String password, String firstName, String lastName) {
        logger.info("updateUserAccount(" + emailAddress + "," + password + "," + firstName + "," + lastName + ")");     
        
        ArrayList<String> queryList = new ArrayList<String>();   
		
		String updateUserAccountQuery
		
			= "UPDATE user_account SET "
			
				+ "password='" + password + "'," 
				+ "first_name='" + firstName + "'," 
				+ "last_name='" + lastName + "'" 
					
			+ "WHERE email_address='" + emailAddress + "';";

		queryList.add(updateUserAccountQuery);
		
		dataBaseConfig.executeUpdate(queryList);
		
		return dataBaseConfig.getSQLExceptionState();
	
	}

	public String deleteUserAccount(String emailAddress, String password) {
        logger.info("deleteUserAccount(" + emailAddress + "," + password + ")");
        
        ArrayList<String> queryList = new ArrayList<String>();
	
		String deleteUserAccountQuery
		
			= "DELETE FROM user_account WHERE "

				+ "user_account.email_address = '" + emailAddress + "' AND "
				+ "user_account.password = '" + password + "';";

		queryList.add(deleteUserAccountQuery);
		
		dataBaseConfig.executeUpdate(queryList);
		
		return dataBaseConfig.getSQLExceptionState();
	}
}
