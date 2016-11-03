<%-- 
    Document   : register
    Created on : Nov 2, 2016, 8:50:48 AM
    Author     : cmrudi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
      <title>
         Register
      </title>
      <link rel="stylesheet" type="text/css" href="style.css">
      <script type="text/javascript" src="validate.js"></script>
   </head>

   <body>
	  <div class="lhs"></div>
	  <div class="centre">
		  <h1>Sale<span>Project</span></h1> <br>
		  <h2> Please register </h2>
                  <c:if test="${not empty message}">
                    <p>${message}</p>
                  </c:if>
		  <hr>
		  <br>
		  <form name="registerForm" action="RegisterServlet" onsubmit="return validateRegisterForm()" method = "post">
			 Full Name <br>
			 <input type = "text" name = "fullname">
			 <p class="warning" id="fullNameAlert"></p><br>
			 Username <br>
			 <input type = "text" name = "username">
			 <p class="warning" id="usernameAlert"></p><br>
			 Email <br>
			 <input type = "text" name = "email">
			 <p class="warning" id="emailAlert"></p><br>
			 Password<br>
			 <input type = "password" name = "password">
			 <p class="warning" id="passwordAlert"></p><br>
			 Confirm Password<br>
			 <input type = "password" name = "confirm">
			 <p class="warning" id="confirmAlert"></p><br>
			 Full Address <br>
			 <input type = "text" name = "fulladdress">
			 <p class="warning" id="fullAddressAlert"></p><br>
			 Postal Code <br>
			 <input type = "text" name = "postalcode">
			 <p class="warning" id="postalCodeAlert"></p><br>
			 Phone Number <br>
			 <input type = "text" name = "phonenumber">
			 <p class="warning" id="phoneNumberAlert"></p><br>
			 <input type="submit" value="REGISTER">
		  </form>
		  <h4>Already Registered? Login <a href="index.html"><span>here</span></a></h4>
	  </div>
	  <div class="rhs"></div>
   </body>

</html>

