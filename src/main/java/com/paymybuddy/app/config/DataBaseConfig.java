package com.paymybuddy.app.config;

import java.sql.ResultSet;

public interface DataBaseConfig {
	
    public void insertQuery(String query);
    public ResultSet selectQuery(String query);
    public void updateQuery(String query);
    public void deleteQuery(String query);
    public boolean isQueryExecutedSuccessfully();
 }