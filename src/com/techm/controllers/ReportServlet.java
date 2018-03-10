package com.techm.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.service.AdminService;

/**
 * Servlet implementation class ReportServlet
 */
public class ReportServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportServlet() {
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
		
	String sid = 	request.getParameter("supid");
	String dt = 	request.getParameter("date");
		
		try {
			
			System.out.println("starting search for expired medicine !");
		ArrayList arr = AdminService.getExpiry(sid,dt);
		System.out.println("search complete !");
		System.out.println(arr);
		if(arr.isEmpty()){
			System.out.println("empty arraylist");
			String message = "No Expired Products for this supplier on this date";
			request.setAttribute("message2", message);
		}else{
			System.out.println("items found");
			request.setAttribute("medListExp", arr);
			
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/PrintReport.jsp");
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
