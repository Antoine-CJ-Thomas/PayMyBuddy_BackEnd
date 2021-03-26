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

		if (userContactAddingDto.getContactEmailAddress().equals(userContactAddingDto.getUserEmailAddress())) {

			userContactAddingDto.setDataValidated(false);
			userContactAddingDto.setMessage("You can't adding yourself to your contact list");
		}
		
		else {

			switch (userContactRepository.insertUserContact(userContactAddingDto.getUserEmailAddress(),
					userContactAddingDto.getContactEmailAddress())) {

			case ("00000"):

				userContactAddingDto.setDataValidated(true);
				break;

			case ("23502"):

				userContactAddingDto.setDataValidated(false);
				userContactAddingDto.setMessage("This email address is not assigned to any user");
				break;

			case ("23505"):

				userContactAddingDto.setDataValidated(false);
				userContactAddingDto.setMessage("A contact with this address is already in your contact list");
				break;

			default:

				userContactAddingDto.setDataValidated(false);
				userContactAddingDto.setMessage("Contact couldn't be added");
				break;
			}
		}

		return userContactAddingDto;
	}

	public UserContactRemovingDto removeUserContact(UserContactRemovingDto userContactRemovingDto) {
		logger.info("removeUserContact(" + userContactRemovingDto + ")");

		switch (userContactRepository.deleteUserContact(userContactRemovingDto.getUserEmailAddress(),
				userContactRemovingDto.getContactEmailAddress())) {

		case ("00000"):

			userContactRemovingDto.setDataValidated(true);
			break;

		default:

			userContactRemovingDto.setDataValidated(false);
			userContactRemovingDto.setMessage("Contact couldn't be removed");
			break;
		}

		return userContactRemovingDto;
	}

	public UserContactRetrievingDto retrieveUserContactList(UserContactRetrievingDto userContactRetrievingDto) {
		logger.info("retrieveUserContactList(" + userContactRetrievingDto + ")");

		switch (userContactRepository.selectUserContactList(userContactRetrievingDto.getEmailAddress(),
				userContactRetrievingDto.getUserContactList())) {

		case ("00000"):

			userContactRetrievingDto.setDataValidated(true);
			break;

		default:

			userContactRetrievingDto.setDataValidated(false);
			break;
		}

		return userContactRetrievingDto;
	}
}
