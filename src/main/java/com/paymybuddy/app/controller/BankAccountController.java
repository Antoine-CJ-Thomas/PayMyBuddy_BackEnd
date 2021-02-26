package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;
import com.paymybuddy.app.dto.BankAccountRemovingDto;
import com.paymybuddy.app.dto.BankAccountRetrievingDto;
import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.service.BankAccountService;


/**
 *
 */
@RestController
public class BankAccountController {

    private static final Logger logger = LogManager.getLogger("UserContactController");
    
    @Autowired
    private BankAccountService bankAccountService;

	public BankAccountController() {
        logger.info("UserContactController()");
	}

	@PostMapping("/user/bankaccount")
	public String addBankAccount(@RequestBody BankAccountAddingDto bankAccountAddingDto) {
        logger.info("addBankAccount()");
		return JsonStream.serialize(bankAccountService.addBankAccount(bankAccountAddingDto));
	}

	@DeleteMapping("/user/bankaccount")
	public String removeBankAccount(@RequestBody BankAccountRemovingDto bankAccountRemovingDto) {
        logger.info("removeBankAccount()");
		return JsonStream.serialize(bankAccountService.removeBankAccount(bankAccountRemovingDto));
	}

	@GetMapping("/user/bankaccount")
	public String retrieveBankAccountList(@RequestBody BankAccountRetrievingDto bankAccountRetrievingDto) {
        logger.info("retrieveBankAccountList()");
		return JsonStream.serialize(bankAccountService.retrieveBankAccountList(bankAccountRetrievingDto));
	}
}