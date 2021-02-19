package com.paymybuddy.app.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.UserAccountRepository;

/**
 *
 */
@Service
public class UserAccountService {

    private static final Logger logger = LogManager.getLogger("UserAccountService");

	private UserAccountRepository userAccountRepository;
	
	public UserAccountService(UserAccountRepository userAccountRepository) {
        logger.info("UserAccountService()");
		this.userAccountRepository = userAccountRepository;
	}

	public UserAccount getAccount() {
        logger.info("getAccount()");
		return userAccountRepository.getUserAccount();
	}
	
	public String createAccount(UserAccount userAccount) {
        logger.info("createAccount()");
		
		String tableName = "user_account";
		String columnList = "(email_adress,password,first_name,last_name,balance)";
		String valueList = "('" + userAccount.getEmailAddress() + "','" + userAccount.getPassword() + "','" + userAccount.getFirstName() + "','" + userAccount.getLastName() + "'," + 0.00 + ")";
						
		return ("INSERT INTO " + tableName + " " + columnList + " VALUES " + valueList + ";");
	}

	public String editAccount(UserAccount userAccount) {
        logger.info("editAccount()");
		
		String tableName = "user_account";
		String setAction = "password='" + userAccount.getPassword() + "'," + "first_name='" + userAccount.getFirstName() + "'," + "last_name='" + userAccount.getLastName() + "'";
		String whereCondition = "ID=" + userAccountRepository.getUserAccount().getId();
		
		return ("UPDATE " + tableName + " SET " + setAction + " WHERE " + whereCondition + ";");
	}

	public String deleteAccount() {
        logger.info("deleteAccount()");
		
		String tableName = "user_account";
		String whereCondition = "ID=" + userAccountRepository.getUserAccount().getId();
				
		return ("DELETE FROM " + tableName + " WHERE " + whereCondition + ";");
	}

	public String searchAccount(UserAccount userAccount) {
        logger.info("searchAccount()");
        
		String tableName = "user_account";
		String whereCondition = "email_adress='" + userAccount.getEmailAddress() + "' AND " + "password='" + userAccount.getPassword() + "'";
		
		return ("SELECT * FROM " + tableName + " WHERE " + whereCondition + ";");
	}

	public void copyAccountData(ResultSet resultSet) {
        logger.info("copyAccountData()");

		userAccountRepository.resetAccount();
		
		try {
		
			if (resultSet.next()) {

				int id = resultSet.getInt("id");
				String emailAddress = resultSet.getString("email_adress");
				String password = resultSet.getString("password");
				String firstName = resultSet.getString("first_name");
				String lastName = resultSet.getString("last_name");
				float balance = resultSet.getFloat("balance");
	            
		        userAccountRepository.setUserAccount(new UserAccount(id, emailAddress, password, firstName, lastName, balance));
			}
  	        
		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			closeResultSet(resultSet);
		}
	}

	public void eraseAccountData() {

		userAccountRepository.resetAccount();
	}

	public boolean logIn(ResultSet resultSet) {
        logger.info("logIn()");
        
		boolean loginSuccessful = false;
		
		try {
			
			if (resultSet.next()) {

			    loginSuccessful = true;
			    logger.info("- Connexion allowed");
			}
			else {
			    logger.info("- Connexion prohibited");
			}
			
		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			closeResultSet(resultSet);
		}
		
		return loginSuccessful;
	}

	public void logOut() {
        logger.info("logOut()");
	}
    
    private void closeResultSet(ResultSet resultSet) {
    	
        if (resultSet != null) {
        	try {
        		resultSet.close();
			} catch (SQLException e) {
	            logger.error("- Close resultSet throw exception : " + e.getMessage());
			}
		}
    }
}
