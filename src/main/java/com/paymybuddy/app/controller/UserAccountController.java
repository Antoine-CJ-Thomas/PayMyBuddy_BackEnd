package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.dto.UserAccountEditingDto;
import com.paymybuddy.app.dto.UserAccountRetrievingDto;
import com.paymybuddy.app.service.UserAccountService;


/**
 *
 */
@RestController
public class UserAccountController {

    private static final Logger logger = LogManager.getLogger("UserAccountController");
    
    @Autowired
    private UserAccountService userAccountService;

	public UserAccountController() {
        logger.info("UserAccountController()");
	}

	@PostMapping(value = "/user/account")
	public UserAccountCreatingDto createUserAccount(@RequestBody UserAccountCreatingDto userAccountCreatingDto) {
        logger.info("createUserAccount()");
		return userAccountService.createUserAccount(userAccountCreatingDto);
	}

	@DeleteMapping(value = "/user/account")
	public UserAccountDeletingDto deleteUserAccount(@RequestBody UserAccountDeletingDto userAccountDeletingDto) {
        logger.info("deleteUserAccount()");
		return userAccountService.deleteUserAccount(userAccountDeletingDto);
	}

	@PutMapping(value = "/user/account")
	public UserAccountEditingDto editUserAccount(@RequestBody UserAccountEditingDto userAccountEditingDto) {
        logger.info("editUserAccount()");
		return userAccountService.editUserAccount(userAccountEditingDto);
	}

	@GetMapping(value = "/user/account")
	public UserAccountRetrievingDto retrieveUserAccount(@RequestParam String emailAddress) {
        logger.info("retrieveUserAccount()");
		return userAccountService.retrieveUserAccount(new UserAccountRetrievingDto(emailAddress));
	}
}