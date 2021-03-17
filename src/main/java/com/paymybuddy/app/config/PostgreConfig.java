package com.paymybuddy.app.config;

import org.springframework.stereotype.Component;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
*
*/
@Component
public class PostgreConfig implements DataBaseConfig {

	private String url;
	private String user;
	private String password;

	private boolean queryExecutedSuccessfully;

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
			e.printStackTrace();
		}
	}

	@Override
	public int insertQuery(String query) {

		Connection connection = null;
		Statement statement = null;
		
		int executeReturn = 0;

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);
			executeReturn = statement.executeUpdate(query);
			connection.commit();

			statement.close();
			connection.close();

			queryExecutedSuccessfully = true;

		} catch (SQLException e) {

			e.printStackTrace();

			queryExecutedSuccessfully = false;
			
		} finally {

			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		return executeReturn;
	}

	@Override
	public ResultSet selectQuery(String query) {

		Connection connection = null;
		Statement statement = null;
		ResultSet resultSet = null;

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);
			statement = connection.createStatement();
			resultSet = statement.executeQuery(query);

			statement.close();
			connection.close();

			queryExecutedSuccessfully = true;

		} catch (SQLException e) {

			e.printStackTrace();

			queryExecutedSuccessfully = false;
			
		} finally {

			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return resultSet;
	}

	@Override
	public int updateQuery(String query) {

		Connection connection = null;
		Statement statement = null;
		
		int executeReturn = 0;

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);
			executeReturn = statement.executeUpdate(query);
			connection.commit();

			statement.close();
			connection.close();

			queryExecutedSuccessfully = true;

		} catch (SQLException e) {

			e.printStackTrace();

			queryExecutedSuccessfully = false;
			
		} finally {

			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}

		return executeReturn;
	}

	@Override
	public int deleteQuery(String query) {

		Connection connection = null;
		Statement statement = null;
		
		int executeReturn = 0;

		try {

			connection = DriverManager.getConnection(url, user, password);
			statement = connection.createStatement();

			connection.setAutoCommit(false);
			executeReturn = statement.executeUpdate(query);
			connection.commit();

			queryExecutedSuccessfully = true;

		} catch (SQLException e) {

			e.printStackTrace();

			queryExecutedSuccessfully = false;
			
		} finally {

			if (statement != null) {

				try {
					statement.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}

			if (connection != null) {

				try {
					connection.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
		
		return executeReturn;
	}

	@Override
	public boolean isQueryExecutedSuccessfully() {
		return queryExecutedSuccessfully;
	}
}
