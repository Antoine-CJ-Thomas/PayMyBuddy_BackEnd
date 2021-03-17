package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.UserContactAddingDto;
import com.paymybuddy.app.dto.UserContactRemovingDto;
import com.paymybuddy.app.dto.UserContactRetrievingDto;
import com.paymybuddy.app.repository.UserContactRepository;

/**
 *
 */
@Service
public class UserContactService {

    private static final Logger logger = LogManager.getLogger("UserContactService");

    @Autowired
	private UserContactRepository userContactRepository;
	
	public UserContactService() {
        logger.info("UserContactService()");
	}
	
	public UserContactAddingDto addUserContact(UserContactAddingDto userContactAddingDto) {
        logger.info("addUserContact(" + userContactAddingDto + ")");
        
        if (userContactAddingDto.getContactEmailAddress() == null || (userContactAddingDto.getContactEmailAddress().length() == 0)) {
        	
        	userContactAddingDto.setDataValidated(false);
        	userContactAddingDto.setMessage("Email address field must be completed");
        }
        
        else {
            
        	if (userContactRepository.insertUserContact(
        			userContactAddingDto.getUserEmailAddress(), 
    				userContactAddingDto.getContactEmailAddress()) == false) {

    			userContactAddingDto.setDataValidated(false);
	           	userContactAddingDto.setMessage("Contact couldn't be added");
        	}
        	
        	else {

        		userContactAddingDto.setDataValidated(true); 	
        	}
        }
                
		return userContactAddingDto;
	}

	public UserContactRemovingDto removeUserContact(UserContactRemovingDto userContactRemovingDto) {
        logger.info("removeUserContact(" + userContactRemovingDto +")");
        
        if (userContactRemovingDto.getContactEmailAddress() == null || (userContactRemovingDto.getContactEmailAddress().length() == 0)) {
        	
        	userContactRemovingDto.setDataValidated(false);
        	userContactRemovingDto.setMessage("A contact must be selected");
        }
        
        else {
            
        	if (userContactRepository.insertUserContact(
        			userContactRemovingDto.getUserEmailAddress(), 
        			userContactRemovingDto.getContactEmailAddress()) == false) {

        		userContactRemovingDto.setDataValidated(false);
    			userContactRemovingDto.setMessage("Contact couldn't be removed");
        	}
        	
        	else {

        		userContactRemovingDto.setDataValidated(true); 	
        	}
        }
        
		return userContactRemovingDto;
	}

	public UserContactRetrievingDto retrieveUserContactList(UserContactRetrievingDto userContactRetrievingDto) {
        logger.info("retrieveUserContactList(" + userContactRetrievingDto + ")");
        
        userContactRetrievingDto.setDataValidated(
        		userContactRepository.selectUserContactList(
        				userContactRetrievingDto.getEmailAddress(), 
        				userContactRetrievingDto.getUserContactList()));
                        
		return userContactRetrievingDto;
	}
}
