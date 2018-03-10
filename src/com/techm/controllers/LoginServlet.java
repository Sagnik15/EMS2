package com.techm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.connectDb.DbConnect;
import com.techm.dao.LoginDao;
import com.techm.service.LoginService;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
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
		
		
		try {
		PrintWriter out  = response.getWriter();
		
		out.println("In Login Servlet");
		
		HttpSession session = request.getSession(false);
		
		String sessionId = session.getId();
		
		
	
		
		
		
		session.setAttribute("sessionId", sessionId);
		
		
		String uid = (String) session.getAttribute("uid");
		out.println(uid);
		String pwd = (String) session.getAttribute("pwd");
		out.println(pwd);
		String role = (String) session.getAttribute("role");
		out.println(role);
		
/*Connection con = null;
		
		 con = DbConnect.createConnection();*/
			
		
		boolean b = LoginService.validateLogin(uid,pwd,role);
		out.println(b);

		if(request.getSession(true) != null){
		
		if(LoginService.validateLogin(uid,pwd,role)){
			
			if(role.equalsIgnoreCase("admin")){
			
			response.sendRedirect("admin.jsp");
			}
			else if(role.equals("user")){
				response.sendRedirect("user.jsp");
				
			}
		}else{
			
			response.sendRedirect("Invalid.html");
		}
		
		}
	
		else{
			
			response.sendRedirect("login.html");
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
}
