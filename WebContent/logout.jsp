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
<%

if(request.getSession(false)!=null){
session.invalidate();
/* RequestDispatcher rd = request.getRequestDispatcher("/login.jsp");
rd.forward(request, response); */
}
%>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">

    if (top.location!= self.location) {
        top.location = self.location.href
                   //or you can use your logout page as
                   //top.location='logout.jsp' here...
    }

</script>
<style>
body{
margin:0;
text-align: center;
}
#inner{
padding-top: 3%;
padding-bottom:3%;
margin-bottom:3%;
text-align: center;
font-family: 'Century Gothic';
font-size: 200%;
background-color: #66a3ff;
}
#outer{
font-family:'Century Gothic';
margin-top:25%;
padding-bottom:1%;
text-decoration: none;

}
a{
font-size:110%;
text-decoration: none;
margin-top: 20px;
}
</style>
</head>
<body>
<div id="outer">

<div id="inner">

LOGOUT SUCCESSFULL !

</div>
<a href="login.html">Click here to Login Again</a>
</div>
</body>
</html>