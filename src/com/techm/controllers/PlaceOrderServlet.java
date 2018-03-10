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
 * Servlet implementation class PlaceOrderServlet
 */
public class PlaceOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public PlaceOrderServlet() {
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
		
		String orderId = request.getParameter("order_id");
		String medId = request.getParameter("med_id");
		String suppId = request.getParameter("supid");
		String suppName = request.getParameter("supname");
		String quant = request.getParameter("quant");
		String odate = request.getParameter("odate");
		
		
		
		try {
			 

				
					boolean res = AdminService.placeOrder(orderId, medId, suppId, suppName, quant, odate);
					System.out.println(res);
					if(res==false){
					String msg = "MEDICINE ID DOES NOT MATCH ! First make an entry for this type of Med";
					request.setAttribute("msg2", msg);
					
				      
					
					}else if(res==true){
						String msg = "INSERT SUCCESSFULL";
						request.setAttribute("msg2", msg);
						
					}
						
					
					RequestDispatcher rd = request.getRequestDispatcher("/PlaceOrder.jsp");
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
