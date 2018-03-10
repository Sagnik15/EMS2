package com.techm.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.techm.connectDb.DbConnect;

public class LoginDao {

	public static ResultSet loginDao() throws SQLException, ClassNotFoundException{

		Connection con= null;
		con = DbConnect.createConnection();
		
		
		Statement stmt = con.createStatement();
		System.out.println("connected....");

		
		/*String query="select * from try_pwd";*/
		String query="select * from ems_users";
		ResultSet rs = stmt.executeQuery(query);
		
		
		
		
		 System.out.println("query executed");
		 
		 
		 
		return rs;
    
		
	}
	
}
