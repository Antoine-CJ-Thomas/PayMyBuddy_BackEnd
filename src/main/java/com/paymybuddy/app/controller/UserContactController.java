package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;
import com.paymybuddy.app.dto.UserContactAddingDto;
import com.paymybuddy.app.dto.UserContactRemovingDto;
import com.paymybuddy.app.dto.UserContactRetrievingDto;
import com.paymybuddy.app.service.UserContactService;


/**
 *
 */
@RestController
public class UserContactController {

    private static final Logger logger = LogManager.getLogger("UserContactController");
    
    @Autowired
    private UserContactService userContactService;

	public UserContactController() {
        logger.info("UserContactController()");
	}

	@PostMapping("/user/contact")
	public String addUserContact(@RequestBody UserContactAddingDto userContactAddingDto) {
        logger.info("addUserContact()");
		return JsonStream.serialize(userContactService.addUserContact(userContactAddingDto));
	}

	@DeleteMapping("/user/contact")
	public String removeUserContact(@RequestBody UserContactRemovingDto userContactRemovingDto) {
        logger.info("removeUserContact()");
		return JsonStream.serialize(userContactService.removeUserContact(userContactRemovingDto));
	}

	@GetMapping("/user/contact")
	public String retrieveUserContactList(@RequestBody UserContactRetrievingDto userContactRetrievingDto) {
        logger.info("retrieveUserContactList()");
		return JsonStream.serialize(userContactService.retrieveUserContactList(userContactRetrievingDto));
	}
}