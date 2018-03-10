<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
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
margin-top:4%;
font-family: verdana;
color:black;
margin-bottom:5%;
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
<h1 align="center">Delete User</h1>
</head>
<body>


<form action="deleteuserservlet" method="post" id="DeleteUser">

<div align="center">
<table>
<tr><td>User Id</td><td><input type="text" name="uid" class="text-box" required></td></tr>
<tr><td>Name</td><td> <input type="text" name="name" class="text-box" required></td></tr>
</table><br><br>
<input type="submit" name="DeleteUser" class="btn">
<input type="reset" name="Reset" class="btn">

</div>


</form>
</body>
</html>