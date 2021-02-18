package com.paymybuddy.app.service;

import org.springframework.stereotype.Service;

import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.UserAccountRepository;

/**
 *
 */
@Service
public class UserAccountService {

	private UserAccountRepository userAccountRepository;
	
	public UserAccountService(UserAccountRepository userAccountRepository) {
		
		this.userAccountRepository = userAccountRepository;
	}
	
	public String createAccount(UserAccount userAccount) {
		
		String tableName = "user_account";
		String columnList = "(email_adress,password,first_name,last_name,balance)";
		String valueList = "('" + userAccount.getEmailAdress() + "','" + userAccount.getPassword() + "','" + userAccount.getFirstName() + "','" + userAccount.getLastName() + "'," + 0.00 + ")";
						
		return ("INSERT INTO " + tableName + " " + columnList + " VALUES " + valueList + ";");
	}
}
