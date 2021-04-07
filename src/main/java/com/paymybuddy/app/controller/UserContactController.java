package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymybuddy.app.dto.UserContactAddingDto;
import com.paymybuddy.app.dto.UserContactRemovingDto;
import com.paymybuddy.app.dto.UserContactRetrievingDto;
import com.paymybuddy.app.service.UserContactService;

/**
 * This class allows to intercept user contact requests
 */
@RestController
public class UserContactController {

    private static final Logger logger = LogManager.getLogger("UserContactController");
    
    @Autowired
    private UserContactService userContactService;

	public UserContactController() {
        logger.info("UserContactController()");
	}

	@PostMapping(value = "/user/contact")
	public UserContactAddingDto addUserContact(@RequestBody UserContactAddingDto userContactAddingDto) {
        logger.info("addUserContact()");
		return userContactService.addUserContact(userContactAddingDto);
	}

	@DeleteMapping(value = "/user/contact")
	public UserContactRemovingDto removeUserContact(@RequestBody UserContactRemovingDto userContactRemovingDto) {
        logger.info("removeUserContact()");
		return userContactService.removeUserContact(userContactRemovingDto);
	}

	@GetMapping(value = "/user/contact")
	public UserContactRetrievingDto retrieveUserContactList(@RequestParam String emailAddress) {
        logger.info("retrieveUserContactList()");
		return userContactService.retrieveUserContactList(new UserContactRetrievingDto(emailAddress));
	}
}