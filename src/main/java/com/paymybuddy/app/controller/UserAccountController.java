package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;
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

        userAccountService = new UserAccountService(userAccountRepository);
        
        //PROVISOIRE
        dataBaseService = new DataBaseService("jdbc:postgresql://localhost:5432/app","usertest", "testuser");
	}

	@GetMapping("/user/account")
	public String getAccount() {
        logger.info("getAccount()");
        
		return JsonStream.serialize(userAccountService.getAccount());
	}

	@PostMapping("/user/account")
	public String createAccount(@RequestBody UserAccount userAccount) {
        logger.info("createAccount()");
        
		dataBaseService.insertOperation(userAccountService.createAccount(userAccount));
		
		return null;
	}

	@PutMapping("/user/account")
	public String editAccount(@RequestBody UserAccount userAccount) {
        logger.info("editAccount()");
        
		dataBaseService.updateOperation(userAccountService.editAccount(userAccount));
    	userAccountService.copyAccountData(dataBaseService.selectOperation(userAccountService.searchAccount(userAccount)));
    	
		return null;
	}

	@DeleteMapping("/user/account")
	public String deleteAccount() {
        logger.info("deleteAccount()");
        
		dataBaseService.deleteOperation(userAccountService.deleteAccount());
        userAccountService.eraseAccountData();
        
		return null;
	}

	@PostMapping("/user/logIn")
	public String logIn(@RequestBody UserAccount userAccount) {
        logger.info("logIn()");
                
        if (userAccountService.logIn(dataBaseService.selectOperation(userAccountService.searchAccount(userAccount)))) {
        	userAccountService.copyAccountData(dataBaseService.selectOperation(userAccountService.searchAccount(userAccount)));
        }
        return null;
	}

	@PostMapping("/user/logOut")
	public String logOut() {
        logger.info("logOut()");
        
        userAccountService.logOut();
        userAccountService.eraseAccountData();
        
		return null;
	}
}