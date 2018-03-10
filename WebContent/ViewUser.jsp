<%@page import="com.techm.bean.UserBean"%>
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
<%-- <%   session.getMaxInactiveInterval(60); %> --%>


<style type="text/css">

#search-table {
	width: 96%;
	margin-top: 3%;
	/* border: 1px solid black; */
	margin-left: 2%;
	margin-right: 2%;
	text-align: center;
	background-color: #ffff99;
	box-shadow: 0px 1px 10px 1px black;
	font-family: century gothic;
	font-size: 90%;
}

#search-table td {
	border-bottom: 1px solid black;
}

#search-table th {
border-bottom: 2px solid red;
}

#search{

text-align: center;
margin-top:5%;
}
a{
font-size:110%;
text-decoration: none;
font-family: century gothic;
color:red;
}

.text-box {
	border-radius: 3px;
	border: 1px solid #99c2ff;
	padding-left: 2%;
	padding-top:5px;
	padding-bottom: 5px;
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
	width: 10%;
	margin-bottom: 2%;
	margin-left: 5%;
	margin-right: 5%;
}



.btn:hover {
	transform: scale(1.005);
	color: black;
}

h1{
margin-top:2%;
font-family: verdana;
color:black;
margin-bottom:2%;
}

</style>
<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward() }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() }
    });
</script>

</head>
<body onload="disableBack()">

<h1 align="center">View Users</h1>

<div id="search" align="center">
<form action="searchuserservlet" method="post" name="search-form">
<input type="text" name="search" placeholder="search" class="text-box"> &nbsp;
<input type="submit" value="Search" class="btn"> &nbsp;
<a href="ViewUser.jsp">clear</a>
</form>

</div>

<section>
<div>



<% Object obj2 = request.getAttribute("userList");
Object obj3 = request.getAttribute("userList2");

Object srch = session.getAttribute("search");
LinkedList ll = (LinkedList)obj2;
LinkedList ll2 = (LinkedList)obj3;

if(ll != null && ll2 != null){
if(srch!=""){
	
	Iterator itr = ll2.iterator();

	%>
	<table id="search-table">
	<th> User Id</th> <th>Name</th> <th>Phone No </th> <th>Door No</th><th>Street</th>
<th>City</th>	<th>State</th><th>Pin Code</th>
<%
while(itr.hasNext()){
	
	UserBean mb2 = (UserBean)itr.next();
	%>
	
	<tr>
	<td><% out.println(mb2.getUId()); %></td>
	<td><% out.println(mb2.getName()); %></td>
	<td><% out.println(mb2.getPhone()); %></td>
	<td><% out.println(mb2.getDno()); %></td>
	<td><% out.println(mb2.getStreet()); %></td>
	<td><% out.println(mb2.getCity()); %></td>
	<td><% out.println(mb2.getState()); %></td>
	<td><% out.println(mb2.getPin()); %></td>
	</tr>
	
	<%} %>
	</table>
	
	
<%	
}else{
Iterator itr2 = ll.iterator();
%>
<table id="search-table">
<th>User Id</th><th>Name</th><th>Phone No</th><th>Door No</th><th>Street</th>
<th>City</th>	<th>State</th><th>Pin Code</th>

<%
while(itr2.hasNext()){
	
	UserBean mb3 = (UserBean)itr2.next();
	%>
	
	<tr>
	<td><% out.println(mb3.getUId()); %></td>
	<td><% out.println(mb3.getName()); %></td>
	<td><% out.println(mb3.getPhone()); %></td>
	<td><% out.println(mb3.getDno()); %></td>
	<td><% out.println(mb3.getStreet()); %></td>
	<td><% out.println(mb3.getCity()); %></td>
	<td><% out.println(mb3.getState()); %></td>
	<td><% out.println(mb3.getPin()); %></td>
	</tr>
	
	
<%	
}
}
}
%>
	</table>
</div>

</section>

</body>
</html>