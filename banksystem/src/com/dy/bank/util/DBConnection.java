package com.dy.bank.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	//Á¬½ÓjdbcµÄURL
	private static Connection connection = null;
	public static Connection getDBC() throws ClassNotFoundException{
		try {
			Class.forName("org.hsqldb.jdbcDriver");
	        connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost:9001/", "sa", "");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return connection;
	}	
}
