package com.techm.dao;

import java.sql.Date;
import java.util.Date.*;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import com.techm.bean.UserBean;
import com.techm.connectDb.DbConnect;

public class AdminDao {

	public static void addUserDao(UserBean ub) throws SQLException,
			ClassNotFoundException {

		Connection con = null;
		con = DbConnect.createConnection();

		Statement stmt = con.createStatement();
		ResultSet rs;

		System.out.println("inserting values to database");
		System.out.println(ub.getName());

		/*
		 * PreparedStatement psmt=con.prepareStatement(
		 * "insert into try_foa values('ub.getUId()','ub.getName()','ub.getPhone()','ub.getDno()','ub.getStreet()', 'ub.getCity()','ub.getState()','ub.getPin()')"
		 * );
		 */

		/*PreparedStatement psmt = con
				.prepareStatement("insert into ems_users values('ub.getUId()', 'ub.getName()','ub.getPhone()','ub.getDno()','ub.getStreet()','ub.getCity()','ub.getState()','ub.getPin()','','ub.getRole()')");*/
		
		PreparedStatement psmt = con
				.prepareStatement("insert into ems_users values(?,?,?,?,?,?,?,?,?,?)");
		psmt.setString(1, ub.getUId());
		psmt.setString(2, ub.getName());
		psmt.setLong(3, ub.getPhone());
		psmt.setString(4, ub.getDno());
		psmt.setString(5, ub.getStreet());
		psmt.setString(6, ub.getCity());
		psmt.setString(7, ub.getState());
		psmt.setLong(8, ub.getPin());
		psmt.setString(9, ub.getPassword());
		psmt.setString(10, ub.getRole());
		psmt.executeQuery();
		System.out.println("Insertion into table completed");

	}
	
	
	public static void deleteUserDao(String uid) throws SQLException, ClassNotFoundException{
		ResultSet rs;
		Connection con = null;
		con = DbConnect.createConnection();		
		System.out.println("about to delete");
			PreparedStatement pstmt= con.prepareStatement("DELETE FROM ems_users WHERE u_id = ? ");
			pstmt.setString(1, uid);
			pstmt.executeQuery();
		System.out.println("row deleted from user table");
		
			
	}
	
	public static ResultSet displayFaoDao(Connection con,UserBean ub) throws SQLException {
		
		ResultSet rs;
		Statement stmt=con.createStatement();
		
		PreparedStatement pstmt=con.prepareStatement("SELECT * FROM try_foa WHERE name=ub.getName() & UID=ub.getUId()");
	    rs=pstmt.executeQuery();
	    
	    
	    
	   
	    
	    return rs;
	    
	
	}


	public static ResultSet fetchUserDetails() throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		
		
		ResultSet rs;

		Connection con = null;
		con = DbConnect.createConnection();

		/* String query="select * from medicine"; */

		PreparedStatement psmt = con
				.prepareStatement("SELECT * FROM ems_users");
		rs = psmt.executeQuery();
		System.out.println("Search dao connected....");

		/*
		 * while(rs.next()){
		 * 
		 * 
		 * String a = rs.getString("Med_Id"); String b =
		 * rs.getString("Med_Name"); int c = rs.getInt("Med_Price");
		 * 
		 * System.out.println(a+b+c); }
		 */

		System.out.println("query executed in search Dao");
		
		return rs;

	}


	public static void placeOrder(String orderId, String medId, String suppId,
			String suppName, String quant, String odate) throws SQLException, ClassNotFoundException, ParseException {
		
		Connection con = null;
		con = DbConnect.createConnection();

		int quantity = Integer.parseInt(quant);
		/*java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		*/
		
		System.out.println("inside place order in admin dao");
		
		
		
		
		DateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
		
	//	String date = "2000-11-01";
	    java.sql.Date javaSqlDate = java.sql.Date.valueOf(odate);
		
				//Date d = Date.valueOf(sdf.format(odate));
		
		
		//java.sql.Date d1= (java.sql.Date) d.valueOf(d);
		
       
		
		//Date date = Date.valueOf(odate);
		
		

		System.out.println("inserting values to database");
		

		PreparedStatement psmt = con.prepareStatement("insert into ems_orders values(?,?,?,?,?,?)");
		psmt.setString(1,orderId );
		psmt.setString(2, medId);
		psmt.setInt(3, quantity);
		psmt.setString(4, suppId);
		psmt.setString(5, suppName);
		psmt.setDate(6, javaSqlDate);
		
		psmt.executeQuery();
		
		System.out.println("Insertion into table completed");
		
		
	}


	public static void addToInventory(String bid, String sid, String sname,
			String ad, String ed, String quant, String mid) throws SQLException, ClassNotFoundException {
		
		
		Connection con = null;
		con = DbConnect.createConnection();

		int quantity = Integer.parseInt(quant);
		/*java.util.Date utilDate = new java.util.Date();
	    java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
		*/
		
		System.out.println("inside place order in admin dao");
		
		DateFormat sdf=new SimpleDateFormat("yyyy/mm/dd");
		
	    java.sql.Date expd = java.sql.Date.valueOf(ed);
	    java.sql.Date ard = java.sql.Date.valueOf(ad);
	
		System.out.println("inserting values to database");
		

		PreparedStatement psmt = con.prepareStatement("insert into ems_batch values(?,?,?,?,?,?,?)");
		psmt.setString(1,bid );
		psmt.setString(2, sid);
		psmt.setString(3, sname);
		psmt.setDate(4, ard);
		psmt.setDate(5, expd);
		psmt.setInt(6, quantity);
		psmt.setString(7, mid);
		
		psmt.executeQuery();
		
		System.out.println("Insertion into table completed");
		
		
		
		
	}


	public static void removeMed(String batchId) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		con = DbConnect.createConnection();

		
		
		
		
		
		
		
		
		
		
		
		System.out.println("inside removeMed in admin dao");
	
		
	    
	
		System.out.println("Deleting values from batch");
		

		PreparedStatement psmt = con.prepareStatement("delete from ems_batch where batch_id = ?");
		psmt.setString(1,batchId );
		
		
		psmt.executeQuery();
		
		System.out.println("Row Deleted");
		
		
	}


	public static void backUpUsers(UserBean ub) throws SQLException, ClassNotFoundException {
		// TODO Auto-generated method stub
		

		Connection con = null;
		con = DbConnect.createConnection();

		Statement stmt = con.createStatement();
		ResultSet rs;

		System.out.println("inserting deleted values to database");
		System.out.println(ub.getName());
		System.out.println(ub.getRole());
		PreparedStatement psmt = con
				.prepareStatement("insert into ems_deleted_users values(?,?,?,?,?,?,?,?,?)");
		psmt.setString(1, ub.getUId());
		psmt.setString(2, ub.getName());
		psmt.setLong(3, ub.getPhone());
		psmt.setString(4, ub.getDno());
		psmt.setString(5, ub.getStreet());
		psmt.setString(6, ub.getCity());
		psmt.setString(7, ub.getState());
		psmt.setLong(8, ub.getPin());
		psmt.setString(9, ub.getRole());
		psmt.executeQuery();
		System.out.println("Insertion into backup table completed");

		
	}




	
	
		
		
			
		



}