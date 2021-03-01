package com.paymybuddy.app.repository;

import java.sql.SQLException;
import java.util.ArrayList;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.UserContact;
import com.paymybuddy.app.config.DataBaseConfig;
import com.paymybuddy.app.config.PostgreConfig;

/**
 *
 */
@Component
public class UserContactRepository {

    private static final Logger logger = LogManager.getLogger("UserContactRepository");

    private DataBaseConfig dataBaseConfig;
    
    public UserContactRepository() {
        logger.info("UserContactRepository()");
    	dataBaseConfig = new PostgreConfig();
    }

	public void insertUserContact(String userEmailAddress, String contactEmailAddress) {
        logger.info("insertUserContact(" + userEmailAddress + "," + contactEmailAddress + ")");
				
		String request 	= "INSERT "
						+ "INTO user_contact (user_id,contact_id) "
						+ "VALUES ("
						
							+ "("
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + userEmailAddress + "'"
								
							+ "),("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + contactEmailAddress + "'"
							
							+ ")"
							
						+ ");";
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		dataBaseConfig.disableAutoCommit();
		dataBaseConfig.executeUpdateStatement(request);
		dataBaseConfig.commit();
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();

	}

	public void selectUserContactList(String emailAddress, ArrayList<UserContact> userContactList) {
        logger.info("selectUserContact(" + emailAddress + "," + userContactList + ")");
		
		String request 	= "SELECT * "
						+ "FROM user_account "
						+ "INNER JOIN user_contact ON user_account.id = user_contact.contact_id "
						+ "WHERE "
						
							+ "user_contact.user_id = ("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + emailAddress + "'"
								
							+ ")"
						+ ";";
		
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
				
		dataBaseConfig.createResult(request);
				
    	try {
    		
			while (dataBaseConfig.getResult().next()) {
				
				userContactList.add(new UserContact(
						dataBaseConfig.getResult().getString("email_address"), 
						dataBaseConfig.getResult().getString("first_name"), 
						dataBaseConfig.getResult().getString("last_name")));
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			dataBaseConfig.closeResult();
	    }
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	}

	public void deleteUserContact(String userEmailAddress, String contactEmailAddress) {
        logger.info("deleteUserContact(" + userEmailAddress + "," + contactEmailAddress + ")");
        
		String request 	= "DELETE "
						+ "FROM user_contact "
						+ "WHERE "
						
							+ "user_contact.user_id = ("
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + userEmailAddress + "'"
							+ ") "
								
							+ "AND "
							
							+ "user_contact.contact_id = ("
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + contactEmailAddress + "'"
							+ ")"
						+ ";";
        
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
		
		dataBaseConfig.disableAutoCommit();
		dataBaseConfig.executeUpdateStatement(request);
		dataBaseConfig.commit();
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	}
}
