package com.techm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.bean.MedicineBean;
import com.techm.service.CartService;

/**
 * Servlet implementation class GetBillServlet
 */
public class GetBillServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetBillServlet() {
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
		
		PrintWriter out = response.getWriter();
		CartService cs = (CartService) session.getAttribute("cs");
		int sum = 0;
		ArrayList arr = cs.getIt();
		if(arr.isEmpty()){
			String msg = "Please add something to cart !";
			request.setAttribute("msg", msg);
			RequestDispatcher rd = request.getRequestDispatcher("/billing.jsp");
		       rd.forward(request, response);
			
		}else{
		Iterator itr = arr.iterator();
		while(itr.hasNext()){
			
			MedicineBean mb = (MedicineBean)itr.next();
			int a = mb.getMedPrice();
			int b= mb.getQuantity();
			sum=sum+(a*b);
			/*out.println(itr.next());*/
			session.setAttribute("total", sum);
		}
		
		RequestDispatcher rd = request.getRequestDispatcher("/genbill.jsp");
	       rd.forward(request, response);
	}
	}
}
