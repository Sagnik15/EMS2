<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html >
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

#box{
margin-top: 10%;
}
#display{
text-align: center;
margin-top: 5%;
font-size: 200%;
font-family: verdana;
color:red;

}
</style>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="forgotpass" method="post" align="center"> 

<table align="center" id="box">
<tr><td>Enter user ID</td><td><input type="text" name="id" required></td></tr>
<tr><td>Enter Name</td><td><input type="text" name="name" required></td></tr>
<tr><td>Contact number</td><td><input type="text" name="phone" required></td></tr>
</table>
<div align="center"><input type="submit" name="getPassword" id="btn"><br>
<a href="login.html">Login Again</a></div>
</form>

<div id="display">

<span id="alert"> <%
 	Object obj = request.getAttribute("message");
 	String msg = (String) obj;
 	if (obj != null) {
 		out.println(msg);
 	}
 	%>
 	</span>

</div>
</body>
</html>