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
        
		bankAccountAddingDto.setDataValidated(
				bankAccountRepository.insertBankAccount(
						bankAccountAddingDto.getEmailAddress(), 
						bankAccountAddingDto.getAccountNumber(), 
						bankAccountAddingDto.getSwiftCode()));
        
		return bankAccountAddingDto;
	}

	public BankAccountRemovingDto removeBankAccount(BankAccountRemovingDto bankAccountRemovingDto) {
        logger.info("removeBankAccount(" + bankAccountRemovingDto +")");
        
        bankAccountRemovingDto.setDataValidated(
				bankAccountRepository.deleteBankAccount(
						bankAccountRemovingDto.getEmailAddress(), 
						bankAccountRemovingDto.getAccountNumber(), 
						bankAccountRemovingDto.getSwiftCode()));
        
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
