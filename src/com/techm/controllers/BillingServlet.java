package com.techm.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.bean.MedicineBean;

import com.techm.connectDb.DbConnect;
import com.techm.service.BillingService;

/**
 * Servlet implementation class BillingServlet
 */
public class BillingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BillingServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
      /* String item_id = request.getParameter("item_id");*/
		
		
		
		  HttpSession session = request.getSession(false);
		 
       String item_name = request.getParameter("item_name");
       
       System.out.println(item_name);
      
       
       
      /* try {
   		MedicineBean mb =  BillingService.getEarliestExpiry(item_name);
   	} catch (ClassNotFoundException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	} catch (SQLException e) {
   		// TODO Auto-generated catch block
   		e.printStackTrace();
   	}
       */
       
       
      try {
    	
    	  System.out.println("Initiating addToCart");
		ArrayList al =  BillingService.addToCart(item_name);
		
		
		
			Iterator itr = al.iterator();
			
			System.out.println("inside if ");
		while(itr.hasNext()){
			
			MedicineBean mb = (MedicineBean)itr.next();
			
			System.out.println(mb.getMedId() + " "+mb.getExpiryDate());
			
		}
		
		if(al.isEmpty()){
			System.out.println("in else");
			String msg="Invalid Name";
			request.setAttribute("msg2", msg);
			}
				
		request.setAttribute("availableMed", al);
		
		session.setAttribute("al", al);
			
		
		
		
		
		RequestDispatcher rd = request.getRequestDispatcher("/billing.jsp");
	       rd.forward(request, response);
	
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
		
	}
      

}
