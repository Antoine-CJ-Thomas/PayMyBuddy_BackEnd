package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.UserContactAddingDto;
import com.paymybuddy.app.dto.UserContactRemovingDto;
import com.paymybuddy.app.dto.UserContactRetrievingDto;
import com.paymybuddy.app.model.UserContact;
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
        
        userContactRepository.insertUserContact(userContactAddingDto.getUserEmailAddress(), userContactAddingDto.getContactEmailAddress());
        userContactRepository.selectUserContactList(userContactAddingDto.getUserEmailAddress(), userContactAddingDto.getUserContactList());
        
        int index = userContactAddingDto.getUserContactList().size();
        
        if (index == 0) {

    		userContactAddingDto.setDataValidated(false);
		    logger.info("- Contact couldn't be added");
        }
        
        else {

            for (UserContact u : userContactAddingDto.getUserContactList()) {
            	
		    	index--;
            	        	
            	if (u.getEmailAddress().equals(userContactAddingDto.getContactEmailAddress())) {

            		userContactAddingDto.setDataValidated(true);
        		    logger.info("- Contact added successfully");
				    break;
            	}
            	
            	else if (index == 0){

            		userContactAddingDto.setDataValidated(false);
        		    logger.info("- Contact couldn't be added");
            	}
            }
        }
        
		return userContactAddingDto;
	}

	public UserContactRemovingDto removeUserContact(UserContactRemovingDto userContactRemovingDto) {
        logger.info("removeUserContact(" + userContactRemovingDto +")");
        
        userContactRepository.deleteUserContact(userContactRemovingDto.getUserEmailAddress(), userContactRemovingDto.getContactEmailAddress());
        userContactRepository.selectUserContactList(userContactRemovingDto.getUserEmailAddress(), userContactRemovingDto.getUserContactList());
        
        int index = userContactRemovingDto.getUserContactList().size();
        
        if (index == 0) {
    		
    		userContactRemovingDto.setDataValidated(true);
		    logger.info("- Contact removed successfully");
        }
        
        else {
            
		    for (UserContact u : userContactRemovingDto.getUserContactList()) {
		    	
		    	index--;
		
		    	if (u.getEmailAddress().equals(userContactRemovingDto.getContactEmailAddress())) {

		    		userContactRemovingDto.setDataValidated(false);
				    logger.info("- Contact couldn't be removed");
				    break;
		    	}
		    	
		    	else if (index == 0) {
		
		    		userContactRemovingDto.setDataValidated(true);
				    logger.info("- Contact removed successfully");
		    	}
		    }
        }
        
		return userContactRemovingDto;
	}

	public UserContactRetrievingDto retrieveUserContactList(UserContactRetrievingDto userContactRetrievingDto) {
        logger.info("retrieveUserContactList(" + userContactRetrievingDto + ")");
        
        userContactRepository.selectUserContactList(userContactRetrievingDto.getEmailAddress(), userContactRetrievingDto.getUserContactList());
        
        if (userContactRetrievingDto.getUserContactList().size() != 0) {

        	userContactRetrievingDto.setDataValidated(true);
		    logger.info("- Contact list found");
        }
        
        else {

        	userContactRetrievingDto.setDataValidated(false);
		    logger.info("- Contact list couldn't be found");
        }
                        
		return userContactRetrievingDto;
	}
}
