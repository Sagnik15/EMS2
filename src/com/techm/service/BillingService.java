package com.techm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;
import java.util.Date;
import java.sql.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.techm.bean.MedicineBean;
import com.techm.connectDb.DbConnect;
import com.techm.dao.BillingDao;
import com.techm.dao.SearchDao;




public class BillingService {

	
	
	public static ArrayList<MedicineBean> addToCart(String item_name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		ArrayList<MedicineBean> al = new ArrayList<MedicineBean>();
		
		
		ResultSet rs = SearchDao.searchMedbyName();
		System.out.println("srch dao methd executed in billing service");
		  Date date = new Date();
		  
		//System.out.println(rs.next());
		
		while(rs.next()){
			
			MedicineBean mb = null;
			mb=	new MedicineBean();
			
			
			
			String a = rs.getString("batch_Id");
			String b = rs.getString("Med_Id");
			String c = rs.getString("Med_Name");
			int d = rs.getInt("Med_Price");
			Date e =(rs.getDate("exp_Date"));
			int f = rs.getInt("quantity");
			String g = rs.getString("supplier_Name");
			Date h = rs.getDate("arrival_Date");
			
		
			mb.setBatchId(a);
			mb.setMedId(b);
			mb.setMedName(c);
			mb.setMedPrice(d);
			mb.setExpiryDate(e);
			mb.setQuantity(f);
			mb.setSupplierName(g);
			mb.setArrivalDate(h);
			System.out.println(mb.getMedName());
			System.out.println(item_name);
			
			if(mb.getMedName().equalsIgnoreCase(item_name)){
				
				if(mb.getExpiryDate().after(date)){
					
					
				
			al.add(mb);
				}
			System.out.println("item is added");
			}
			
			
		}
		
		
		System.out.println("item adding done");
		
		
		return al;
	}

	public static MedicineBean getEarliestExpiry(String item_name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
                                  ResultSet rs = SearchDao.searchMed();
		
		while(rs.next()){
			
			MedicineBean mb = null;
			mb=	new MedicineBean();
			String a = rs.getString("batch_Id");
			String b = rs.getString("Med_Id");
			String c = rs.getString("Med_Name");
			int d = rs.getInt("Med_Price");
			Date e =(rs.getDate("exp_Date"));
			int f = rs.getInt("quantity");
			String g = rs.getString("supplier_Name");
			Date h = rs.getDate("arrival_Date");
			
		
			mb.setBatchId(a);
			mb.setMedId(b);
			mb.setMedName(c);
			mb.setMedPrice(d);
			mb.setExpiryDate(e);
			mb.setQuantity(f);
			mb.setSupplierName(g);
			mb.setArrivalDate(h);
			
			
			
			
			
			
		
		
		
	}
		return null;

	

	
	}

	public static ArrayList displayList(String batchId, String quantity, HttpServletRequest request) throws ClassNotFoundException, SQLException {
		
		ResultSet rs = SearchDao.searchMed();
		HttpSession session = request.getSession();
		
		// TODO Auto-generated method stub
		return null;
	}
	
}
