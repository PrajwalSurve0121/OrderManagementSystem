package com.Connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnect {
	
	static Connection conn=null;
	public static final String JDBC_DRIVER="com.mysql.cj.jdbc.Driver"; 
	public static final String JDBC_URL="jdbc:mysql://localhost:3306/Orderms";
	public static final String USERNAME="root";
	public static final String PASSWORD="root";

	public static Connection getConnect() {
		
		try
		{
			Class.forName(JDBC_DRIVER);
			
			conn=DriverManager.getConnection(JDBC_URL, USERNAME, PASSWORD);
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		
		return conn;
		
	}

}
