package com.techm.service;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.techm.dao.LoginDao;

public class ForgotPassword {
	
	public static String checkCredential(String uid, String name, Long phone) throws ClassNotFoundException{
	String result = null;
	try{
		
	
		
	ResultSet rs=LoginDao.loginDao();
	System.out.println("connection in Forgot service class");
	
	
	while(rs.next()){
		
		String userId = rs.getString("u_id");
	    String name2 = rs.getString("name");
	    String ph = rs.getString("phone");
	    //Long ph2 = Long.parseLong(ph);
	    String ph2 = phone.toString();
	    
	    
	    System.out.println("inside while");
		System.out.println(phone);
		System.out.println(ph2);
		System.out.println(name  + " " +  name2);
		System.out.println(userId  + " " +  uid);
		
		
		if(uid.trim().equals(userId.trim()) && name.trim().equals(name2.trim()) && ph2.equalsIgnoreCase(ph)){
		String q = rs.getString("pwd");
		result = q;
		System.out.println("inside if");
			break;
		}
		else{
			System.out.println("inside else");
			result = "No Match Found";
		
		}
		}
	}
	
	


catch( SQLException e){
	
	e.printStackTrace();
}
	return result;
	
	
	
	}
}
