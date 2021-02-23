package com.paymybuddy.app.service;

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

    @Autowired
    private UserAccount userAccount;
	
	public UserAccountService() {
        logger.info("UserAccountService()");
	}
	
	public boolean createUserAccount(UserAccount userAccount) {
        logger.info("createUserAccount(" + userAccount + ")");
        
        userAccountRepository.insertUserAcount(userAccount);
        
		boolean creationSuccessful = false;

		this.userAccount = userAccountRepository.selectUserAcount(userAccount.getEmailAddress());
		
        if (this.userAccount.getPassword().equals(userAccount.getPassword()) && this.userAccount.getFirstName().equals(userAccount.getFirstName()) && this.userAccount.getLastName().equals(userAccount.getLastName())) {

        	creationSuccessful = true;
		    logger.info("- Account created successfully");
        }
        
        else {

		    logger.info("- Account couldn't be created");
        }
        
		return creationSuccessful;
	}

	public UserAccount getUserAccount(String emailAddress) {
        logger.info("getUserAccount(" + emailAddress + ")");
                
		return userAccountRepository.selectUserAcount(emailAddress);
	}

	public boolean editUserAccount(UserAccount userAccount) {
        logger.info("editUserAccount(" + userAccount + ")");
        
        userAccountRepository.updateUserAcount(userAccount);
        
		boolean editionSuccessful = false;
		
		this.userAccount = userAccountRepository.selectUserAcount(userAccount.getEmailAddress());
		
        if (this.userAccount.getPassword().equals(userAccount.getPassword()) && this.userAccount.getFirstName().equals(userAccount.getFirstName()) && this.userAccount.getLastName().equals(userAccount.getLastName())) {

			editionSuccessful = true;
		    logger.info("- Account edited successfully");
        }
        
        else {

		    logger.info("- Account couldn't be edited");
        }
        
		return editionSuccessful;
	}

	public boolean deleteUserAccount(String emailAddress) {
        logger.info("deleteUserAccount(" + emailAddress +")");
        
		boolean deleteSuccessful = false;
        
        userAccountRepository.deleteUserAcount(emailAddress);
		
		this.userAccount = userAccountRepository.selectUserAcount(emailAddress);
        		
        if (userAccount.getId() == -1) {

			deleteSuccessful = true;
		    logger.info("- Account deleted successfully");
        }
        
        else {

		    logger.info("- Account couldn't be deleted");
        }

		return deleteSuccessful;
	}

	public boolean loginUserAccount(String emailAddress, String password) {
        logger.info("loginUserAccount(" + emailAddress + ", " + password +")");
        
		boolean loginSuccessful = false;
		
		this.userAccount = userAccountRepository.selectUserAcount(emailAddress);
		
        if (userAccount.getPassword().equals(password)) {

		    loginSuccessful = true;
		    logger.info("- Connexion allowed");
        }
        
        else {

		    logger.info("- Connexion prohibited");
        }

		return loginSuccessful;
	}
}
