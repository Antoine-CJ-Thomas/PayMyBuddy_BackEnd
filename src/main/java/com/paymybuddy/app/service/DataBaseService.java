package com.paymybuddy.app.service;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import java.sql.*;

/**
*
*/
@Service
public class DataBaseService {

    private static final Logger logger = LogManager.getLogger("DataBaseConfig");
    
    private String url;
    private String user;
    private String password;
    

    public DataBaseService() {}
    
    public DataBaseService(String url, String user, String password) {
    	
    	this.url = url;
    	this.user = user;
    	this.password = password;
    }
    
    public void InsertOperation(String insertRequest) {
        logger.info("InsertOperation(" + insertRequest + ")");
    	
        Connection connection = null;
        Statement statement = null;
        
        try {
           
           connection = DriverManager.getConnection(url,user,password);
           connection.setAutoCommit(false);
           
           statement = connection.createStatement();
           statement.executeUpdate(insertRequest);

           connection.commit();
           
           logger.info("Insert operation done successfully");

        } catch (Exception e) {
        	
            logger.error("Insert operation throw exception : " + e.getMessage());
            
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
    }
    
    public ResultSet selectOperation(String selectRequest) {
        logger.info("selectOperation(" + selectRequest + ")");
    	
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        
        try {
            
           connection = DriverManager.getConnection(url,user,password);
           connection.setAutoCommit(false);
           
           statement = connection.createStatement();
           resultSet = statement.executeQuery(selectRequest);

           connection.commit();
           
           logger.info("Select operation done successfully");
           
        } catch (Exception e) {
        	
            logger.error("Select operation throw exception : " + e.getMessage());
            
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
    
    public void updateOperation(String updateRequest) {
        logger.info("updateOperation(" + updateRequest + ")");
    	
        Connection connection = null;
        Statement statement = null;
        
        try {
            
           connection = DriverManager.getConnection(url,user,password);
           connection.setAutoCommit(false);
           
           statement = connection.createStatement();
           statement.executeUpdate(updateRequest);

           connection.commit();
           
           logger.info("Update operation done successfully");

        } catch (Exception e) {
        	
            logger.error("Update operation throw exception : " + e.getMessage());
            
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
    }
    
    public void deleteOperation(String deleteRequest) {
        logger.info("deleteOperation(" + deleteRequest + ")");

        Connection connection = null;
        Statement statement = null;
        
        try {
            
           connection = DriverManager.getConnection(url,user,password);
           connection.setAutoCommit(false);
           
           statement = connection.createStatement();
           statement.executeUpdate(deleteRequest);

           connection.commit();
           
           logger.info("Delete operation done successfully");
           
        } catch (Exception e) {
        	
            logger.error("Delete operation throw exception : " + e.getMessage());
            
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
    }
}
