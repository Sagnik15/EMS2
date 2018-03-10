<%@page import="com.techm.service.CartService"%>
<%@page import="com.techm.bean.MedicineBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<%@page import="java.util.*;"%>
<%-- <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> --%>

<!DOCTYPE html>
<html>
<head>

<script>
	$(document).ready(function() {
		function disableBack() {
			window.history.forward()
		}

		window.onload = disableBack();
		window.onpageshow = function(evt) {
			if (evt.persisted)
				disableBack()
		}
	});
</script>
<style type="text/css">
body {
	/* background-color: rgba(245, 240, 240, 0.92); */
	margin: 0;
}

#left-section {
	position: relative;
	/* box-shadow: 1px 1px 5px 1px rgba(0, 0, 0, .5); */
	padding-top: 3%;
	padding-left: 2%;
	background: transparent;
	padding-bottom: 2%;
	height: 200px;
	float: left;
	width: 47%;
	margin-top: 6%;
}

#right-cart {
	position: relative;
	/* box-shadow: 1px 1px 5px 1px rgba(0, 0, 0, .5); */
	padding: 10px;
	background: transparent;
	padding-bottom: 2%;
	height: 280px;
	float: right;
	width: 47%;
	margin-top: 2%;
	overflow-y: scroll;
}

#mid-section {
	margin-top: 12%;
	float: right;
	width: 43%;
	position: relative;
	/*  box-shadow: 1px 1px 5px 1px rgba(0, 0, 0, .5); */
	padding: 10px;
	background: transparent;
	text-align: right;
	padding-right: 5%;
}

#inner {
	overflow-y: scroll;
	width: 100%;
	height: 200px;
}

#search-table {
	width: 96%;
	margin-top: 0;
	/* border: 1px solid black; */
	margin-left: 2%;
	margin-right: 2%;
	text-align: center;
	background-color: #ffff99;
	font-family: century gothic;
	font-size: 90%;
}

#search-table td {
	border-bottom: 1px solid black;
}

#search-table th {
	border-bottom: 2px solid red;
}

#i1 {
	width: 50%;
	float: left;
}

#i2 {
	width: 100%;
	float: right;
}

#buttons {

	float: right;
	text-align: right;
	clear:both;
	width: 55%;
	margin-top: 2%;
	
}

#amount {
	margin-top: 5%;
	width: 100%;
	color: red;
	text-align: center;
	font-family: century gothic;
	font-size: 120%;
	clear: both;
}

#alert {
	color: red;
	font-size: 110%;
	font-family: verdana;
}

.text-box {
	border-radius: 3px;
	border: 1px solid #99c2ff;
	padding-top: 1%;
	padding-bottom: 1%;
	padding-left: 2%;
	border-radius: 3px;
	background-color: rgba(243, 240, 240, 0.95);
	font-family: 'Lucida Sans';
	font-size: 90%;
}

.text-box:focus {
	border: 1px solid #ff6600;
	background-color: white;
	font-size: 90%;
}

.text-box:hover {
	border: 1px solid black;
}

.btn {
	background-color: #99c2ff;
	border: none;
	color: white;
	padding: 5px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 3px;
	width: 20%;
	margin-bottom: 2%;
	margin-left: 5%;
	margin-right: 5%;
}

.btn2 {
	background-color: #99c2ff;
	border: none;
	color: white;
	padding: 5px 15px;
	text-align: center;
	text-decoration: none;
	display: inline-block;
	font-size: 16px;
	border-radius: 3px;
	width: 50%;
	margin-bottom: 2%;
	margin-left: 5%;
	margin-right: 5%;
}

.btn:hover {
	transform: scale(1.005);
	color: black;
}

.btn2:hover {
	transform: scale(1.005);
	color: black;
}

h1 {
	margin-top: 2%;
	font-family: verdana;
	color: black;
	margin-bottom: 2%;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sId = (String) session.getAttribute("sessionId");

	if (sId != request.getSession(false).getId()) {
		//session.invalidate();
		response.sendRedirect("relog.jsp");
		/* 	RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
		 rd.forward(request, response); */

	}
%>


</head>
<body>





	<!-- <section>
		<div id="mid-section">

			

		</div>
	</section>
 -->


	<h1 align="center">BILLING CART</h1>





	<section>
		<div id="left-section">
			<span id="alert"> <%
 	Object obj5 = request.getAttribute("msg");
 	String msg = (String) obj5;
 	if (obj5 != null) {
 		out.println(msg);
 	}
 %> <%
 	Object obj6 = request.getAttribute("msg2");
 	String msg2 = (String) obj6;
 	if (obj6 != null) {
 		out.println(msg2);
 	}
 %>



			</span>
			<form id="form-style" action="billingservlet" method="post">
				<!-- <input type="text" name="item_id" placeholder="ItemID" required>&nbsp;OR&nbsp; -->
				<input type="text" name="item_name" placeholder="ItemName" required
					class="text-box"> <input type="submit" value="FETCH"
					class="btn">


			</form>
			<br>
			<form action="cartservlet" method="post">
				<input type="number" name="item_quantity" placeholder="quantity"
					required autocomplete="off" class="text-box"> <input
					type="submit" Value="Add" class="btn"><br>
				<div id="inner">
					<%
						Object obj = request.getAttribute("availableMed");
						ArrayList arr = (ArrayList) obj;
						if (arr != null) {
							Iterator itr = arr.iterator();
							while (itr.hasNext()) {

								MedicineBean mb = (MedicineBean) itr.next();
					%>
					<input type="radio" name="selection"
						value="<%out.println(mb.getBatchId());%>" required="required">Name:&nbsp;
					<%
						out.println(mb.getMedName());
					%>&nbsp;&nbsp;&nbsp;&nbsp;Expiry:&nbsp;<%
						out.println(mb.getExpiryDate());
					%>&nbsp;&nbsp;&nbsp;&nbsp;Stock Left:&nbsp;<%
						out.println(mb.getQuantity());
					%>
					<br>



					<%
						}

						}
					%>
					<%!CartService cs = new CartService();%>
					<%
						session.setAttribute("cs", cs);
					%>

				</div>



			</form>
		</div>
	</section>



	<div id="right-cart">

		<form name="final_calculation" method="post">
			<table id="search-table">
				<th>Batch Id</th>
				<th>Name</th>
				<th>Quantity</th>
				<th>Price/Pc.</th>

				<%
					int i = 1;
					Object obj3 = session.getAttribute("cart_array");
					if (obj3 != null) {

						CartService cs2 = (CartService) obj3;
						ArrayList disp = cs2.getIt();
						Iterator itr = disp.iterator();
				%>

				<%
					while (itr.hasNext()) {

							MedicineBean mb2 = (MedicineBean) itr.next();
				%>

				<tr>
					<%-- --%>
					<td>
						<%
							out.println(mb2.getBatchId());
						%>
					</td>
					<td>
						<%-- <input type="hidden" name="mid"  value="<% out.println(mb2.getMedName()); %>" > --%>
						<%
							out.println(mb2.getMedName());
						%>
					</td>
					<td>
						<%-- <input type="hidden" name="quant"  value="<%out.println(mb2.getQuantity()); %>" > --%>
						<%
							out.println(mb2.getQuantity());
						%>
					</td>
					<td>
						<%-- <input type="hidden" name="price"  value="<% out.println(mb2.getMedPrice()); %>" > --%>
						<%
							out.println(mb2.getMedPrice());
						%>
					</td>

				</tr>


				<%
					}
				%>

			</table>

			<%
				}
			%>

		</form>
	</div>


	<div id="buttons">

		<div >
			<form action="getbillservlet" method="post">
				<input type="Submit" value="GET TOTAL" class="btn2">
			</form>
		</div>







	</div>













</body>
</html>


<%-- <%  

Object obj2 = session.getAttribute("cart_array");
if(obj2!=null){
ArrayList arr3 = (ArrayList)obj2;
//if(arr3 != null){
Iterator itr = arr3.iterator();
while(itr.hasNext()){
	
	MedicineBean mb2 = (MedicineBean)itr.next();

	%>
	
	<table>
	<tr><td><%out.println(mb2.getBatchId()); %></td><td><%out.println(mb2.getMedName()); %></td><td><%out.println(mb2.getQuantity()); %></td><td><%out.println(mb2.getMedPrice()); %></td></tr>
	
	</table>
	
	

<%
}
//}
}
%> --%>