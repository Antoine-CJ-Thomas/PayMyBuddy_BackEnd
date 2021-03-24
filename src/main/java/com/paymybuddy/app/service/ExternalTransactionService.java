package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.ExternalTransactionExecutingDto;
import com.paymybuddy.app.dto.ExternalTransactionRetrievingDto;
import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.ExternalTransactionRepository;
import com.paymybuddy.app.repository.UserAccountRepository;

/**
 *
 */
@Service
public class ExternalTransactionService {

	private static final Logger logger = LogManager.getLogger("ExternalTransactionService");

	@Autowired
	private ExternalTransactionRepository externalTransactionRepository;
	@Autowired
	private UserAccountRepository userAccountRepository;

	public ExternalTransactionService() {
		logger.info("ExternalTransactionService()");
	}

	public ExternalTransactionExecutingDto executeExternalTransaction(
			ExternalTransactionExecutingDto externalTransactionExecutingDto) {
		logger.info("executeExternalTransaction(" + externalTransactionExecutingDto + ")");
		
		UserAccount userAccount = new UserAccount();
		
		userAccountRepository.selectUserAccount(externalTransactionExecutingDto.getEmailAddress(), userAccount);

		if(userAccount.getBalanceAmount() < externalTransactionExecutingDto.getAmount()) {

			externalTransactionExecutingDto.setDataValidated(false);
			externalTransactionExecutingDto.setMessage("Your balance is lower than the amount you want to send");
		}
		
		else {

			switch (externalTransactionRepository.insertExternalTransaction(
					externalTransactionExecutingDto.getEmailAddress(), externalTransactionExecutingDto.getAccountName(),
					externalTransactionExecutingDto.getDescription(), externalTransactionExecutingDto.getAmount())) {

			case ("00000"):

				externalTransactionExecutingDto.setDataValidated(true);
				break;

			default:

				externalTransactionExecutingDto.setDataValidated(false);
				externalTransactionExecutingDto.setMessage("Transaction couldn't be executed");
				break;
			}
		}

		return externalTransactionExecutingDto;
	}

	public ExternalTransactionRetrievingDto retrieveExternalTransactionList(
			ExternalTransactionRetrievingDto externalTransactionRetrievingDto) {
		logger.info("retrieveExternalTransactionList(" + externalTransactionRetrievingDto + ")");

		switch (externalTransactionRepository.selectExternalTransactionList(
				externalTransactionRetrievingDto.getEmailAddress(),
				externalTransactionRetrievingDto.getExternalTransactionList())) {

		case ("00000"):

			externalTransactionRetrievingDto.setDataValidated(true);
			break;

		default:

			externalTransactionRetrievingDto.setDataValidated(false);
			break;
		}

		return externalTransactionRetrievingDto;
	}
}
