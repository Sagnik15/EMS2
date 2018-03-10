package com.techm.service;
import java.sql.*;

import javax.servlet.http.HttpSession;

import com.techm.bean.LoginBean;
import com.techm.dao.LoginDao;

public class LoginService {

	public static boolean validateLogin(String uid,String pwd, String role) throws SQLException, ClassNotFoundException{
		
		boolean result = false;
		try{
			
			
			
		ResultSet rs=LoginDao.loginDao();
		System.out.println("connection in service class");
		
		
		
		
		
		/*LoginBean lb=new LoginBean();*/
		/*session.getAttribute(uid);*/
		
		
		/*
		System.out.println(lb.getUid());
		System.out.println(lb.getPwd());*/
		while(rs.next()){
			
			String userId = rs.getString("u_id");
		    String passwrd = rs.getString("pwd");
		    String role2 = rs.getString("role");
			
			if(uid.equals(userId) && pwd.equals(passwrd) && role.equalsIgnoreCase(role2)){
				result = true;
				break;
			}
		}
		
		
	

	}catch( SQLException e){
		
		e.printStackTrace();
	}
		return result;
}
}
