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
import com.techm.bean.UserBean;
import com.techm.service.FindUserService;
import com.techm.service.SearchService;

/**
 * Servlet implementation class SearchUserServlet
 */
public class SearchUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchUserServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String srch = request.getParameter("search");
		// String formId=request.getParameter("search-form");
		System.out.println(srch);

		HttpSession session = request.getSession(false);
		session.setAttribute("search", srch);

		try {
			LinkedList ar = FindUserService.fetchUserDetails();
			System.out.println("array list fetched");
			Iterator itr = ar.iterator();

			LinkedList<UserBean> listFilter = new LinkedList<UserBean>();
			
			/* System.out.println(itr.hasNext()); */

			while (itr.hasNext()) {

				UserBean mb1 = (UserBean) itr.next();

				/* if(mb1.getName().equals(srch) || mb1.getUId().equals(srch)){ */
				listFilter.add(mb1);
				System.out.println("inside insert all");
				request.setAttribute("values", mb1);

				// System.out.println(mb1.getMedId() + "------- "
				// +mb1.getMedName()+" --------"+mb1.getMedPrice());
				/* } */

			}

			Iterator itr2 = ar.iterator();

			LinkedList<UserBean> listFilter2 = new LinkedList<UserBean>();

			System.out.println(itr2.hasNext());

			while (itr2.hasNext()) {

				UserBean mb2 = (UserBean) itr2.next();

				if (mb2.getName().equalsIgnoreCase(srch)
						|| mb2.getUId().equalsIgnoreCase(srch)) {

					System.out.println("inside selective insert");
					listFilter2.add(mb2);

					// System.out.println(mb1.getMedId() + "------- "
					// +mb1.getMedName()+" --------"+mb1.getMedPrice());
				}

			}

			request.setAttribute("userList", listFilter);

			request.setAttribute("userList2", listFilter2);
			RequestDispatcher rd = request
					.getRequestDispatcher("/ViewUser.jsp");
			rd.forward(request, response);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
