package com.paymybuddy.app.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.ExternalTransactionExecutingDto;
import com.paymybuddy.app.dto.ExternalTransactionRetrievingDto;
import com.paymybuddy.app.model.ExternalTransaction;
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
        
        externalTransactionRepository.insertExternalTransaction(externalTransactionExecutingDto.getEmailAddress(), externalTransactionExecutingDto.getAccountNumber(), externalTransactionExecutingDto.getSwiftCode(), externalTransactionExecutingDto.getAmount(),externalTransactionExecutingDto.getDescription());
        
        externalTransactionRepository.selectExternalTransaction(externalTransactionExecutingDto.getEmailAddress(), externalTransactionExecutingDto.getExternalTransactionList());
        
        int index = externalTransactionExecutingDto.getExternalTransactionList().size();
        
        if (index == 0) {

        	externalTransactionExecutingDto.setDataValidated(false);
		    logger.info("- External transaction couldn't be executed");
        }
        
        else {

            for (ExternalTransaction u : externalTransactionExecutingDto.getExternalTransactionList()) {
        		
        	    Timestamp requestTimestamp = null;
        	    Timestamp transactionTimestamp = null;
        	    
				try {
					
					requestTimestamp = new Timestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").parse(externalTransactionExecutingDto.getDateAndTime()).getTime());
					transactionTimestamp = new Timestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").parse(u.getDateAndTime()).getTime());
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
            	
		    	index--;		    	
		    	
            	if (u.getBankAccount().getAccountNumber().equals(externalTransactionExecutingDto.getAccountNumber()) && u.getBankAccount().getSwiftCode().equals(externalTransactionExecutingDto.getSwiftCode()) && transactionTimestamp.after(requestTimestamp)) {

            		externalTransactionExecutingDto.setDataValidated(true);
        		    logger.info("- External transaction executed successfully");
				    break;
            	}
            	
            	else if (index == 0){

            		externalTransactionExecutingDto.setDataValidated(false);
        		    logger.info("- External transaction couldn't be executed");
            	}
            }
        }
        
		return externalTransactionExecutingDto;
	}

	public ExternalTransactionRetrievingDto retrieveExternalTransactionList(ExternalTransactionRetrievingDto externalTransactionRetrievingDto) {
        logger.info("retrieveExternalTransactionList(" + externalTransactionRetrievingDto + ")");

        externalTransactionRepository.selectExternalTransaction(externalTransactionRetrievingDto.getEmailAddress(), externalTransactionRetrievingDto.getExternalTransactionList());
        
        if (externalTransactionRetrievingDto.getExternalTransactionList().size() != 0) {

        	externalTransactionRetrievingDto.setDataValidated(true);
		    logger.info("- External transaction list found");
        }
        
        else {

        	externalTransactionRetrievingDto.setDataValidated(false);
		    logger.info("- External transaction list couldn't be found");
        }
                        
		return externalTransactionRetrievingDto;
	}
}
