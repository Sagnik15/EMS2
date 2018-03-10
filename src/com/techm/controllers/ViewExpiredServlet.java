package com.techm.controllers;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.bean.MedicineBean;
import com.techm.service.AdminService;

/**
 * Servlet implementation class ViewExpiredServlet
 */
public class ViewExpiredServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ViewExpiredServlet() {
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
			System.out.println("get exp servlet");
			LinkedList<MedicineBean> ll = AdminService.viewExpired();
			System.out.println("list fetched");
			HttpSession session = request.getSession(false);
			
			session.setAttribute("expiredItems", ll);
			
			Iterator itr = ll.iterator();
			while(itr.hasNext()){
				
				System.out.println(itr.next());
			}
			
			
			System.out.println("list saved in session");
			
			
			RequestDispatcher rd = request.getRequestDispatcher("/ReturnItems.jsp");
		       rd.forward(request, response);
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
	}

}
