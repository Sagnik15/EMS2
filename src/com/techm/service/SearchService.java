package com.techm.service;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import com.techm.bean.MedicineBean;
import com.techm.dao.SearchDao;

public class SearchService {

public static  LinkedList<MedicineBean> fetchMed() throws SQLException, ClassNotFoundException{
		
		ResultSet rs = SearchDao.searchMed();
		
		System.out.println("resultset fetched in search service");
		
		LinkedList<MedicineBean> arr = new LinkedList<MedicineBean>();
		
		
		//java.util.Date sqd = new java.util.Date().getDate());
		System.out.println("before while");
		 DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		   //get current date time with Date()
		   Date date = new Date();
		   
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
			
		
			mb.setBatchId(a);
			mb.setMedId(b);
			mb.setMedName(c);
			mb.setMedPrice(d);
			mb.setExpiryDate(e);
			mb.setQuantity(f);
			mb.setSupplierName(g);
			System.out.println(rs.getString("Med_Id") + "++++ "+rs.getString("Med_Name")+" ++++"+rs.getInt("Med_Price"));
		
			if(mb.getExpiryDate().after(date)){
			
			arr.add(mb);
			}
		}
		System.out.println("after while");
		
		Iterator<MedicineBean> itr = arr.iterator();
		while(itr.hasNext()){
			
			MedicineBean medb = (MedicineBean)itr.next();
			System.out.println(medb.getMedId() + medb.getMedName() + medb.getMedPrice());
			
		
		}
		
		return arr;
		
	}

public static String addMed(String id, String name, String price) throws ClassNotFoundException, SQLException {

	
	
	String result = SearchDao.addMed(id, name, price);
	return result;
}
	
}
