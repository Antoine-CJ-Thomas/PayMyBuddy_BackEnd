package com.paymybuddy.app.repository;

import java.sql.ResultSet;
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

	public boolean insertUserContact(String userEmailAddress, String contactEmailAddress) {
        logger.info("insertUserContact(" + userEmailAddress + "," + contactEmailAddress + ")");
				
		String query 	= "INSERT "
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

		dataBaseConfig.insertQuery(query);
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
	}

	public boolean selectUserContactList(String emailAddress, ArrayList<UserContact> userContactList) {
        logger.info("selectUserContactList(" + emailAddress + "," + userContactList + ")");
		
		String query 	= "SELECT * "
						+ "FROM user_account "
						+ "INNER JOIN user_contact ON user_account.id = user_contact.contact_id "
						+ "WHERE "
						
							+ "user_contact.user_id = ("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + emailAddress + "'"
								
							+ ")"
						+ ";";

		ResultSet resultSet = dataBaseConfig.selectQuery(query);
		
    	try {
    		
			while (resultSet.next()) {
				
				userContactList.add(new UserContact(
						resultSet.getString("email_address"), 
						resultSet.getString("first_name"), 
						resultSet.getString("last_name")));
			}

		} catch (SQLException e) {
			e.printStackTrace();
            
		} finally {
			
			try {
				
				if (resultSet != null) {
					resultSet.close();
				}
				
			} catch (SQLException e) {
				e.printStackTrace();
			}
	    }
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
    }

	public boolean deleteUserContact(String userEmailAddress, String contactEmailAddress) {
        logger.info("deleteUserContact(" + userEmailAddress + "," + contactEmailAddress + ")");
        
		String query 	= "DELETE "
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
        
		dataBaseConfig.deleteQuery(query);
		
		return dataBaseConfig.isQueryExecutedSuccessfully();
	}
}
