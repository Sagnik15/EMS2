package com.techm.connectDb;
import java.sql.*;
public class DbConnect {
	
	public static Connection con = null;
	public static Connection createConnection() throws ClassNotFoundException, SQLException{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		System.out.println("driver found");
		
	String url = "jdbc:oracle:thin:@172.16.154.10:1521:elp";
	String uid = "elp1737";
	String pwd = "msat123$";
	
	con = DriverManager.getConnection(url,uid,pwd);
		
		System.out.println("connected");
		return con;
	}

}
