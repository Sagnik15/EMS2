package com.techm.controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.techm.service.ForgotPassword;

/**
 * Servlet implementation class ForgotPass
 */
public class ForgotPass extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPass() {
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

		
		String uid = request.getParameter("id");
		String name = request.getParameter("name");
		String contact = request.getParameter("phone");
		Long phone = Long.parseLong(contact);
		
		try {
		String res = (String)	ForgotPassword.checkCredential(uid, name, phone);
		
		request.setAttribute("message", res);
		
		RequestDispatcher rd = request.getRequestDispatcher("/ForgotPassword.jsp");
	       rd.forward(request, response);
		
		
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
