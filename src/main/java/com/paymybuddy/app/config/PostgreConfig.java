package com.paymybuddy.app.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;
import java.sql.*;

/**
*
*/
@Component
public class PostgreConfig implements DataBaseConfig{

    private static final Logger logger = LogManager.getLogger("DataBaseConfig");
    
    private String url;
    private String user;
    private String password;
    
    private Connection connection;
    private Statement statement;
    private ResultSet resultSet;
    
    public PostgreConfig() {
    	
    	this.url = "jdbc:postgresql://localhost:5432/app";
    	this.user = "usertest";
    	this.password = "testuser";
    }

	@Override
	public void openConnection() {
		
        try {
			connection = DriverManager.getConnection(url,user,password);
		} catch (SQLException e) {
            logger.error("- Open connection throw exception : " + e.getMessage());
		}
	}

	@Override
	public void closeConnection() {

        if (connection != null) {
        	try {
        		connection.close();
			} catch (SQLException e) {
	            logger.error("- Close connection throw exception : " + e.getMessage());
			}
		}
    }

	@Override
	public void createStatement() {
		
        try {
			statement = connection.createStatement();
		} catch (SQLException e) {
            logger.error("- Open statement throw exception : " + e.getMessage());
		}
	}

	@Override
	public void executeUpdateStatement(String request) {

        try {
			statement.executeUpdate(request);
		} catch (SQLException e) {
            logger.error("- Execute statement throw exception : " + e.getMessage());
		}
	}

	@Override
	public void createResult(String request) {
		
        try {
			resultSet = statement.executeQuery(request);
		} catch (SQLException e) {
            logger.error("- Open resultSet throw exception : " + e.getMessage());
		}
	}

	@Override
	public ResultSet getResult() {
		return resultSet;
	}

	@Override
	public void closeResult() {

        if (resultSet != null) {
        	try {
        		resultSet.close();
			} catch (SQLException e) {
	            logger.error("- Close resultSet throw exception : " + e.getMessage());
			}
		}
    }

	@Override
	public void closeStatement() {
    	
        if (statement != null) {
        	try {
				statement.close();
			} catch (SQLException e) {
	            logger.error("- Close statement throw exception : " + e.getMessage());
			}
		}
    }

	@Override
	public void disableAutoCommit() {

        try {
			connection.setAutoCommit(false);
		} catch (SQLException e) {
            logger.error("- Disable automatic commit throw exception : " + e.getMessage());
		}
	}

	@Override
	public void commit() {

        try {
			connection.commit();
		} catch (SQLException e) {
            logger.error("- Commit throw exception : " + e.getMessage());
		}
	}
}
