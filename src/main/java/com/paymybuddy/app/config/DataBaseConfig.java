package com.paymybuddy.app.config;

import java.sql.ResultSet;
import java.util.ArrayList;

public interface DataBaseConfig {
	
    public void executeUpdate(ArrayList<String> queryList);
    public ResultSet executeQuery(ArrayList<String> queryList);
    public String getSQLExceptionState();
 }