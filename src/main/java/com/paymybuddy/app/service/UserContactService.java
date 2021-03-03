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
        
        userContactAddingDto.setDataValidated(
        		userContactRepository.insertUserContact(
        				userContactAddingDto.getUserEmailAddress(), 
        				userContactAddingDto.getContactEmailAddress()));
                
		return userContactAddingDto;
	}

	public UserContactRemovingDto removeUserContact(UserContactRemovingDto userContactRemovingDto) {
        logger.info("removeUserContact(" + userContactRemovingDto +")");
        
        userContactRemovingDto.setDataValidated(
        		userContactRepository.deleteUserContact(
        				userContactRemovingDto.getUserEmailAddress(), 
        				userContactRemovingDto.getContactEmailAddress()));
        
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
