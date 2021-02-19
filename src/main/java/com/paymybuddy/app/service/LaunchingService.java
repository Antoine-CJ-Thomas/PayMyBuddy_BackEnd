package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.controller.UserAccountController;
import com.paymybuddy.app.repository.UserAccountRepository;

/**
 * This class allow to launch the application
 */
@Service
public class LaunchingService {

    private static final Logger logger = LogManager.getLogger("LaunchingService");

    
	public void LaunchApplication() {
        logger.info("LaunchApplication()");

        UserAccountRepository userAccountRepository = new UserAccountRepository();
        UserAccountController userAccountController = new UserAccountController(userAccountRepository);
	}
}
