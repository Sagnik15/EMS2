package com.techm.controllers;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.techm.bean.MedicineBean;
import com.techm.service.SearchService;
import com.techm.connectDb.DbConnect;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/searchservlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
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
	
		String srch = request.getParameter("search");
		//String formId=request.getParameter("search-form");
		System.out.println(srch);
		
		HttpSession session = request.getSession();
		session.setAttribute("search", srch);
		
		try {
			LinkedList ar = SearchService.fetchMed();
			System.out.println("array list fetched");
			Iterator itr = ar.iterator();
			
			LinkedList<MedicineBean> arFilter = new LinkedList<MedicineBean>();
			
			/*System.out.println(itr.hasNext());*/
			
			while(itr.hasNext()){
				
				MedicineBean mb1 = (MedicineBean)itr.next();
				
				
				System.out.println(mb1.getMedId() + "@@@@@" +mb1.getMedName()+"@@@@@"+mb1.getMedPrice());
				
				
				if(mb1.getMedId().equalsIgnoreCase(srch) || mb1.getMedName().equalsIgnoreCase(srch)){
					arFilter.add(mb1);
					
				 request.setAttribute("values", mb1);
				
				
				// System.out.println(mb1.getMedId() + "------- " +mb1.getMedName()+" --------"+mb1.getMedPrice());
				}
			
			}
			
			if(arFilter.isEmpty()){
				String msg = "Sorry, nothing found !  Try Again !";
				request.setAttribute("msg",msg);
				RequestDispatcher rd = request.getRequestDispatcher("/userSearch.jsp");
			       rd.forward(request, response);
				
			}else{
			
			 request.setAttribute("valList", arFilter);
			RequestDispatcher rd = request.getRequestDispatcher("/userSearch.jsp");
		       rd.forward(request, response);
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
