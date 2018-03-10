package com.techm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.techm.connectDb.DbConnect;

public class SearchDao {

	public static ResultSet searchMed() throws SQLException,
			ClassNotFoundException {
		ResultSet rs;

		Connection con = null;
		con = DbConnect.createConnection();

		/* String query="select * from medicine"; */

		PreparedStatement psmt = con
				.prepareStatement("SELECT * FROM medicine m, ems_batch b WHERE b.med_Id = m.Med_Id ORDER BY b.exp_Date");
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
	
	

	public static ResultSet searchMedbyName() throws SQLException,
			ClassNotFoundException {
		ResultSet rs;

		Connection con = null;
		con = DbConnect.createConnection();

		/* String query="select * from medicine"; */

		PreparedStatement psmt = con
				.prepareStatement("SELECT * FROM medicine m, ems_batch b WHERE b.med_Id = m.Med_Id");
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
	
	
	
	
	public static ResultSet getMed() throws SQLException,
	ClassNotFoundException {
ResultSet rs;

Connection con = null;
con = DbConnect.createConnection();

/* String query="select * from medicine"; */

PreparedStatement psmt = con
		.prepareStatement("SELECT * FROM medicine");
rs = psmt.executeQuery();
System.out.println("Search dao connected....");

System.out.println("getMed query executed in search Dao");
return rs;

}



	public static String addMed(String id, String name, String price) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
		
		Connection con = null;
		con = DbConnect.createConnection();
		
		PreparedStatement psmt = con
				.prepareStatement("insert into medicine values(?,?,?)");
		
		int pr = Integer.parseInt(price);
		
		psmt.setString(1, id);
		psmt.setString(2, name);
		psmt.setInt(3, pr);
		psmt.executeQuery();
		
		String res = "insert Successfull";
		
		return res;
	}
}



	
