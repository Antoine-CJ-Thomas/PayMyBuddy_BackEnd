package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.dto.BankAccountRemovingDto;
import com.paymybuddy.app.dto.BankAccountRetrievingDto;
import com.paymybuddy.app.repository.BankAccountRepository;

/**
 * This class allows to interact with a BankAccountRepository
 */
@Service
public class BankAccountService {

	private static final Logger logger = LogManager.getLogger("BankAccountService");

	@Autowired
	private BankAccountRepository bankAccountRepository;

	public BankAccountService() {
		logger.info("bankAccountService()");
	}

	public BankAccountAddingDto addBankAccount(BankAccountAddingDto bankAccountAddingDto) {
		logger.info("addBankAccount(" + bankAccountAddingDto + ")");

		switch (bankAccountRepository.insertBankAccount(bankAccountAddingDto.getEmailAddress(),
				bankAccountAddingDto.getAccountName(), bankAccountAddingDto.getAccountNumber(),
				bankAccountAddingDto.getSwiftCode())) {

		case ("00000"):

			bankAccountAddingDto.setDataValidated(true);
			break;

		case ("23505"):

			bankAccountAddingDto.setDataValidated(false);
			bankAccountAddingDto.setMessage("A bank account with the same name is already in your bank account list");
			break;

		default:

			bankAccountAddingDto.setDataValidated(false);
			bankAccountAddingDto.setMessage("Account couldn't be added");
			break;
		}

		return bankAccountAddingDto;
	}

	public BankAccountRemovingDto removeBankAccount(BankAccountRemovingDto bankAccountRemovingDto) {
		logger.info("removeBankAccount(" + bankAccountRemovingDto + ")");

		switch (bankAccountRepository.deleteBankAccount(bankAccountRemovingDto.getEmailAddress(),
				bankAccountRemovingDto.getAccountName())) {

		case ("00000"):

			bankAccountRemovingDto.setDataValidated(true);
			break;

		default:

			bankAccountRemovingDto.setDataValidated(false);
			bankAccountRemovingDto.setMessage("Account couldn't be removed");
			break;
		}

		return bankAccountRemovingDto;
	}

	public BankAccountRetrievingDto retrieveBankAccountList(BankAccountRetrievingDto bankAccountRetrievingDto) {
		logger.info("retrieveBankAccountList(" + bankAccountRetrievingDto + ")");

		switch (bankAccountRepository.selectBankAccountList(bankAccountRetrievingDto.getEmailAddress(),
				bankAccountRetrievingDto.getBankAccountList())) {

		case ("00000"):

			bankAccountRetrievingDto.setDataValidated(true);
			break;

		default:

			bankAccountRetrievingDto.setDataValidated(false);
			break;
		}

		return bankAccountRetrievingDto;
	}
}
