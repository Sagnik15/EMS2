<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
   
    
     <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
</head>
<body>

<%
/* String uid =null;
String pwd = null; */

/*  if(request.getSession(false)!=null){
	
	session.invalidate();
	response.sendRedirect("login.html");
	
}
else{  */
	String uid = request.getParameter("uid");
	String pwd = request.getParameter("pwd");
	String role = request.getParameter("role");
	
session.setAttribute("uid", uid);
session.setAttribute("pwd", pwd);
session.setAttribute("role", role);

%>


<%-- <c:set var="uid" value="${uid }" scope="session"></c:set>
<c:set var="pwd" value="${ pwd}" scope="session"></c:set>
 --%>

<%-- <jsp:useBean id= "lb" class= "com.techm.bean.LoginBean" scope="session"></jsp:useBean>

<jsp:setProperty property="uid"  name="lb" param="uid"/>
<jsp:setProperty property="pwd"  name="lb" param="pwd"/>
<jsp:setProperty property="role"  name="lb" param="role"/> --%>


<jsp:forward page="loginservlet">
<jsp:param value="${uid}" name="uid"/>
<jsp:param value="${pwd}" name="pwd"/>
<jsp:param value="${role}" name="role"/>
</jsp:forward>
<%-- <%} %> --%>

</body>
</html>