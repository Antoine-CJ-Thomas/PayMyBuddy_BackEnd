package com.paymybuddy.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.jsoniter.output.JsonStream;
import com.paymybuddy.app.dto.BankAccountAddingDto;
import com.paymybuddy.app.dto.BankAccountRemovingDto;
import com.paymybuddy.app.dto.BankAccountRetrievingDto;
import com.paymybuddy.app.dto.UserAccountCreatingDto;
import com.paymybuddy.app.dto.UserAccountDeletingDto;
import com.paymybuddy.app.dto.UserAccountEditingDto;
import com.paymybuddy.app.dto.UserAccountLoginDto;
import com.paymybuddy.app.dto.UserAccountRetrievingDto;
import com.paymybuddy.app.dto.UserContactAddingDto;
import com.paymybuddy.app.dto.UserContactRemovingDto;
import com.paymybuddy.app.dto.UserContactRetrievingDto;
import com.paymybuddy.app.model.UserAccount;

@SpringBootApplication
public class App {

    private static final Logger logger = LogManager.getLogger("App");
	
    public static void main( String[] args ) {
        logger.info("main");

		SpringApplication.run(App.class, args);
		
		//PROVISOIRE
		
		System.out.println();
		System.out.println("UserAccount : " + JsonStream.serialize(new UserAccount()));
		
		System.out.println();
		System.out.println("UserAccountCreatingDto : " + JsonStream.serialize(new UserAccountCreatingDto("emailAddress", "password", "firstName", "lastName")));
		System.out.println("UserAccountDeletingDto : " + JsonStream.serialize(new UserAccountDeletingDto("emailAddress", "password")));
		System.out.println("UserAccountEditingDto : " + JsonStream.serialize(new UserAccountEditingDto("emailAddress", "password", "firstName", "lastName")));
		System.out.println("UserAccountLoginDto : " + JsonStream.serialize(new UserAccountLoginDto("emailAddress", "password")));
		System.out.println("UserAccountRetrievingDto : " + JsonStream.serialize(new UserAccountRetrievingDto("emailAddress")));

		System.out.println();
		System.out.println("UserContactAddingDto : " + JsonStream.serialize(new UserContactAddingDto("userEmailAddress", "contactEmailAddress")));
		System.out.println("UserContactRemovingDto : " + JsonStream.serialize(new UserContactRemovingDto("userEmailAddress", "contactEmailAddress")));
		System.out.println("UserContactRetrievingDto : " + JsonStream.serialize(new UserContactRetrievingDto("emailAddress")));

		System.out.println();
		System.out.println("BankAccountAddingDto : " + JsonStream.serialize(new BankAccountAddingDto("userEmailAddress", "accountNumber", "swiftCode")));
		System.out.println("BankAccountRemovingDto : " + JsonStream.serialize(new BankAccountRemovingDto("userEmailAddress", "accountNumber", "swiftCode")));
		System.out.println("BankAccountRetrievingDto : " + JsonStream.serialize(new BankAccountRetrievingDto("emailAddress")));
		
		System.out.println();
    }
}
