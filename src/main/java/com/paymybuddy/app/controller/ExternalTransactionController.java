package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymybuddy.app.dto.ExternalTransactionExecutingDto;
import com.paymybuddy.app.dto.ExternalTransactionRetrievingDto;
import com.paymybuddy.app.service.ExternalTransactionService;


/**
 *
 */
@RestController
public class ExternalTransactionController {

    private static final Logger logger = LogManager.getLogger("ExternalTransactionController");
    
    @Autowired
    private ExternalTransactionService externalTransactionService;

	public ExternalTransactionController() {
        logger.info("ExternalTransactionController()");
	}

	@PostMapping(value = "/transaction/external")
	public ExternalTransactionExecutingDto executeExternalTransaction(@RequestBody ExternalTransactionExecutingDto externalTransactionExecutingDto) {
        logger.info("executeExternalTransaction()");
		return externalTransactionService.executeExternalTransaction(externalTransactionExecutingDto);
	}

	@GetMapping(value = "/transaction/external")
	public ExternalTransactionRetrievingDto retrieveExternalTransactionList(@RequestParam String emailAddress) {
        logger.info("retrieveBankAccountList()");
		return externalTransactionService.retrieveExternalTransactionList(new ExternalTransactionRetrievingDto(emailAddress));
	}
}