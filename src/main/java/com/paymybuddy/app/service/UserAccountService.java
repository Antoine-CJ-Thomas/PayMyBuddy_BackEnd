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
                
        userAccountRepository.insertUserAccount(userAccountCreatingDto.getEmailAddress(), userAccountCreatingDto.getPassword(), userAccountCreatingDto.getFirstName(), userAccountCreatingDto.getLastName()); 		
        userAccountRepository.selectUserAccount(userAccountCreatingDto.getEmailAddress(), userAccountCreatingDto.getUserAccount());
        
        if (userAccountCreatingDto.getUserAccount().getEmailAddress().equals(userAccountCreatingDto.getEmailAddress())) {

        	userAccountCreatingDto.setDataValidated(true);
		    logger.info("- Account created successfully");
        }
        
        else {

        	userAccountCreatingDto.setDataValidated(false);
		    logger.info("- Account couldn't be created");
        }
        
		return userAccountCreatingDto;
	}

	public UserAccountDeletingDto deleteUserAccount(UserAccountDeletingDto userAccountDeletingDto) {
        logger.info("deleteUserAccount(" + userAccountDeletingDto +")");
                
        userAccountRepository.deleteUserAccount(userAccountDeletingDto.getEmailAddress());
        userAccountRepository.selectUserAccount(userAccountDeletingDto.getEmailAddress(), userAccountDeletingDto.getUserAccount());
		        		
        if (userAccountDeletingDto.getUserAccount().getEmailAddress().equals("")) {

        	userAccountDeletingDto.setDataValidated(true);
		    logger.info("- Account deleted successfully");
        }
        
        else {

        	userAccountDeletingDto.setDataValidated(false);
		    logger.info("- Account couldn't be deleted");
        }
		return userAccountDeletingDto;
	}

	public UserAccountEditingDto editUserAccount(UserAccountEditingDto userAccountEditingDto) {
        logger.info("editUserAccount(" + userAccountEditingDto + ")");
        
        userAccountRepository.updateUserAccount(userAccountEditingDto.getEmailAddress(), userAccountEditingDto.getPassword(), userAccountEditingDto.getFirstName(), userAccountEditingDto.getLastName());
        userAccountRepository.selectUserAccount(userAccountEditingDto.getEmailAddress(), userAccountEditingDto.getUserAccount());
        		
		
        if (userAccountEditingDto.getPassword().equals(userAccountEditingDto.getUserAccount().getPassword()) 
        		&& userAccountEditingDto.getFirstName().equals(userAccountEditingDto.getUserAccount().getFirstName()) 
        		&& userAccountEditingDto.getLastName().equals(userAccountEditingDto.getUserAccount().getLastName())) {

        	userAccountEditingDto.setDataValidated(true);
		    logger.info("- Account edited successfully");
        }
        
        else {

        	userAccountEditingDto.setDataValidated(false);
		    logger.info("- Account couldn't be edited");
        }
        
		return userAccountEditingDto;
	}

	public UserAccountLoginDto loginUserAccount(UserAccountLoginDto userAccountLoginDto) {
        logger.info("loginUserAccount(" + userAccountLoginDto +")");

        userAccountRepository.selectUserAccount(userAccountLoginDto.getEmailAddress(), userAccountLoginDto.getUserAccount());
        
        if (userAccountLoginDto.getUserAccount().getPassword().equals(userAccountLoginDto.getPassword())) {

        	userAccountLoginDto.setDataValidated(true);
		    logger.info("- Connexion allowed");
        }
        
        else {

        	userAccountLoginDto.setDataValidated(false);
		    logger.info("- Connexion prohibited");
        }

		return userAccountLoginDto;
	}

	public UserAccountRetrievingDto retrieveUserAccount(UserAccountRetrievingDto userAccountRetrievingDto) {
        logger.info("retrieveUserAccount(" + userAccountRetrievingDto + ")");
        
        userAccountRepository.selectUserAccount(userAccountRetrievingDto.getEmailAddress(), userAccountRetrievingDto.getUserAccount());
        
        if (userAccountRetrievingDto.getUserAccount().getEmailAddress().equals(userAccountRetrievingDto.getEmailAddress())) {

        	userAccountRetrievingDto.setDataValidated(true);
		    logger.info("- Account found");
        }
        
        else {

        	userAccountRetrievingDto.setDataValidated(false);
		    logger.info("- Acount couldn't be found");
        }
        
		return userAccountRetrievingDto;
	}
}
