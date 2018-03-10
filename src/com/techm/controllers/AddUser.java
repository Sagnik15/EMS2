package com.techm.controllers;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.service.AdminService;

/**
 * Servlet implementation class AddUser
 */
public class AddUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddUser() {
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
		String UId=request.getParameter("UId");
		String name=request.getParameter("name");
		long phone= Long.parseLong(request.getParameter("phone"));
		String dno=request.getParameter("dno");
		String street=request.getParameter("street");
		String city=request.getParameter("city");
		String state=request.getParameter("state");
		long pin=Long.parseLong(request.getParameter("pin"));
		String role = request.getParameter("role");
		
		
		
		
		
		
		
		
		System.out.println(UId);
		System.out.println(name);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	try {
		AdminService.addUserService(UId, name, phone, dno, street, city, state, pin,role);
		
		RequestDispatcher rd = request.getRequestDispatcher("/addUser.jsp");
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
