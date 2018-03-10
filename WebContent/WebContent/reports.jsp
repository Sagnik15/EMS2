<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="com.techm.bean.MedicineBean"%>
    <%@page import="java.util.*;"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
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
	margin-bottom: 1%;
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
	margin-bottom: 1%;
	margin-left: 5%;
	margin-right: 5%;
}



.btn:hover {
	transform: scale(1.005);
	color: black;
}


h1{
margin-top:5%;
font-family: verdana;
color:black;
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
<style type="text/css">
#box{
text-align: center;
margin-top: 12%;
}
</style>
</head>
<body>
<h1 align="center">VIEW REPORTS</h1>
<div id="box">
<form action="reportservlet" method="post">
<table align="center">
<tr><td>enter supplier id:</td><td><input type="text" name="supid" placeholder="SUPPLIER ID" required class="text-box"></td></tr>
<tr><td>Enter Date:</td><td><input type="date" name="date" placeholder="DATE" required class="text-box"></td></tr>
</table>
<input type="submit" value="Get Reports" class="btn"><br>
<a href="reports.jsp">clear</a>
</form>
</div>
</body>
</html>