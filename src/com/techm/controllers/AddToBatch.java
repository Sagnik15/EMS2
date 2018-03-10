package com.techm.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.service.AdminService;

/**
 * Servlet implementation class AddToBatch
 */
public class AddToBatch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddToBatch() {
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

		String bid = request.getParameter("bid");
		String sid = request.getParameter("sid");
		String sname = request.getParameter("sname");
		String ad = request.getParameter("ad");
		String ed = request.getParameter("ed");
		String quant = request.getParameter("quant");
		String mid = request.getParameter("mid");
		
		
		
		
		

		try {
			boolean res = AdminService.addToInventory(bid, sid, sname, ad, ed, quant, mid);
			if(res==false){
			String msg = "MEDICINE ID DOES NOT MATCH !   Please enter a valid ID";
			request.setAttribute("msg", msg);
			
			}else{
				String msg = "INSERT SUCCESSFULL";
				request.setAttribute("msg", msg);
				
				
			}
			
			RequestDispatcher rd = request.getRequestDispatcher("/AddToInventory.jsp");
		       rd.forward(request, response);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
