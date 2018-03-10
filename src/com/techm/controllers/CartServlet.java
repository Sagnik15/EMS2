package com.techm.controllers;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.bean.MedicineBean;
import com.techm.dao.BillingDao;
import com.techm.service.BillingService;
import com.techm.service.CartService;

/**
 * Servlet implementation class CartServlet
 */
@WebServlet("/cartservlet")
public class CartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CartServlet() {
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
		String BatchId = request.getParameter("selection");
	if(BatchId!=null){	
			
		String batchId = BatchId.trim();
		String quantity  = request.getParameter("item_quantity");
		int quant = Integer.parseInt(quantity);
		
		if (quant<=0){

			String msg = "Enter a valid Quantity";
			request.setAttribute("msg", msg);
			
			RequestDispatcher rd = request.getRequestDispatcher("/billing.jsp");
		       rd.forward(request, response);
			
			
		}else{
		PrintWriter out = response.getWriter();
		/*out.println(MedId);
		out.println(quantity);*/
		HttpSession session = request.getSession(false);
		//ArrayList<MedicineBean> arr2 = new ArrayList<MedicineBean>();
		
		ArrayList arr = (ArrayList) session.getAttribute("al");
		
		
		//CartService cs = new CartService();
		
	
	CartService cs = 	(CartService)session.getAttribute("cs");
		System.out.println("arraylist fetched");
		Iterator itr = arr.iterator();
		while(itr.hasNext()){
			
			MedicineBean mb2 = (MedicineBean)itr.next();
			System.out.println(mb2.getBatchId()+" "+mb2.getMedName()+" "+mb2.getQuantity());
			System.out.println(BatchId);
			
			//System.out.println(MedId.compareTo(mb2.getMedId()));
			
		//	System.out.println(MedId.equalsIgnoreCase(mb2.getBatchId()));
			
			
			String bid = mb2.getBatchId().trim();
			System.out.println(bid.equals(batchId));
			
			if(bid.equals(batchId)){
				
				if(mb2.getQuantity()>= quant)
				
				{
				System.out.println("before setting quant");
				mb2.setQuantity(quant);
				System.out.println(mb2.getMedName()+ " " +mb2.getExpiryDate() + " " +mb2.getQuantity());
				cs.insert(mb2);
				}else{
					
					String msg = "insufficient stock";
					request.setAttribute("msg", msg);
					
				       break;
				}
				//arr2.add(mb2);
			//System.out.println(mb2.getQuantity());
			}
			
		}
		
		session.setAttribute("cart_array", cs);
		//request.setAttribute("cart_array", arr2);
		
		
		System.out.println("name val pair settin done");
		
		RequestDispatcher rd = request.getRequestDispatcher("/billing.jsp");
	       rd.forward(request, response);
	       
		}    
	}
	
	else{
		String msg = "Select an option please !";
		request.setAttribute("msg", msg);
		
		RequestDispatcher rd = request.getRequestDispatcher("/billing.jsp");
	       rd.forward(request, response);
	}
	}

	public static void updateQuantity(CartService cs2) throws SQLException, ClassNotFoundException {
		
		BillingDao.updateQuant(cs2);
		
				
	}

}
