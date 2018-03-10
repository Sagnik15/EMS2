<%@page import="com.techm.bean.MedicineBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

</style>
<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sId = (String) session.getAttribute("sessionId");

	if (sId != request.getSession(false).getId()) {
		
		response.sendRedirect("relog.jsp");
		
	}
%>
</head>
<body>
<div><form action = "viewexpiredservlet" method="post" >
<input type="submit" value="view expired products" class="btn">

</form></div>



<div><form action = "returnitem" method="post">


<input type="submit" value="Return Items" class="btn">
<%Object obj = session.getAttribute("msg");
String msg = (String)obj;
if(obj != null){
out.println(msg);
}
%>
<%!  int i = 1; %>
<% Object obj1 = request.getAttribute("userList");

Object expIt = session.getAttribute("expiredItems");
LinkedList ll = (LinkedList)expIt;

if(ll != null){
	
	Iterator itr = ll.iterator();

	%>
	<table id="search-table">
	<th> Batch Id</th> <th>Med ID</th> <th>Med Name </th> <th>Quantity</th><th>Expiry Date</th>
<th>select</th>	
<%
while(itr.hasNext()){
	
	MedicineBean mb = (MedicineBean)itr.next();
	%>
	
	<tr>
	<td><% out.println(mb.getBatchId()); %></td>
	<td><% out.println(mb.getMedId()); %></td>
	<td><% out.println(mb.getMedName()); %></td>
	<td><% out.println(mb.getQuantity()); %></td>
	<td><% out.println(mb.getExpiryDate()); %></td>
	<td><input type="checkbox" name="choice<%=i %>" value="<%= mb.getBatchId()%>"></td>
	</tr>
	
	<%
i++;	
	
}
session.setAttribute("countexp",i);
} %>
	</table>
	<%-- <%-- <input type="hidden" value="<% i; %>" name="count"> --%>
	</form>
	</div>




</body>
</html>