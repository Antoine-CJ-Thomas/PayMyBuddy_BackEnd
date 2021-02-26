package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.dto.BankAccountRemovingDto;
import com.paymybuddy.app.dto.BankAccountRetrievingDto;
import com.paymybuddy.app.model.BankAccount;
import com.paymybuddy.app.repository.BankAccountRepository;

/**
 *
 */
@Service
public class BankAccountService {

    private static final Logger logger = LogManager.getLogger("bankAccountService");

    @Autowired
	private BankAccountRepository bankAccountRepository;
	
	public BankAccountService() {
        logger.info("bankAccountService()");
	}
	
	public BankAccountAddingDto addBankAccount(BankAccountAddingDto bankAccountAddingDto) {
        logger.info("addBankAccount(" + bankAccountAddingDto + ")");
        
        bankAccountRepository.insertBankAccount(bankAccountAddingDto.getEmailAddress(), bankAccountAddingDto.getAccoundNumber(), bankAccountAddingDto.getSwiftCode());
        bankAccountRepository.selectBankAccountList(bankAccountAddingDto.getEmailAddress(), bankAccountAddingDto.getBankAccountList());
        
        int index = bankAccountAddingDto.getBankAccountList().size();
        
        if (index == 0) {

    		bankAccountAddingDto.setDataValidated(false);
		    logger.info("- Bank account couldn't be added");
        }
        
        else {

            for (BankAccount u : bankAccountAddingDto.getBankAccountList()) {
            	
		    	index--;
            	        	
            	if (u.getAccoundNumber().equals(bankAccountAddingDto.getAccoundNumber()) && u.getSwiftCode().equals(bankAccountAddingDto.getSwiftCode())) {

            		bankAccountAddingDto.setDataValidated(true);
        		    logger.info("- Bank account added successfully");
				    break;
            	}
            	
            	else if (index == 0){

            		bankAccountAddingDto.setDataValidated(false);
        		    logger.info("- Bank account couldn't be added");
            	}
            }
        }
        
		return bankAccountAddingDto;
	}

	public BankAccountRemovingDto removeBankAccount(BankAccountRemovingDto bankAccountRemovingDto) {
        logger.info("removeBankAccount(" + bankAccountRemovingDto +")");
        
        bankAccountRepository.deleteBankAccount(bankAccountRemovingDto.getEmailAddress(), bankAccountRemovingDto.getAccoundNumber(), bankAccountRemovingDto.getSwiftCode());
        bankAccountRepository.selectBankAccountList(bankAccountRemovingDto.getEmailAddress(), bankAccountRemovingDto.getBankAccountList());
        
        int index = bankAccountRemovingDto.getBankAccountList().size();
        
        if (index == 0) {
    		
    		bankAccountRemovingDto.setDataValidated(true);
		    logger.info("- Bank account removed successfully");
        }
        
        else {
            
		    for (BankAccount u : bankAccountRemovingDto.getBankAccountList()) {
		    	
		    	index--;

            	if (u.getAccoundNumber().equals(bankAccountRemovingDto.getAccoundNumber()) && u.getSwiftCode().equals(bankAccountRemovingDto.getSwiftCode())) {

		    		bankAccountRemovingDto.setDataValidated(false);
				    logger.info("- Bank account couldn't be removed");
				    break;
		    	}
		    	
		    	else if (index == 0) {
		
		    		bankAccountRemovingDto.setDataValidated(true);
				    logger.info("- Bank account removed successfully");
		    	}
		    }
        }
        
		return bankAccountRemovingDto;
	}

	public BankAccountRetrievingDto retrieveBankAccountList(BankAccountRetrievingDto bankAccountRetrievingDto) {
        logger.info("retrieveBankAccountList(" + bankAccountRetrievingDto + ")");
        
        bankAccountRepository.selectBankAccountList(bankAccountRetrievingDto.getEmailAddress(), bankAccountRetrievingDto.getBankAccountList());
        
        if (bankAccountRetrievingDto.getBankAccountList().size() != 0) {

        	bankAccountRetrievingDto.setDataValidated(true);
		    logger.info("- Bank account list found");
        }
        
        else {

        	bankAccountRetrievingDto.setDataValidated(false);
		    logger.info("- Bank account list couldn't be found");
        }
                        
		return bankAccountRetrievingDto;
	}
}
