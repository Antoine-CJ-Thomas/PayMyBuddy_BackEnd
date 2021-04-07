package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymybuddy.app.dto.BankAccountRemovingDto;
import com.paymybuddy.app.dto.BankAccountRetrievingDto;
import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.service.BankAccountService;

/**
 * This class allows to intercept bank account requests
 */
@RestController
public class BankAccountController {

    private static final Logger logger = LogManager.getLogger("BankAccountController");
    
    @Autowired
    private BankAccountService bankAccountService;

	public BankAccountController() {
        logger.info("BankAccountController()");
	}

	@PostMapping(value = "/bank/account")
	public BankAccountAddingDto addBankAccount(@RequestBody BankAccountAddingDto bankAccountAddingDto) {
        logger.info("addBankAccount()");
		return bankAccountService.addBankAccount(bankAccountAddingDto);
	}

	@DeleteMapping(value = "/bank/account")
	public BankAccountRemovingDto removeBankAccount(@RequestBody BankAccountRemovingDto bankAccountRemovingDto) {
        logger.info("removeBankAccount()");
		return bankAccountService.removeBankAccount(bankAccountRemovingDto);
	}

	@GetMapping(value = "/bank/account")
	public BankAccountRetrievingDto retrieveBankAccountList(@RequestParam String emailAddress) {
        logger.info("retrieveBankAccountList()");
		return bankAccountService.retrieveBankAccountList(new BankAccountRetrievingDto(emailAddress));
	}
}