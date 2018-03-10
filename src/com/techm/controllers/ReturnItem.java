package com.techm.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.service.AdminService;

/**
 * Servlet implementation class ReturnItem
 */
public class ReturnItem extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnItem() {
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
		HttpSession session = request.getSession(false);
		ArrayList arr = new ArrayList();
		
         int j = (int) session.getAttribute("countexp");
	
		//int j = Integer.parseInt(q);
		
		for(int i=1; i<j ;i++){
			String ch = (String)request.getParameter("choice"+i);
			arr.add(ch);
			System.out.println("choice"+j);
			System.out.println("choice"+i);
			System.out.println("inside for");
		}
		
		
		
		try {
			AdminService.returmItem(arr);
			String msg = "Items Deleted";
			session.setAttribute("msg", msg);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		Iterator itr = arr.iterator();
		while(itr.hasNext()){
			/*String BatchId = (String)itr.next();*/
			System.out.println(itr.next());
		}
	}

}
