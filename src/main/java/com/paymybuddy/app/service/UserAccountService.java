package com.paymybuddy.app.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.UserAccountRepository;

/**
 *
 */
@Service
public class UserAccountService {

    private static final Logger logger = LogManager.getLogger("UserAccountService");

    @Autowired
	private UserAccountRepository userAccountRepository;
	
	public UserAccountService() {
        logger.info("UserAccountService()");
	}

	public UserAccount getUserAccount(String emailAddress, UserAccount userAccount) {
        logger.info("getUserAccount(" + emailAddress + ", " + userAccount + ")");
        
        ResultSet resultSet = userAccountRepository.selectUserAcount(emailAddress);
        
    	try {

			if (resultSet.next()) {

				userAccount.setId(resultSet.getInt("id"));
				userAccount.setEmailAddress(resultSet.getString("email_address"));
				userAccount.setPassword(resultSet.getString("password"));
				userAccount.setFirstName(resultSet.getString("first_name"));
				userAccount.setLastName(resultSet.getString("last_name"));
				userAccount.setBalanceAmount(resultSet.getFloat("balance"));
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			closeResultSet(resultSet);
	    }
        
		return userAccount;
	}
	
	public boolean createUserAccount(UserAccount userAccount) {
        logger.info("createUserAccount(" + userAccount + ")");
        
        userAccountRepository.insertUserAcount(userAccount);
        
		boolean creationSuccessful = false;
        
        ResultSet resultSet = userAccountRepository.selectUserAcount(userAccount.getEmailAddress());

		try {

			if (resultSet.next()) {
				
				if (resultSet.getString("password").equals(userAccount.getPassword())) {
					if (resultSet.getString("first_name").equals(userAccount.getFirstName())) {
						if (resultSet.getString("last_name").equals(userAccount.getLastName())) {

							creationSuccessful = true;
						    logger.info("- Account created successfully");
						}
					}
				}
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
            
		} finally {
			closeResultSet(resultSet);
	    }
		
		if (creationSuccessful == false) {
		    logger.info("- Account couldn't be created");
		}
        
		return creationSuccessful;
	}

	public boolean editUserAccount(UserAccount userAccount) {
        logger.info("editUserAccount(" + userAccount + ")");
        
        userAccountRepository.updateUserAcount(userAccount);
        
		boolean editionSuccessful = false;
        
        ResultSet resultSet = userAccountRepository.selectUserAcount(userAccount.getEmailAddress());

		try {

			if (resultSet.next()) {
				
				if (resultSet.getString("password").equals(userAccount.getPassword())) {
					if (resultSet.getString("first_name").equals(userAccount.getFirstName())) {
						if (resultSet.getString("last_name").equals(userAccount.getLastName())) {

							editionSuccessful = true;
						    logger.info("- Account edited successfully");
						}
					}
				}
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
            
		} finally {
			closeResultSet(resultSet);
	    }
		
		if (editionSuccessful == false) {
		    logger.info("- Account couldn't be edited");
		}
        
		return editionSuccessful;
	}

	public boolean deleteUserAccount(String emailAddress) {
        logger.info("deleteUserAccount(" + emailAddress +")");
        
        userAccountRepository.deleteUserAcount(emailAddress);

		boolean deleteSuccessful = false;
		
        ResultSet resultSet = userAccountRepository.selectUserAcount(emailAddress);
		
		try {
			
			if (resultSet.next() == false) {

				deleteSuccessful = true;
			    logger.info("- Account deleted successfully");
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
            
		} finally {
			closeResultSet(resultSet);
	    }
		
		if (deleteSuccessful == false) {
		    logger.info("- Account couldn't be deleted");
		}

		return deleteSuccessful;
	}

	public boolean logInUserAccount(String emailAddress, String password) {
        logger.info("logInUserAccount(" + emailAddress + ", " + password +")");
        
		boolean loginSuccessful = false;
		
        ResultSet resultSet = userAccountRepository.selectUserAcount(emailAddress);

		try {

			if (resultSet.next()) {
				
				if (resultSet.getString("password").equals(password)) {

				    loginSuccessful = true;
				    logger.info("- Connexion allowed");
				}
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
            
		} finally {
			closeResultSet(resultSet);
	    }
		
		if (loginSuccessful == false) {
		    logger.info("- Connexion prohibited");
		}

		return loginSuccessful;
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
