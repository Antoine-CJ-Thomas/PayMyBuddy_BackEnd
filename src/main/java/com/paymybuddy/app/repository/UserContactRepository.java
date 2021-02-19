package com.paymybuddy.app.repository;

import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.UserContact;

/**
*
*/
@Component
public class UserContactRepository {

   private static final Logger logger = LogManager.getLogger("UserContactRepository");

	private ArrayList<UserContact> userContactList = new ArrayList<UserContact>();

	public void resetUserContactList() {
        logger.info("resetUserContactList()");
        userContactList = new ArrayList<UserContact>();
	}
	
	public ArrayList<UserContact> getUserContactList() {
       logger.info("getUserContactList()");
       return userContactList;
	}

	public void addUserContact(UserContact userContact) {
       logger.info("addUserContact(" + userContact + ")");
       userContactList.add(userContact);
	}

	public void removeUserContact(int index) {
       logger.info("removeUserContact(" + index + ")");
       userContactList.remove(index);
	}
}