package com.techm.util;

import java.sql.*;
public class DBConnect 
{
	public static Connection connect(){
		Connection con=null;
		try{
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("driver found");
			con=DriverManager.getConnection("jdbc:mysql://localhost/EMS","root","");
		System.out.println("connected");	
		}
		catch(Exception e){
			e.printStackTrace();
			}
		return con;
		}
}
