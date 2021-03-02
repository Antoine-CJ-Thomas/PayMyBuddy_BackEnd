package com.paymybuddy.app.repository;

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

	public void insertInternalTransaction(String userEmailAddress, String contactEmailAddress, float amount, String description) {
        logger.info("insertInternalTransaction(" + userEmailAddress + "," + contactEmailAddress + "," + amount + "," + description + ")");
				
		String request 	= "INSERT "
						+ "INTO internal_transaction (user_id,contact_id,date_time,amount,description) "
						+ "VALUES ("
						
							+ "("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + userEmailAddress + "'"
								
							+ "),("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + contactEmailAddress + "'"
								
							+ "),("
							
								+ "'" + new Timestamp(System.currentTimeMillis()) + "'"
								
							+ "),("
							
								+ amount
							
							+ "),("
							
								+ "'" + description + "'"
							
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

	public void selectInternalTransactionFromUser(String emailAddress, ArrayList<InternalTransaction> internalTransactionList) {
        logger.info("selectInternalTransactionFromUser(" + emailAddress + "," + internalTransactionList + ")");
		
		String request 	= "SELECT * "
						+ "FROM internal_transaction "
						+ "INNER JOIN user_account ON internal_transaction.contact_id = user_account.id "
						+ "WHERE "
						
							+ "internal_transaction.user_id = ("
							
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
				
				internalTransactionList.add(new InternalTransaction(
						
						new UserContact(dataBaseConfig.getResult().getString("email_address"), dataBaseConfig.getResult().getString("first_name"), dataBaseConfig.getResult().getString("last_name")), 
						new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(dataBaseConfig.getResult().getTimestamp("date_time")), 
						dataBaseConfig.getResult().getString("description"),
						(dataBaseConfig.getResult().getFloat("amount")*(-1))));
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			dataBaseConfig.closeResult();
	    }
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	}

	public void selectInternalTransactionToUser(String emailAddress, ArrayList<InternalTransaction> internalTransactionList) {
        logger.info("selectInternalTransactionToUser(" + emailAddress + "," + internalTransactionList + ")");
		
		String request 	= "SELECT * "
						+ "FROM internal_transaction "
						+ "INNER JOIN user_account ON internal_transaction.contact_id = user_account.id "
						+ "WHERE "
						
							+ "internal_transaction.contact_id = ("
							
								+ "SELECT user_account.id "
								+ "FROM user_account "
								+ "WHERE user_account.email_address = '" + emailAddress + "'"
								
							+ ")"
						+ ";";
		
		dataBaseConfig.openConnection();
		dataBaseConfig.createStatement();
				
		dataBaseConfig.createResult(request);
		
		System.out.println(request);
				
    	try {
    		
			while (dataBaseConfig.getResult().next()) {
				
				internalTransactionList.add(new InternalTransaction(
						
						new UserContact(dataBaseConfig.getResult().getString("email_address"), dataBaseConfig.getResult().getString("first_name"), dataBaseConfig.getResult().getString("last_name")), 
						new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(dataBaseConfig.getResult().getTimestamp("date_time")), 
						dataBaseConfig.getResult().getString("description"),
						(dataBaseConfig.getResult().getFloat("amount"))));
			}

		} catch (SQLException e) {
            logger.error("- ResultSet throw exception : " + e.getMessage());
		} finally {
			dataBaseConfig.closeResult();
	    }
		
		dataBaseConfig.closeStatement();
		dataBaseConfig.closeConnection();
	}
}
