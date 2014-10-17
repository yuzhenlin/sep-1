package com.SEP.utils;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	private static DataSource userDs;
	private static DataSource applicationDs;
	
	static{
		userDs = new ComboPooledDataSource();
		applicationDs =new ComboPooledDataSource("applicationdatabase");
	}
	
	public static DataSource getUserDataSource(){
		return userDs;
	}
	
	public static DataSource getApplicationDataSource(){
		return applicationDs;
	}
	
}
