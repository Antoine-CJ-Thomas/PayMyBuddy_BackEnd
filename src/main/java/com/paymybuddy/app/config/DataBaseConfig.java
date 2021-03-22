package com.paymybuddy.app.config;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DataBaseConfig {
	
    public void insertQuery(ArrayList<String> queryList);
    public ResultSet selectQuery(ArrayList<String> queryList);
    public void updateQuery(ArrayList<String> queryList);
    public void deleteQuery(ArrayList<String> queryList);
    public String getSQLExceptionState();
 }