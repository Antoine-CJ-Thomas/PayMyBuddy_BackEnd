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
import com.paymybuddy.app.model.UserAccount;
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

	@GetMapping("/user/account")
	public String getUserAccount(@RequestBody UserAccount userAccount) {
        logger.info("getUserAccount()");
		return JsonStream.serialize(userAccountService.getUserAccount(userAccount.getEmailAddress()));
	}

	@PostMapping("/user/account")
	public String createUserAccount(@RequestBody UserAccount userAccount) {
        logger.info("createUserAccount()");
		return JsonStream.serialize(userAccountService.createUserAccount(userAccount));
	}

	@PutMapping("/user/account")
	public String editUserAccount(@RequestBody UserAccount userAccount) {
        logger.info("editUserAccount()");
		return JsonStream.serialize(userAccountService.editUserAccount(userAccount));
	}

	@DeleteMapping("/user/account")
	public String deleteUserAccount(@RequestBody UserAccount userAccount) {
        logger.info("deleteUserAccount()");
		return JsonStream.serialize(userAccountService.deleteUserAccount(userAccount.getEmailAddress()));
	}

	@PostMapping("/user/login")
	public String loginUserAccount(@RequestBody UserAccount userAccount) {
        logger.info("loginUserAccount()");
		return JsonStream.serialize(userAccountService.loginUserAccount(userAccount.getEmailAddress(), userAccount.getPassword()));
	}
}