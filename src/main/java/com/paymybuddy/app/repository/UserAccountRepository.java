package com.paymybuddy.app.repository;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.UserAccount;

/**
 *
 */
@Component
public class UserAccountRepository {

    private static final Logger logger = LogManager.getLogger("UserAccountRepository");

	private UserAccount userAccount;

	public void setUserAccount(UserAccount UserAccount) {
        logger.info("setUserAccountList(" + UserAccount + ")");
		this.userAccount = UserAccount;
	}

	public void resetAccount() {
        logger.info("removeUserAccount()");
        userAccount = null;
	}

	public UserAccount getUserAccount() {
        logger.info("getUserAccountList()");
		return userAccount;
	}
}
