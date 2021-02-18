package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.controller.UserAccountController;
import com.paymybuddy.app.repository.UserAccountRepository;

/**
 * This class allow to launch the application
 */
@Service
public class LaunchingService {

    private static final Logger logger = LogManager.getLogger("LaunchingService");

    @Autowired
    private UserAccountRepository userAccountRepository;
    
	public void LaunchApplication() {
        logger.info("LaunchApplication()");
				
        UserAccountController userAccountController = new UserAccountController(userAccountRepository);
	}
}
