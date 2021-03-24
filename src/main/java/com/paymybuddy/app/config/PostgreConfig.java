package com.paymybuddy.app.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

/**
*
*/
@Component
public class PostgreConfig implements DataBaseConfig {

    private static final Logger logger = LogManager.getLogger("PostgreConfig");

	private String url;
	private String user;
	private String password;

	private String sqlExceptionState;

	public PostgreConfig() {

		Properties properties = new Properties();

		try {

			InputStream inputStream = new FileInputStream("src/main/resources/jdbc.properties");

			if (inputStream != null) {

				properties.load(inputStream);

				this.url = properties.getProperty("postgre.url");
				this.user = properties.getProperty("postgre.user");
				this.password = properties.getProperty("postgre.password");
			}

		} catch (IOException e) {
			
	        logger.error(e);
		}
	}

	@Override
	public void executeUpdate(ArrayList<String> queryList) {

		Connection connection = null;
		Statement statement = null;
		
		sqlExceptionState = "00000";

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);
			
			for (String query : queryList) {

				statement.executeUpdate(query);
			}
			
			connection.commit();

		} catch (SQLException e) {
			
	        logger.error(e);
	        
	        sqlExceptionState = e.getSQLState();
	        
			rollbackTransaction(connection);
			
		} finally {
			
			closeStatement(statement);
			closeConnection(connection);
		}
	}

	@Override
	public ResultSet executeQuery(ArrayList<String> queryList) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;
		
		sqlExceptionState = "00000";

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);
			
			for (String query : queryList) {

				resultSet = statement.executeQuery(query);
			}

		} catch (SQLException e) {
			
	        logger.error(e);
	        
	        sqlExceptionState = e.getSQLState();
	        
			rollbackTransaction(connection);
			
		} finally {
			
			closeStatement(statement);
			closeConnection(connection);
		}
		
		return resultSet;
	}

	@Override
	public String getSQLExceptionState() {
		return sqlExceptionState;
	}
	
	private void rollbackTransaction(Connection connection) {

		if (connection != null) {

			try {
				connection.rollback();
			} catch (SQLException e) {
		        logger.error(e);
			}
		}
	}
	
	private void closeStatement(Statement statement) {

		if (statement != null) {

			try {
				statement.close();
			} catch (SQLException e) {
		        logger.error(e);
			}
		}
	}
	
	private void closeConnection(Connection connection) {

		if (connection != null) {

			try {
				connection.close();
			} catch (SQLException e) {
		        logger.error(e);
			}
		}
	}
}
