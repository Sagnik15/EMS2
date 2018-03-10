package com.techm.service;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.bean.MedicineBean;
import com.techm.bean.UserBean;
import com.techm.connectDb.DbConnect;
import com.techm.dao.AdminDao;
import com.techm.dao.SearchDao;

public class AdminService {

	public static void addUserService(String UId, String name, long phone,
			String dno, String street, String city, String state, long pin, String role)
			throws ClassNotFoundException, SQLException {

		UserBean ub = new UserBean();
		ub.setUId(UId);
		ub.setName(name);
		ub.setPhone(phone);
		ub.setDno(dno);
		ub.setStreet(street);
		ub.setCity(city);
		ub.setState(state);
		ub.setPin(pin);
        ub.setRole(role);
		AdminDao.addUserDao(ub);

	}
	
		

	public static UserBean displayFaoDao(Connection con,UserBean ub) throws SQLException{
			
			ResultSet rs1=AdminDao.displayFaoDao(con, ub);
			
			while(rs1.next()){
				
				String uid=rs1.getString("U_ID");
				String name= rs1.getString("Name");
				long phone=rs1.getLong("Phone");
				String dno=rs1.getString("DNo");
				String street=rs1.getString("Street");
				String city=rs1.getString("City");
				String state=rs1.getString("State");
				long pin=rs1.getLong("Pin");
				
				ub.setUId(uid);
				ub.setName(name);
				ub.setPhone(phone);
				ub.setDno(dno);
				ub.setStreet(street);
				ub.setCity(city);
				ub.setState(state);
				ub.setPin(pin);
								
			}
			return ub;
		
	}


	public static boolean placeOrder(String orderId, String medId, String suppId,
			String suppName, String quant, String odate) throws ClassNotFoundException, SQLException, ServletException, IOException, ParseException {
	
		
		boolean res = false;
		ResultSet rs = SearchDao.getMed();
		System.out.println("resultset fetched!");
		
                 while(rs.next()){
                	 
                String mId = 	 rs.getString("med_Id");
                	 
                	 if(mId.equalsIgnoreCase(medId)){
                		 
                		 res = true;
                	 }
                	 
                 }		
		if(res==true){
			
			AdminDao.placeOrder(orderId, medId, suppId,
					suppName, quant, odate);
			System.out.println("row inserted");
		}
		return res;
			
		
		
	}
	
	
	
	public static boolean addToInventory(String bid, String sid, String sname, String ad, String ed, String quant, String mid) throws ClassNotFoundException, SQLException, ServletException, IOException, ParseException {
	
		ResultSet rs = SearchDao.getMed();
		boolean res = false;
                 while(rs.next()){
                	 
                String mId = 	 rs.getString("med_Id");
                	 
                	 if(mId.equalsIgnoreCase(mid)){
                		 
                		 res = true;
                	 }
                	 
                 }		
		if(res==true){
			
			AdminDao.addToInventory(bid, sid, sname, ad, ed, quant, mid);
			
		}
		
		return res;
		
	}


	public static LinkedList<MedicineBean> viewExpired() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		ResultSet rs = SearchDao.searchMedbyName();
		
		Date date = new Date();
		LinkedList<MedicineBean> ll = new LinkedList<MedicineBean>();
		System.out.println("inside viewExpired method in admin service");
		while(rs.next()){
			System.out.println("inside while");
			MedicineBean mb = new MedicineBean();
			mb.setMedId(rs.getString("Med_Id"));
			mb.setMedName(rs.getString("Med_Name"));
			mb.setMedPrice(rs.getInt("Med_price"));
			mb.setBatchId(rs.getString("Batch_Id"));
			mb.setSupplierId(rs.getString("Supplier_Id"));
			mb.setSupplierName(rs.getString("supplier_name"));
			mb.setExpiryDate(rs.getDate("exp_date"));
			mb.setQuantity(rs.getInt("Quantity"));
			
			Date exd = rs.getDate("exp_date");
			
			if(exd.before(date)){
			ll.add(mb);
			}
		}
		
		
		
		return ll;
		
		
		
		
	}


	public static void returmItem(ArrayList arr) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		
		
		
		
		
		Iterator itr = arr.iterator();
		while(itr.hasNext()){
						
			System.out.println("inside while of return item method in admin service");
			String BatchId = (String) itr.next();
		AdminDao.removeMed(BatchId);
		}
		
	}


	public static void deleteUser(String uid, String name) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	
		ResultSet rs = AdminDao.fetchUserDetails();
		
		Connection con = null;
		con = DbConnect.createConnection();
		
		while(rs.next()){
		
		String userid = rs.getString("U_id");
		
		if(uid.equals(userid)){
		
		UserBean ub = new UserBean();
		
		ub.setUId(uid);
		ub.setName(rs.getString("name"));
		ub.setPhone(rs.getLong("phone"));
		ub.setDno(rs.getString("dno"));
		ub.setStreet(rs.getString("street"));
		ub.setCity(rs.getString("city"));
		ub.setState(rs.getString("state"));
		ub.setRole(rs.getString("role"));
		
		AdminDao.backUpUsers(ub);
		}	
	}
	
		AdminDao.deleteUserDao(uid);
	 
	}



	public static ArrayList<MedicineBean> getExpiry(String sid, String dt) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		DateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
		java.sql.Date javaSqlDate = java.sql.Date.valueOf(dt);
		ArrayList<MedicineBean> arr = new ArrayList<MedicineBean>();
		ResultSet rs = SearchDao.searchMedbyName();
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
			String i = rs.getString("supplier_Id");
			
		
			mb.setBatchId(a);
			mb.setMedId(b);
			mb.setMedName(c);
			mb.setMedPrice(d);
			mb.setExpiryDate(e);
			mb.setQuantity(f);
			mb.setSupplierName(g);
			mb.setArrivalDate(h);
			mb.setSupplierId(i);
			System.out.println(mb.getMedName());
			
			if(i.equalsIgnoreCase(sid) && javaSqlDate.equals(e)){
				
				arr.add(mb);
			}
			
			
		}
		return arr;
		
		
	}
	
	
	
	

}
