package com.techm.service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import com.techm.bean.MedicineBean;
import com.techm.bean.UserBean;
import com.techm.dao.AdminDao;
import com.techm.dao.SearchDao;

public class FindUserService {

	public static LinkedList fetchUserDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		ResultSet rs = AdminDao.fetchUserDetails();
System.out.println("resultset fetched in Find User service");
		
		LinkedList<UserBean> arr = new LinkedList<UserBean>();
		
		
		//java.util.Date sqd = new java.util.Date().getDate());
		System.out.println("before while");
		
		 
		while(rs.next()){
			
			UserBean ub = new UserBean();
			String a = rs.getString("u_id");
			String b = rs.getString("name");
			long c = rs.getLong("phone");
			String d = rs.getString("dno");
			String e =(rs.getString("street"));
			String f = rs.getString("city");
			String g = rs.getString("state");
			long h = rs.getLong("pin");
			
		ub.setUId(a);
		ub.setName(b);
		ub.setPhone(c);
		ub.setDno(d);
		ub.setStreet(e);
		ub.setCity(f);
		ub.setState(g);
		ub.setPin(h);
		
			
			
		
			
			
			arr.add(ub);
			
		}
		System.out.println("after while");
		
		
		
		
		return arr;
		
	}

}
