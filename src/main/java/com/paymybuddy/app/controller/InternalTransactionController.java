package com.paymybuddy.app.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsoniter.output.JsonStream;
import com.paymybuddy.app.dto.InternalTransactionExecutingDto;
import com.paymybuddy.app.dto.InternalTransactionRetrievingDto;
import com.paymybuddy.app.service.InternalTransactionService;


/**
 *
 */
@RestController
public class InternalTransactionController {

    private static final Logger logger = LogManager.getLogger("InternalTransactionController");
    
    @Autowired
    private InternalTransactionService internalTransactionService;

	public InternalTransactionController() {
        logger.info("InternalTransactionController()");
	}

	@PostMapping("/transaction/internal")
	public String executeInternalTransaction(@RequestBody InternalTransactionExecutingDto internalTransactionExecutingDto) {
        logger.info("executeInternalTransaction()");
		return JsonStream.serialize(internalTransactionService.executeInternalTransaction(internalTransactionExecutingDto));
	}

	@GetMapping("/transaction/internal")
	public String retrieveInternalTransactionList(@RequestBody InternalTransactionRetrievingDto internalTransactionRetrievingDto) {
        logger.info("retrieveInternalTransactionList()");
		return JsonStream.serialize(internalTransactionService.retrieveInternalTransactionList(internalTransactionRetrievingDto));
	}
}