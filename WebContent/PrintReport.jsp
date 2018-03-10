<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@page import="com.techm.bean.MedicineBean"%>
    <%@page import="java.util.*;"%>
<!DOCTYPE html>
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
function getPrint(){
	
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
span{
text-align: center;
color:red;
font-size: 200%;
font-family: century gothic;

}
div{

text-align: center;
}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div><input type="button" value="print" onclick="getPrint()"><a href="reports.jsp">BACK</a></div>
<div>
<% 
Object obj1 = request.getAttribute("medListExp");

/* Object medExpList = request.getAttribute("expiredItems"); */
ArrayList al = (ArrayList)obj1;

if(al != null){
	
	Iterator itr = al.iterator();

	%>
	<table id="search-table">
	<th> Batch Id</th> <th>Med ID</th> <th>Med Name </th> <th>Quantity</th><th>Expiry Date</th>
	<th>Supplier Id</th><th>Supplier Name</th>
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
	<td><% out.println(mb.getSupplierId()); %></td>
	<td><% out.println(mb.getSupplierName()); %></td>
	</tr>
	
	<%}%>

<%}else{ %>
<span>
<%Object obj8 = request.getAttribute("message2");
String msg4 = (String)obj8;
if(obj8 != null){
out.println(msg4);
}
%>
</span>

<%} %>
</div>
</body>
</html>