package com.paymybuddy.app.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.paymybuddy.app.model.InternalTransaction;
import com.paymybuddy.app.model.UserContact;
import com.paymybuddy.app.config.DataBaseConfig;
import com.paymybuddy.app.config.PostgreConfig;

/**
 *
 */
@Component
public class InternalTransactionRepository {

    private static final Logger logger = LogManager.getLogger("InternalTransactionRepository");

    private DataBaseConfig dataBaseConfig;
    
    public InternalTransactionRepository() {
        logger.info("InternalTransactionRepository()");
    	dataBaseConfig = new PostgreConfig();
    }

	public String insertInternalTransaction(String userEmailAddress, String contactEmailAddress, String description, float amount) {
        logger.info("insertInternalTransaction(" + userEmailAddress + "," + contactEmailAddress + "," + description + "," + amount + ")");
        
        ArrayList<String> queryList = new ArrayList<String>();
				
		String insertInternalTransactionQuery 
		
			= "INSERT INTO internal_transaction (user_id,contact_id,date_time,amount,description) VALUES ("
			
				+ "(SELECT user_account.id FROM user_account WHERE user_account.email_address = '" + userEmailAddress + "'),"
				+ "(SELECT user_account.id FROM user_account WHERE user_account.email_address = '" + contactEmailAddress + "'),"
				+ "('" + new Timestamp(System.currentTimeMillis()) + "'),"
				+ "(" + amount + "),"
				+ "('" + description + "'));";
		
		String editUserAccountQuery = "UPDATE user_account SET balance = balance - " + amount + " WHERE email_address = '" + userEmailAddress + "';";
		String editContactAccountQuery = "UPDATE user_account SET balance = balance + " + amount + " WHERE email_address = '" + contactEmailAddress + "';";

		queryList.add(insertInternalTransactionQuery);
		queryList.add(editUserAccountQuery);
		queryList.add(editContactAccountQuery);

		dataBaseConfig.executeUpdate(queryList);
		
		return dataBaseConfig.getSQLExceptionState();
	}

	public String selectInternalTransactionList(String emailAddress, ArrayList<InternalTransaction> internalTransactionList) {
        logger.info("selectInternalTransactionList(" + emailAddress + "," + internalTransactionList + ")");
        
        ArrayList<String> queryList = new ArrayList<String>();
		
		String selectInternalTransactionListQuery 
		
			= "SELECT "
				
				+ "internal_transaction.date_time, "
				+ "user_table.email_address AS user_email_address, "
				+ "user_table.first_name AS user_first_name, "
				+ "user_table.last_name AS user_last_name, "
				+ "contact_table.email_address AS contact_email_address, "
				+ "contact_table.first_name AS contact_first_name,"
				+ "contact_table.last_name AS contact_last_name,"
				+ "internal_transaction.amount,"
				+ "internal_transaction.description "
			
			+ "FROM internal_transaction "
			+ "INNER JOIN user_account AS user_table ON internal_transaction.user_id = user_table.id "
			+ "INNER JOIN user_account AS contact_table ON internal_transaction.contact_id = contact_table.id "
			+ "WHERE "
			
				+ "internal_transaction.user_id = (SELECT user_account.id FROM user_account WHERE user_account.email_address = '" + emailAddress + "') OR "			
				+ "internal_transaction.contact_id = (SELECT user_account.id FROM user_account WHERE user_account.email_address = '" + emailAddress + "')"
									
			+ "ORDER BY internal_transaction.date_time DESC";

		queryList.add(selectInternalTransactionListQuery);

		ResultSet resultSet = dataBaseConfig.executeQuery(queryList);
		
    	try {
    		
			while (resultSet.next()) {
								
				if (resultSet.getString("user_email_address").equals(emailAddress)) {

					internalTransactionList.add(new InternalTransaction(
							
							new UserContact(resultSet.getString("contact_email_address"), resultSet.getString("contact_first_name"), resultSet.getString("contact_last_name")), 
							new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(resultSet.getTimestamp("date_time")), 
							resultSet.getString("description"),
							(resultSet.getFloat("amount")*(-1))));
				}
				
				else {

					internalTransactionList.add(new InternalTransaction(
							
							new UserContact(resultSet.getString("user_email_address"), resultSet.getString("user_first_name"), resultSet.getString("user_last_name")), 
							new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(resultSet.getTimestamp("date_time")), 
							resultSet.getString("description"),
							resultSet.getFloat("amount")));
				}
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
		
		return dataBaseConfig.getSQLExceptionState();
	}
}
