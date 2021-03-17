package com.paymybuddy.app.config;

import java.sql.ResultSet;

public interface DataBaseConfig {
	
    public int insertQuery(String query);
    public ResultSet selectQuery(String query);
    public int updateQuery(String query);
    public int deleteQuery(String query);
    public boolean isQueryExecutedSuccessfully();
 }