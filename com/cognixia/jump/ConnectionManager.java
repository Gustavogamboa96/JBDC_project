package com.cognixia.jump;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionManager {
	private static final String URL = "jdbc:mysql:/ems";
	private static final String USERNAME = "root";
	private static final String PASSWORD = "admin";
	
	private static Connection conn = null;
	
	private static void makeConnection() {
		try {
			conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
			//System.out.println("wonderful");
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("couldnt connect");
		}
		
	}
	
	public Connection getConnection() {
		
		if(conn == null) {
			makeConnection();
		}
			
		
		return conn;
	}
	
	 

}
