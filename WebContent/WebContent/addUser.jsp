<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
<%
	String sId = (String) session.getAttribute("sessionId");

	if (sId != request.getSession(false).getId()) {
		
		response.sendRedirect("relog.jsp");
		
	}
%>
</head>
<body>
<div>
<h1 align="center">ADD USER</h1>
</div>
<form action="adduser" method="post" id="adduser-form"> 
<div align="center">
<table align="center">
<tr><td>UID:</td><td><input type="text" name ="UId" class="text-box" required></td></tr>
<tr><td>Name:</td><td> <input type="text" name="name" class="text-box"required></td></tr>
<tr><td>Phone Number:</td><td> <input type="text" name="phone" class="text-box" required></td></tr>
<tr><td>D:No:</td><td> <input type="text" name="dno" class="text-box" required></td></tr>
<tr><td>Street:</td><td> <input type="text" name="street" class="text-box" required></td></tr>
<tr><td>City:</td><td> <input type="text" name="city" class="text-box" required></td></tr>
<tr><td>State:</td><td> <input type="text" name="state" class="text-box" required></td></tr>
<tr><td>Pin No:</td><td> <input type="text" name="pin" class="text-box" required></td></tr>
<tr><td>ROLE:</td><td> <select name="role" class="text-box" required>
<option value="user" >USER</option>
</select></td></tr>
</table>
<br><br>

<input type="submit" value="Add" class="btn">
<input type="reset" value="reset" class="btn">
</div>
</form>
</body>
</html>