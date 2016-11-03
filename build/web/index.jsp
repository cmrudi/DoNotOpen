<%-- 
    Document   : index
    Created on : Nov 2, 2016, 6:55:44 PM
    Author     : cmrudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
	<head>
		<title>JuraganDiskon</title>
                <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
                <meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
		<link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
		<link rel="stylesheet" href="style.css" />
		<script type="text/javascript" src="Login/login.js"></script>
		
	</head>
	<body>
	<div class="lhs-login"></div>
	<div class="centre-login">
		<h1>Sale<span>Project</span></h1>
		<br>
		<h3>Please Login</h3>
		<form name="loginForm" action = "IdentityService"  method = "POST">
			Username or email <br>
			<input type = "text" name = "usernameOrEmail">
			<p class="warning" id="usernameOrEmailAlert"></p><br>
			Password <br>
			<input type = "password" name = "password">
			<p class="warning" id="passwordAlert"></p><br>
			<input type="submit" value="Login">
			<br>
		</form>
		<h3>Don't have an account yet? Register <a href="register.jsp">here</a></h3>

	</div>
	<div class="rhs-login"></div>
    </body>
</html>
