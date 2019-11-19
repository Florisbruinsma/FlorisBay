<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="MainStyle.css">
<title>Login</title>
</head>
<body>
	<div class="login-page">
	  	<form class="form" action="Login" method="post">
	      	<input type="text" name="username" placeholder="username"/>
	      	<input type="password" name="password" placeholder="password"/>
	      	<button>login</button>
	      	<% if (request.getParameter("login_state") != null){
	      		%>
	      		<%=request.getParameter("login_state")%>
	      		<%
	      	}else{
	      		%>
	      		
	      		<%
	      	}%>
	      	<p class="message">Not registered? <a href="CreateUser.jsp">Create an account</a></p>
	    </form>
	</div>
</body>
</html>