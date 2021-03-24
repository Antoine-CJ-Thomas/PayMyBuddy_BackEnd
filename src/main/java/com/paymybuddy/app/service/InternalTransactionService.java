package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.InternalTransactionExecutingDto;
import com.paymybuddy.app.dto.InternalTransactionRetrievingDto;
import com.paymybuddy.app.model.UserAccount;
import com.paymybuddy.app.repository.InternalTransactionRepository;
import com.paymybuddy.app.repository.UserAccountRepository;

/**
 *
 */
@Service
public class InternalTransactionService {

	private static final Logger logger = LogManager.getLogger("InternalTransactionService");

	@Autowired
	private InternalTransactionRepository internalTransactionRepository;
	@Autowired
	private UserAccountRepository userAccountRepository;

	public InternalTransactionService() {
		logger.info("InternalTransactionService()");
	}

	public InternalTransactionExecutingDto executeInternalTransaction(
			InternalTransactionExecutingDto internalTransactionExecutingDto) {
		logger.info("executeInternalTransaction(" + internalTransactionExecutingDto + ")");
		
		UserAccount userAccount = new UserAccount();
		
		userAccountRepository.selectUserAccount(internalTransactionExecutingDto.getUserEmailAddress(), userAccount);

		if(userAccount.getBalanceAmount() < internalTransactionExecutingDto.getAmount()) {

			internalTransactionExecutingDto.setDataValidated(false);
			internalTransactionExecutingDto.setMessage("Your balance is lower than the amount you want to send");
		}
		
		else {
			
			switch (internalTransactionRepository.insertInternalTransaction(
					internalTransactionExecutingDto.getUserEmailAddress(),
					internalTransactionExecutingDto.getContactEmailAddress(),
					internalTransactionExecutingDto.getDescription(), internalTransactionExecutingDto.getAmount())) {

			case ("00000"):

				internalTransactionExecutingDto.setDataValidated(true);
				break;

			default:

				internalTransactionExecutingDto.setDataValidated(false);
				internalTransactionExecutingDto.setMessage("Transaction couldn't be executed");
				break;
			}
		}

		return internalTransactionExecutingDto;
	}

	public InternalTransactionRetrievingDto retrieveInternalTransactionList(
			InternalTransactionRetrievingDto internalTransactionRetrievingDto) {
		logger.info("retrieveInternalTransactionList(" + internalTransactionRetrievingDto + ")");

		switch (internalTransactionRepository.selectInternalTransactionList(
				internalTransactionRetrievingDto.getEmailAddress(),
				internalTransactionRetrievingDto.getInternalTransactionList())) {

		case ("00000"):

			internalTransactionRetrievingDto.setDataValidated(true);
			break;

		default:

			internalTransactionRetrievingDto.setDataValidated(false);
			break;
		}

		return internalTransactionRetrievingDto;
	}
}
