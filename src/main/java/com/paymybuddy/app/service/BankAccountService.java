package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.dto.BankAccountRemovingDto;
import com.paymybuddy.app.dto.BankAccountRetrievingDto;
import com.paymybuddy.app.repository.BankAccountRepository;

/**
 *
 */
@Service
public class BankAccountService {

    private static final Logger logger = LogManager.getLogger("BankAccountService");

    @Autowired
	private BankAccountRepository bankAccountRepository;
	
	public BankAccountService() {
        logger.info("bankAccountService()");
	}
	
	public BankAccountAddingDto addBankAccount(BankAccountAddingDto bankAccountAddingDto) {
        logger.info("addBankAccount(" + bankAccountAddingDto + ")");
        
    	if (bankAccountRepository.insertBankAccount(
    			bankAccountAddingDto.getEmailAddress(), 
    			bankAccountAddingDto.getAccountName(), 
    			bankAccountAddingDto.getAccountNumber(), 
    			bankAccountAddingDto.getSwiftCode()) == false) {

    		bankAccountAddingDto.setDataValidated(false);
			bankAccountAddingDto.setMessage("Account couldn't be added");
    	}
    	
    	else {

    		bankAccountAddingDto.setDataValidated(true); 	
    	}
        
		return bankAccountAddingDto;
	}

	public BankAccountRemovingDto removeBankAccount(BankAccountRemovingDto bankAccountRemovingDto) {
        logger.info("removeBankAccount(" + bankAccountRemovingDto +")");
        
    	if (bankAccountRepository.deleteBankAccount(
    			bankAccountRemovingDto.getEmailAddress(), 
    			bankAccountRemovingDto.getAccountName()) == false) {

    		bankAccountRemovingDto.setDataValidated(false);
    		bankAccountRemovingDto.setMessage("Account couldn't be removed");
    	}
    	
    	else {

    		bankAccountRemovingDto.setDataValidated(true); 	
    	}
        
		return bankAccountRemovingDto;
	}

	public BankAccountRetrievingDto retrieveBankAccountList(BankAccountRetrievingDto bankAccountRetrievingDto) {
        logger.info("retrieveBankAccountList(" + bankAccountRetrievingDto + ")");
        
        bankAccountRetrievingDto.setDataValidated(
        		bankAccountRepository.selectBankAccountList(
        				bankAccountRetrievingDto.getEmailAddress(), 
        				bankAccountRetrievingDto.getBankAccountList()));
                        
		return bankAccountRetrievingDto;
	}
}
