package com.techm.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;

import com.techm.bean.MedicineBean;
import com.techm.connectDb.DbConnect;
import com.techm.service.CartService;

public class BillingDao {

	public static void updateQuant(CartService cs2) throws SQLException, ClassNotFoundException {
		Connection con=null;
		con = DbConnect.createConnection();
		
		ArrayList arr = cs2.getIt();
		PreparedStatement psmt = con.prepareStatement("update ems_batch set quantity = quantity - ? where batch_Id = ?");
		Iterator itr = arr.iterator();
		while(itr.hasNext()){
			MedicineBean mb = (MedicineBean)itr.next();
			int quant = mb.getQuantity();
			String bid = mb.getBatchId();
			psmt.setInt(1, quant);
			psmt.setString(2, bid);
			psmt.executeUpdate();
			System.out.println("quantity updated");
			
			
		}
		
		System.out.println("update successfull");
		

		
	}

	
}
