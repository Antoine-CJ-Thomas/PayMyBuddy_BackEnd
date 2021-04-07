package com.paymybuddy.app.config;

import java.sql.ResultSet;
import java.util.ArrayList;

/**
 * This interface allows to implement JDBC methods
 */
public interface DataBaseConfig {
	
    public void executeUpdate(ArrayList<String> queryList);
    public ResultSet executeQuery(ArrayList<String> queryList);
    public String getSQLExceptionState();
 }