package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.ExternalTransactionExecutingDto;
import com.paymybuddy.app.dto.ExternalTransactionRetrievingDto;
import com.paymybuddy.app.repository.ExternalTransactionRepository;

/**
 *
 */
@Service
public class ExternalTransactionService {

    private static final Logger logger = LogManager.getLogger("ExternalTransactionService");

    @Autowired
	private ExternalTransactionRepository externalTransactionRepository;
	
	public ExternalTransactionService() {
        logger.info("ExternalTransactionService()");
	}
	
	public ExternalTransactionExecutingDto executeExternalTransaction(ExternalTransactionExecutingDto externalTransactionExecutingDto) {
        logger.info("executeExternalTransaction(" + externalTransactionExecutingDto + ")");
        
    	if (externalTransactionRepository.insertExternalTransaction(
				externalTransactionExecutingDto.getEmailAddress(), 
				externalTransactionExecutingDto.getAccountName(), 
				externalTransactionExecutingDto.getDescription(),
				externalTransactionExecutingDto.getAmount()) == false) {

    		externalTransactionExecutingDto.setDataValidated(false);
    		externalTransactionExecutingDto.setMessage("Transaction couldn't be executed");
    	}
    	
    	else {

    		externalTransactionExecutingDto.setDataValidated(true); 	
    	}
        
		return externalTransactionExecutingDto;
	}

	public ExternalTransactionRetrievingDto retrieveExternalTransactionList(ExternalTransactionRetrievingDto externalTransactionRetrievingDto) {
        logger.info("retrieveExternalTransactionList(" + externalTransactionRetrievingDto + ")");

        externalTransactionRetrievingDto.setDataValidated(
        		externalTransactionRepository.selectExternalTransactionList(
        				externalTransactionRetrievingDto.getEmailAddress(), 
        				externalTransactionRetrievingDto.getExternalTransactionList()));
                                
		return externalTransactionRetrievingDto;
	}
}
