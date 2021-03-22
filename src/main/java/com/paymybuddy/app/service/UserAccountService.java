package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.dto.UserAccountEditingDto;
import com.paymybuddy.app.dto.UserAccountLoginDto;
import com.paymybuddy.app.dto.UserAccountRetrievingDto;
import com.paymybuddy.app.repository.UserAccountRepository;

/**
 *
 */
@Service
public class UserAccountService {

	private static final Logger logger = LogManager.getLogger("UserAccountService");

	@Autowired
	private UserAccountRepository userAccountRepository;

	public UserAccountService() {
		logger.info("UserAccountService()");
	}

	public UserAccountCreatingDto createUserAccount(UserAccountCreatingDto userAccountCreatingDto) {
		logger.info("createUserAccount(" + userAccountCreatingDto + ")");

		switch (userAccountRepository.insertUserAccount(userAccountCreatingDto.getEmailAddress(),
				userAccountCreatingDto.getPassword(), userAccountCreatingDto.getFirstName(),
				userAccountCreatingDto.getLastName())) {

		case ("00000"):

			userAccountCreatingDto.setDataValidated(true);
			break;

		case ("23505"):

			userAccountCreatingDto.setDataValidated(false);
			userAccountCreatingDto.setMessage("This email address is already used");
			break;

		default:

			userAccountCreatingDto.setDataValidated(false);
			userAccountCreatingDto.setMessage("Account couldn't be created");
			break;

		}

		return userAccountCreatingDto;
	}

	public UserAccountDeletingDto deleteUserAccount(UserAccountDeletingDto userAccountDeletingDto) {
		logger.info("deleteUserAccount(" + userAccountDeletingDto + ")");

		switch (userAccountRepository.deleteUserAccount(userAccountDeletingDto.getEmailAddress(),
				userAccountDeletingDto.getPassword())) {

		case ("00000"):

			userAccountDeletingDto.setDataValidated(true);
			break;

		default:

			userAccountDeletingDto.setDataValidated(false);
			userAccountDeletingDto.setMessage("Account couldn't be deleted");
			break;
		}

		return userAccountDeletingDto;
	}

	public UserAccountEditingDto editUserAccount(UserAccountEditingDto userAccountEditingDto) {
		logger.info("editUserAccount(" + userAccountEditingDto + ")");

		switch (userAccountRepository.updateUserAccount(userAccountEditingDto.getEmailAddress(),
				userAccountEditingDto.getPassword(), userAccountEditingDto.getFirstName(),
				userAccountEditingDto.getLastName())) {

		case ("00000"):

			userAccountEditingDto.setDataValidated(true);
			break;

		default:

			userAccountEditingDto.setDataValidated(false);
			userAccountEditingDto.setMessage("Account couldn't be edited");
			break;
		}

		return userAccountEditingDto;
	}

	public UserAccountLoginDto loginUserAccount(UserAccountLoginDto userAccountLoginDto) {
		logger.info("loginUserAccount(" + userAccountLoginDto + ")");

		switch (userAccountRepository.selectUserAccount(userAccountLoginDto.getEmailAddress(),
				userAccountLoginDto.getPassword())) {

		case ("00000"):

			userAccountLoginDto.setDataValidated(true);
			break;

		default:

			userAccountLoginDto.setDataValidated(false);
			userAccountLoginDto.setMessage("Invalid email or password");
			break;
		}

		return userAccountLoginDto;
	}

	public UserAccountRetrievingDto retrieveUserAccount(UserAccountRetrievingDto userAccountRetrievingDto) {
		logger.info("retrieveUserAccount(" + userAccountRetrievingDto + ")");

		switch (userAccountRepository.selectUserAccount(userAccountRetrievingDto.getEmailAddress(),
				userAccountRetrievingDto.getUserAccount())) {

		case ("00000"):

			userAccountRetrievingDto.setDataValidated(true);
			break;

		default:

			userAccountRetrievingDto.setDataValidated(false);
			break;
		}

		return userAccountRetrievingDto;
	}
}
