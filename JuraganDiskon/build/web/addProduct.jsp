<%-- 
    Document   : addProduct
    Created on : Nov 4, 2016, 1:24:34 AM
    Author     : cmrudi
--%>
<%
   Cookie cookie = null;
   Cookie[] cookies = null;
   String selectedCookie = "";
   // Get an array of Cookies associated with this domain
   cookies = request.getCookies();
   if( cookies != null ){
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
         if (cookie.getName().equals("JuraganDiskon")) {
             selectedCookie = cookie.getValue();
         }
      }
  }else{
      out.println("<h2>No cookies founds</h2>");
  }
  String username = "default";
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>JuraganDiskon</title>
        <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
        <link href='http://fonts.googleapis.com/css?family=Open+Sans' rel='stylesheet' type='text/css'>
        <link rel="stylesheet" href="style.css" />
        <script type="text/javascript" src="validate.js"></script>
    </head>
    <body>
    <div class="lhs"></div>
    <div class="centre">
	<h1>Juragan<span>Diskon</span></h1>
	<br>
        <div id="centeredmenu" class="mati">
            <ul>
            <li><a class="mati" href="/JuraganDiskon/catalog.jsp">Catalog</a></li>
            <li><a class="mati" href="/JuraganDiskon/yourProduct.jsp">Your Product</a></li>
            <li><a class="mati" href="/JuraganDiskon/addProduct.jsp">Add Product</a></li>
            <li><a class="mati" href="/JuraganDiskon/sales.jsp">Sales</a></li>
            <li><a class="mati" href="/JuraganDiskon/purchase.jsp">Purchase</a></li>
            </ul>
        </div>
        <!--HEADER BOTTOM BORDER-->
        <div class="width-100">
            <ul>
                <h4 class="hiUsername">Hi, <% out.println(username); %></h4>
                <div class="separator"></div>
                <a type="button" id="logoutButton" href="http://localhost:8082/IdentityService/LogoutServlet?id=<% out.println(selectedCookie); %>">logout</a>
            </ul>
        </div>
        <h2>Please add your product here</h2>
        <hr><br><br>

        <form name="addProductForm" enctype="multipart/form-data" action="UploadImage" onsubmit="return validateAddProductForm()" method="POST">
                Product name <br>
                <input type = "text" name = "productName">
                <p class="warning" id="productNameAlert"></p><br>
                Description (max 200 chars) <br>
                <textarea name="desc" id="productDescription"  rows="5" cols="127"></textarea>
                <p class="warning" id="productDescriptionAlert"></p><br>
                Price (IDR) <br>
                <input type = "text" name = "productPrice">
                <p class="warning" id="productPriceAlert"></p><br>
                <input type="file" name="file" id="file">
                <p class="warning" id="productImageAlert"></p><br>
                <input class="button-right-group" type="button" id="cancelAddProductButtons" value="CANCEL" onclick="cancelAddProduct()">
                <input class="button-right-group" type="submit" name="submit" value="ADD">
                <br>
        </form>
        <% String productName = request.getParameter("productName");
           String productDesc = request.getParameter("desc");
           String priceString = request.getParameter("productPrice");
           int price;
        %>
    </div>
    <div class="rhs"></div>
    </body>
</html>




