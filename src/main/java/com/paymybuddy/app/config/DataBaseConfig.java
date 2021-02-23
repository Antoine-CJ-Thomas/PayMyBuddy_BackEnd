package com.paymybuddy.app.config;

import java.sql.ResultSet;

public interface DataBaseConfig {

	public void openConnection();
	public void closeConnection();
    
    public void createStatement();
    public void executeUpdateStatement(String request);
<<<<<<< HEAD
    public void closeStatement();

    public void createResult(String request);
    public ResultSet getResult();
    public void closeResult();
    
=======
    public ResultSet executeQueryStatement(String request);
    public void closeStatement();

>>>>>>> refs/remotes/origin/develop
    public void disableAutoCommit();
    public void commit();
 }