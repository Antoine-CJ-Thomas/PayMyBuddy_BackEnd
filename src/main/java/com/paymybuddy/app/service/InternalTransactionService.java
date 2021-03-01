package com.paymybuddy.app.service;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.InternalTransactionExecutingDto;
import com.paymybuddy.app.dto.InternalTransactionRetrievingDto;
import com.paymybuddy.app.model.InternalTransaction;
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
        
        internalTransactionRepository.insertInternalTransaction(internalTransactionExecutingDto.getUserEmailAddress(), internalTransactionExecutingDto.getContactEmailAddress(), internalTransactionExecutingDto.getAmount(),internalTransactionExecutingDto.getDescription());
        
        internalTransactionRepository.selectInternalTransactionFromUser(internalTransactionExecutingDto.getUserEmailAddress(), internalTransactionExecutingDto.getInternalTransactionList());
        internalTransactionRepository.selectInternalTransactionToUser(internalTransactionExecutingDto.getUserEmailAddress(), internalTransactionExecutingDto.getInternalTransactionList());
        
        int index = internalTransactionExecutingDto.getInternalTransactionList().size();
        
        if (index == 0) {

        	internalTransactionExecutingDto.setDataValidated(false);
		    logger.info("- Internal transaction couldn't be executed");
        }
        
        else {

            for (InternalTransaction u : internalTransactionExecutingDto.getInternalTransactionList()) {
        		
        	    Timestamp requestTimestamp = null;
        	    Timestamp transactionTimestamp = null;
        	    
				try {
					
					requestTimestamp = new Timestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").parse(internalTransactionExecutingDto.getDateAndTime()).getTime());
					transactionTimestamp = new Timestamp(new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").parse(u.getDateAndTime()).getTime());
					
				} catch (ParseException e) {
					e.printStackTrace();
				}
            	
		    	index--;		    	
		    	
            	if (u.getUserContact().getEmailAddress().equals(internalTransactionExecutingDto.getContactEmailAddress()) && transactionTimestamp.after(requestTimestamp)) {

            		internalTransactionExecutingDto.setDataValidated(true);
        		    logger.info("- Internal transaction executed successfully");
				    break;
            	}
            	
            	else if (index == 0){

            		internalTransactionExecutingDto.setDataValidated(false);
        		    logger.info("- Internal transaction couldn't be executed");
            	}
            }
        }
        
		return internalTransactionExecutingDto;
	}

	public InternalTransactionRetrievingDto retrieveInternalTransactionList(InternalTransactionRetrievingDto internalTransactionRetrievingDto) {
        logger.info("retrieveInternalTransactionList(" + internalTransactionRetrievingDto + ")");

        internalTransactionRepository.selectInternalTransactionFromUser(internalTransactionRetrievingDto.getEmailAddress(), internalTransactionRetrievingDto.getInternalTransactionList());
        internalTransactionRepository.selectInternalTransactionToUser(internalTransactionRetrievingDto.getEmailAddress(), internalTransactionRetrievingDto.getInternalTransactionList());
        
        if (internalTransactionRetrievingDto.getInternalTransactionList().size() != 0) {

        	internalTransactionRetrievingDto.setDataValidated(true);
		    logger.info("- Internal transaction list found");
        }
        
        else {

        	internalTransactionRetrievingDto.setDataValidated(false);
		    logger.info("- Internal transaction list couldn't be found");
        }
                        
		return internalTransactionRetrievingDto;
	}
}
