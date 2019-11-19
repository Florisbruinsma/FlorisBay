<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="MainStyle.css">
<title>Create acount</title>
</head>
<body>
	<div class="login-page">
	  	<form class="form" action="CreateUser" method="post">
			<input type="text" name="username" placeholder="name"/>
		    <input type="password" name="password"  placeholder="password"/>
		    <input type="password" name="password2"  placeholder="confirm password"/>
		    <input type="text"  name="email" placeholder="email address"/>
		    <button>create</button>
		    <p class="message">Already registered? <a href="Login.jsp">Sign In</a></p>
		</form>
	</div>
</body>
</html>