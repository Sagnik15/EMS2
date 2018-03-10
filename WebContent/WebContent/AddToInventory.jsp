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
<style>
#batch {
	float: left;
	position: relative;
	width: 45;
	text-align: right;
	margin-top: 10%;
	margin-left: 16%;
}

#med {
	text-align: left;
	float: right;
	position: relative;
	width: 38%;
	margin-top: 10%;
	margin-left: 3%;
}
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
	margin-right: 3%;
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
	<div id="batch">
	<h1>ADD TO BATCH</h1>
		<form action="addtobatch" method="post" id="frm">
		<table>
			<tr><td>Batch ID:</td><td><input type="text" name="bid" required class="text-box"></td></tr> 
			<tr><td>Supplier ID:</td><td><input type="text" name="sid" required class="text-box"></td></tr>
			<tr><td>Supplier Name:</td><td> <input type="text" name="sname" required class="text-box"></td></tr> 
			<tr><td>Arrival Date:</td><td> <input type="date" name="ad" required class="text-box"></td></tr> 
			<tr><td>Expiry Date:</td><td><input type="date" name="ed" required class="text-box"></td></tr> 
			<tr><td>Quantity:</td><td> <input type="text" name="quant" required class="text-box"></td></tr> 
			<tr><td>Medicine ID:</td><td> <input type="text" name="mid" required class="text-box"></td> 
			</table>
			<input type="submit" name="submit" value="ADD" class="btn"> 
				<input type="reset" name="reset" value="clear" class="btn">
		</form>
		<span><% 
Object obj = request.getAttribute("msg");
String msg = (String)obj;
if(obj!=null){
out.println(msg); 
}%></span>
</div>
	</div>

	<div id="med">
	<h1>ADD TO MEDICINE</h1>
		<form action="addtomedicine" method="post">
<table>
			<tr><td>Medicine ID:</td><td><input type="text" name="mid" class="text-box"></td></tr>
			<tr><td>Medicine Name:</td><td> <input type="text" name="mname" class="text-box"></td></tr>
			 <tr><td>Medicine Price:</td><td> <input type="text" name="mprice" class="text-box"></td></tr>
			 </table>
			 <input type="submit" name="submit" value="ADD" class="btn"> 
			 <input type="reset" name="reset" value="clear" class="btn">

		</form>
	</div>

<span><% 
Object obj2 = request.getAttribute("msg5");
String msg2 = (String)obj;
if(obj2!=null){
out.println(msg2);
}
%></span>


</body>
</html>