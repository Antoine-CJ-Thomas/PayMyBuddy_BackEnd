package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;
import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.dto.UserAccountEditingDto;
import com.paymybuddy.app.dto.UserAccountLoginDto;
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

	@PostMapping("/user/account")
	public String createUserAccount(@RequestBody UserAccountCreatingDto userAccountCreatingDto) {
        logger.info("createUserAccount()");
		return JsonStream.serialize(userAccountService.createUserAccount(userAccountCreatingDto));
	}

	@DeleteMapping("/user/account")
	public String deleteUserAccount(@RequestBody UserAccountDeletingDto userAccountDeletingDto) {
        logger.info("deleteUserAccount()");
		return JsonStream.serialize(userAccountService.deleteUserAccount(userAccountDeletingDto));
	}

	@PutMapping("/user/account")
	public String editUserAccount(@RequestBody UserAccountEditingDto userAccountEditingDto) {
        logger.info("editUserAccount()");
		return JsonStream.serialize(userAccountService.editUserAccount(userAccountEditingDto));
	}

	@PostMapping("/user/login")
	public String loginUserAccount(@RequestBody UserAccountLoginDto userAccountLoginDto) {
        logger.info("loginUserAccount()");
		return JsonStream.serialize(userAccountService.loginUserAccount(userAccountLoginDto));
	}

	@GetMapping("/user/account")
	public String retrieveUserAccount(@RequestBody UserAccountRetrievingDto userAccountRetrievingDto) {
        logger.info("retrieveUserAccount()");
		return JsonStream.serialize(userAccountService.retrieveUserAccount(userAccountRetrievingDto));
	}
}