<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<script type="text/javascript" language="javascript">   
function disableBackButton()
{
window.history.forward()
}  
disableBackButton();  
window.onload=disableBackButton();  
window.onpageshow=function(evt) { if(evt.persisted) disableBackButton() }  
window.onunload=function() { void(0) }  
</script>
 <link href="admin.css" type="text/css" rel="stylesheet">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<%
String sId = (String)session.getAttribute("sessionId");
//String role = (String)session.getAttribute("role");
//System.out.println(role);

if(sId != request.getSession(false).getId()){
	session.invalidate();
	response.sendRedirect("login.html");
	
}
%>
<script type="text/javascript">

    if (top.location!= self.location) {
        top.location = self.location.href;
                   //or you can use your logout page as
                   //top.location='logout.jsp' here...
    }

</script>
</head>
<body onload="noBack();">

<div id="head-div">
    <section id="header-section">
  
            <span id="life">LIFE</span><span id="pharma">PHARMA</span><span id="head-span">Welcome &nbsp;&nbsp;${sessionScope.uid}</span>
      
       
        </section>
         

            <nav id="head-nav">
           
            <ul>
            <li class="nav-list"><a href="reports.jsp" target="display-area" >Reports</a></li>
             <li class="nav-list"><a href="PlaceOrder.jsp" target="display-area" >Place Order</a></li>
               <li class="nav-list"><a href="ReturnItems.jsp" target="display-area" >Return items</a></li>
              <li class="nav-list"><a href="AddToInventory.jsp" target="display-area" >Add to Inventory</a></li>
               <li class="nav-list"><a href="ViewUser.jsp" target="display-area" >View Users</a></li>
            <li class="nav-list"><a href="addUser.jsp" target="display-area" >Add User</a></li>
             <li class="nav-list"><a href="DeleteUser.jsp" target="display-area" >Delete User</a></li>
                 <li class="nav-list"><a href="logout.jsp" >LOGOUT</a></li>
            </ul>
            </nav>
            </div>
            
            <section id="section-body">
<div id="welcome-div"><span>Welcome</span>

</div>
<section id="body-section">
        <div id="div-body">
   <iframe id="window" src="dummy.html" name="display-area"></iframe>
        </div>
        </section>
</section>


</body>
</html>