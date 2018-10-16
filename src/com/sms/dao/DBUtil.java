package com.sms.dao;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtil {

	static Connection con = null;
	static InputStream input;
	
	public DBUtil() {
		try {
			
			String name = "app.properties";
			Properties properties = new Properties();
			input = getClass().getClassLoader().getResourceAsStream(name);
			try {
				properties.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			Class.forName(properties.getProperty("CLASS_DRIVER"));
			
			con = DriverManager.getConnection(
					properties.getProperty("DATABASE_URL"), 
					properties.getProperty("DATABASE_USERNAME"), 
					properties.getProperty("DATABASE_PASSWORD"));
			
	        System.out.println("Connection Established!");
	        setConnection(con);
	        
		} catch (ClassNotFoundException | SQLException e) {

			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    
    public static Connection getConnection() {
    	if (con == null) {
    		new DBUtil();
    	}
    	return con;
    }
    
    public void setConnection(Connection cnt) {
    	DBUtil.con = cnt;
    }
} 