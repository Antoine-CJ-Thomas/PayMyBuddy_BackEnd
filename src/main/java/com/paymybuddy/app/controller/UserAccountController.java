package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.UserAccountRepository;
import com.paymybuddy.app.service.DataBaseService;
import com.paymybuddy.app.service.UserAccountService;


/**
 *
 */
@RestController
public class UserAccountController {

    private static final Logger logger = LogManager.getLogger("UserAccountController");

    private static DataBaseService dataBaseService;
    private static UserAccountService userAccountService;

	public UserAccountController(UserAccountRepository userAccountRepository) {
        logger.info("UserAccountController()");
        
        dataBaseService = new DataBaseService("jdbc:postgresql://localhost:5432/app","usertest", "testuser");
        userAccountService = new UserAccountService(userAccountRepository);
	}

	@PostMapping("/user/account")
	public void createAccount(@RequestBody UserAccount userAccount) {
        logger.info("createAccount()");
		dataBaseService.InsertOperation(userAccountService.createAccount(userAccount));
	}
}