package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.dto.UserAccountEditingDto;
import com.paymybuddy.app.dto.UserAccountLoginDto;
import com.paymybuddy.app.dto.UserAccountRetrievingDto;
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
	
	public UserAccountCreatingDto createUserAccount(UserAccountCreatingDto userAccountCreatingDto) {
        logger.info("createUserAccount(" + userAccountCreatingDto + ")");
        
        if (userAccountCreatingDto.getEmailAddress() == null || (userAccountCreatingDto.getEmailAddress().length() == 0) ||
        		userAccountCreatingDto.getPassword() == null || (userAccountCreatingDto.getPassword().length() == 0) ||
        		userAccountCreatingDto.getFirstName() == null || (userAccountCreatingDto.getFirstName().length() == 0) ||
        		userAccountCreatingDto.getLastName() == null || (userAccountCreatingDto.getLastName().length() == 0)) {
        	
        	 userAccountCreatingDto.setDataValidated(false);
        	 userAccountCreatingDto.setMessage("All fields must be completed");
        }
        
        else {
            
        	if (userAccountRepository.insertUserAccount(
    				userAccountCreatingDto.getEmailAddress(), 
    				userAccountCreatingDto.getPassword(), 
    				userAccountCreatingDto.getFirstName(), 
    				userAccountCreatingDto.getLastName()) == false) {

	           	 userAccountCreatingDto.setDataValidated(false);
	           	 userAccountCreatingDto.setMessage("Account couldn't be created");
        	}
        	
        	else {

    		    userAccountCreatingDto.setDataValidated(true); 	
        	}
        }
         
		return userAccountCreatingDto;
	}

	public UserAccountDeletingDto deleteUserAccount(UserAccountDeletingDto userAccountDeletingDto) {
        logger.info("deleteUserAccount(" + userAccountDeletingDto +")");
        
        if (userAccountDeletingDto.getPassword() == null || (userAccountDeletingDto.getPassword().length() == 0)) {
        	
        	userAccountDeletingDto.setDataValidated(false);
        	userAccountDeletingDto.setMessage("The password field must be completed");
        }
        
        else {
            
        	if (userAccountRepository.deleteUserAccount(
        			userAccountDeletingDto.getEmailAddress(),
        			userAccountDeletingDto.getPassword()) == false) {

        		userAccountDeletingDto.setDataValidated(false);
        		userAccountDeletingDto.setMessage("Account couldn't be deleted");
        	}
        	
        	else {
        		
            	userAccountDeletingDto.setDataValidated(true); 	
        	}
    	}

		return userAccountDeletingDto;
	}

	public UserAccountEditingDto editUserAccount(UserAccountEditingDto userAccountEditingDto) {
        logger.info("editUserAccount(" + userAccountEditingDto + ")");
        
        if (userAccountEditingDto.getPassword() == null || (userAccountEditingDto.getPassword().length() == 0) ||
        		userAccountEditingDto.getFirstName() == null || (userAccountEditingDto.getFirstName().length() == 0) ||
        		userAccountEditingDto.getLastName() == null || (userAccountEditingDto.getLastName().length() == 0)) {
        	
        	userAccountEditingDto.setDataValidated(false);
        	 userAccountEditingDto.setMessage("All fields must be completed");
        }
        
        else {
            
        	if (userAccountRepository.updateUserAccount(
    				userAccountEditingDto.getEmailAddress(), 
    				userAccountEditingDto.getPassword(), 
    				userAccountEditingDto.getFirstName(), 
    				userAccountEditingDto.getLastName()) == false) {

        		userAccountEditingDto.setDataValidated(false);
               	userAccountEditingDto.setMessage("Account couldn't be edited");
        	}
        	
        	else {

        		userAccountEditingDto.setDataValidated(true); 	
        	}
        }

		return userAccountEditingDto;
	}

	public UserAccountLoginDto loginUserAccount(UserAccountLoginDto userAccountLoginDto) {
        logger.info("loginUserAccount(" + userAccountLoginDto +")");
        
        if (userAccountLoginDto.getEmailAddress() == null || (userAccountLoginDto.getEmailAddress().length() == 0) ||
        		userAccountLoginDto.getPassword() == null || (userAccountLoginDto.getPassword().length() == 0)) {
        	
        	userAccountLoginDto.setDataValidated(false);
        	userAccountLoginDto.setMessage("All fields must be completed");
        }
        
        else {
            
        	if (userAccountRepository.selectUserAccount(
        			userAccountLoginDto.getEmailAddress(),
    				userAccountLoginDto.getPassword()) == false) {

        		userAccountLoginDto.setDataValidated(false);
            	userAccountLoginDto.setMessage("Invalid email or password");
        	}
        	
        	else {

        		userAccountLoginDto.setDataValidated(true); 	
        	}
        }

		return userAccountLoginDto;
	}

	public UserAccountRetrievingDto retrieveUserAccount(UserAccountRetrievingDto userAccountRetrievingDto) {
        logger.info("retrieveUserAccount(" + userAccountRetrievingDto + ")");
        
        userAccountRetrievingDto.setDataValidated(
        		userAccountRepository.selectUserAccount(
        				userAccountRetrievingDto.getEmailAddress(), 
        				userAccountRetrievingDto.getUserAccount()));
          
		return userAccountRetrievingDto;
	}
}
