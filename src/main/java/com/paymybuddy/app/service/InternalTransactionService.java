package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.InternalTransactionExecutingDto;
import com.paymybuddy.app.dto.InternalTransactionRetrievingDto;
import com.paymybuddy.app.repository.InternalTransactionRepository;

/**
 *
 */
@Service
public class InternalTransactionService {

    private static final Logger logger = LogManager.getLogger("InternalTransactionService");

    @Autowired
	private InternalTransactionRepository internalTransactionRepository;
	
	public InternalTransactionService() {
        logger.info("InternalTransactionService()");
	}
	
	public InternalTransactionExecutingDto executeInternalTransaction(InternalTransactionExecutingDto internalTransactionExecutingDto) {
        logger.info("executeInternalTransaction(" + internalTransactionExecutingDto + ")");
        
        internalTransactionExecutingDto.setDataValidated(
        		internalTransactionRepository.insertInternalTransaction(
        				internalTransactionExecutingDto.getUserEmailAddress(), 
        				internalTransactionExecutingDto.getContactEmailAddress(), 
        				internalTransactionExecutingDto.getDescription(),
        				internalTransactionExecutingDto.getAmount()));
                
		return internalTransactionExecutingDto;
	}

	public InternalTransactionRetrievingDto retrieveInternalTransactionList(InternalTransactionRetrievingDto internalTransactionRetrievingDto) {
        logger.info("retrieveInternalTransactionList(" + internalTransactionRetrievingDto + ")");

        internalTransactionRetrievingDto.setDataValidated(
        		internalTransactionRepository.selectInternalTransaction(
        				internalTransactionRetrievingDto.getEmailAddress(), 
        				internalTransactionRetrievingDto.getInternalTransactionList()));
        
		return internalTransactionRetrievingDto;
	}
}
