<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.techm.service.CartService"%>
<%@page import="com.techm.bean.MedicineBean"%>
<%@ page import="java.util.*;" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
</script>
<script type="text/javascript">
function printbill(){
	
	window.print();
	
}

</script>
<style type="text/css">
#search-table {
	width: 96%;
	margin-top: 3%;
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



.btn:hover {
	transform: scale(1.005);
	color: black;
}
#amount{
text-align:right;
margin-right: 5%;
margin-top: 5%;
font-family: verdana;
font-size: 150%;
color:red;
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



.btn:hover {
	transform: scale(1.005);
	color: black;
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
<div>
		<table id="search-table">
<th>Batch Id</th><th>Medicine Name</th><th>Quantity</th><th>Price/pc</th>
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


</div>
<div id="amount">

		<%
			Object obj4 = session.getAttribute("total");
			Integer tot = (Integer) obj4;

			if (tot != null) {
		%>


		The amount payable is:
		<%
			out.println(tot);
		%>

		<%
			}
		%>
	</div>
	<form>
			<div id="i2">
				<input type="Submit" value="Print" onclick="printbill()" class="btn">
				
			</div>
		</form>
		<div><form action="clearcartservlet" method="post"><input type="submit" value="Commit/new purchase" class="btn"></form></div>
</body>
</html>