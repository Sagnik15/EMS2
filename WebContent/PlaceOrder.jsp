<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
	String sId = (String) session.getAttribute("sessionId");

	if (sId != request.getSession(false).getId()) {

		response.sendRedirect("relog.jsp");

	}
%>
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
<body>

<div align="center">
<h1 align="center">PLACE ORDER</h1>
<form action="placeorderservlet" method="post">
<table>
<tr><td>Order ID</td><td><input type="text" name="order_id"  required class="text-box"></td></tr>
<tr><td>Med ID</td><td><input type="text" name="med_id" required class="text-box"></td></tr>
<tr><td>Quantity</td><td><input type="text" name="quant" required class="text-box"></td></tr>
<tr><td>Supplier ID</td><td><input type="text" name="supid" required class="text-box"></td></tr>
<tr><td>Supplier Name</td><td><input type="text" name="supname" required class="text-box"></td></tr>
<tr><td>Order Date</td><td><input type="date" name="odate" required class="text-box"></td></tr>
</table>
<input type="submit" value="PLACE ORDER" class="btn">

</form>
<span><% 
Object obj = request.getAttribute("msg2");
String msg = (String)obj;
if(obj!=null){
out.println(msg);
}
%></span>
</div>

</body>
</html>