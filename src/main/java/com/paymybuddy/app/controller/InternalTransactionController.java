package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.paymybuddy.app.dto.InternalTransactionExecutingDto;
import com.paymybuddy.app.dto.InternalTransactionRetrievingDto;
import com.paymybuddy.app.service.InternalTransactionService;

/**
 * This class allows to intercept internal transaction requests
 */
@RestController
public class InternalTransactionController {

    private static final Logger logger = LogManager.getLogger("InternalTransactionController");
    
    @Autowired
    private InternalTransactionService internalTransactionService;

	public InternalTransactionController() {
        logger.info("InternalTransactionController()");
	}

	@PostMapping(value = "/transaction/internal")
	public InternalTransactionExecutingDto executeInternalTransaction(@RequestBody InternalTransactionExecutingDto internalTransactionExecutingDto) {
        logger.info("executeInternalTransaction()");
		return internalTransactionService.executeInternalTransaction(internalTransactionExecutingDto);
	}

	@GetMapping(value = "/transaction/internal")
	public InternalTransactionRetrievingDto retrieveInternalTransactionList(@RequestParam String emailAddress) {
        logger.info("retrieveInternalTransactionList()");
		return internalTransactionService.retrieveInternalTransactionList(new InternalTransactionRetrievingDto(emailAddress));
	}
}