<%@page import="com.techm.bean.MedicineBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"  errorPage="Error.jsp"%>
   <%@page import="java.util.*;" %>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
   
<!DOCTYPE html>
<html>
<head>
<script>
    $(document).ready(function() {
        function disableBack() { window.history.forward(); }

        window.onload = disableBack();
        window.onpageshow = function(evt) { if (evt.persisted) disableBack() ;}
    });
</script>
<style type="text/css">
body{
              
                margin: 0;
            }
            
           #search{
           
           margin-top:6%;
           margin-left:2%;
           
           }
           
           #search form input {
           
           border-radius: 3px;
	border: 2px solid #99c2ff;
	padding-left:5px;
	padding-top: 3px;
	padding-bottom: 3px;
           }
           
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
a{
font-size:110%;
text-decoration: none;
font-family: century gothic;
color:red;
display: inline-block;;
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
	margin-left: 1%;
	margin-right: 1%;
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
#disp{
font-size: 150%;
font-family: verdana;

}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
String sId = (String)session.getAttribute("sessionId");

if(sId != request.getSession(false).getId()){
	session.invalidate();
	response.sendRedirect("relog.jsp");
	/* RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
    rd.forward(request, response); */
	
}
%>
</head>
<body onload="disableBack()">
<h1 align="center">SEARCH INVENTORY</h1>
<div id="search" align="center">
<form action="searchservlet" method="post" name="search-form">
<input type="text" name="search" placeholder="search" required class="text-box"> &nbsp; &nbsp;
<input type="submit" value="Search" class="btn">&nbsp; &nbsp;
<a href="userSearch.jsp">clear</a>
</form>

</div>

<section>
<div align="center" id="disp">



<% Object obj2 = request.getAttribute("valList");
LinkedList ll = (LinkedList)obj2;

if(ll != null){

Iterator itr = ll.iterator();
%>
<table id="search-table">
<th>Med Id</th><th>Med Name</th><th>ExpiryDate</th><th>Supplier Name</th><th>Quantity</th><th>Price/pc</th>
<%
while(itr.hasNext()){
	
	MedicineBean mb2 = (MedicineBean)itr.next();
	%>
	
	<tr>
	<td><% out.println(mb2.getMedId()); %></td>
	<td><% out.println(mb2.getMedName()); %></td>
	<td><% out.println(mb2.getExpiryDate()); %></td>
	<td><% out.println(mb2.getSupplierName()); %></td>
	<td><% out.println(mb2.getQuantity()); %></td>
	<td><% out.println(mb2.getMedPrice()); %></td>
	
	</tr>
	
	
<%	
}

}
else{

%>
	</table>
	
	<%
	
		Object ob = request.getAttribute("msg");
		String msg= (String)ob;
		if(ob!=null){
			
			out.println(msg);
			
		}
		
		
		
		
	}
	
	%>
</div>

</section>

</body>
</html>







<%-- <%

Object obj = request.getAttribute("values");
MedicineBean mb;
mb = (MedicineBean)obj;

%>

<table id="search-table">
<%if(mb!=null){ %>
<tr><td>Med Id</td><td>Med Name</td><td>Price</td><td>Quantity</td><td>Expiry Date</td></tr>

<tr>
<td><% out.println(mb.getMedId());%></td>
<td><% out.println(mb.getMedName());%></td>
<td><% out.println(mb.getMedPrice());%></td>
<td><% out.println(mb.getQuantity());%></td>
<td><% out.println(mb.getExpiryDate());%></td>
</tr>

	<%}%></table> --%>
	