<%-- 
    Document   : editProduct
    Created on : Nov 12, 2016, 5:21:56 AM
    Author     : fazarafi
--%>

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
            <li><a class="mati" href="#">Sales</a></li>
            <li><a class="mati" href="#">Purchase</a></li>
            </ul>
        </div>
        <!--HEADER BOTTOM BORDER-->
        <div class="width-100">
            <ul>
                <h4 class="hiUsername">Hi, username</h4>
                <div class="separator"></div>
                <button type="button" id="logoutButton" onclick="" >logout</button>
            </ul>
        </div>
        <h2>Please edit your product here</h2>
        <hr><br><br>

        <form name="addProductForm" enctype="multipart/form-data" action="" onsubmit="return validateAddProductForm()" method="POST">
                Product name <br>
                <input type = "text" name = "productName" value="">
                <p class="warning" id="productNameAlert"></p><br>
                Description (max 200 chars) <br>
                <textarea name="desc" id="productDescription"  rows="5" cols="127"></textarea>
                <p class="warning" id="productDescriptionAlert"></p><br>
                Price (IDR) <br>
                <input type = "text" name = "productPrice">
                <p class="warning" id="productPriceAlert"></p><br>
                <input type="file" name="userfile" id="file">
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
        <h1><% if (productName == null) {
                    out.println("kosongs");
                } else {
                    price = Integer.valueOf(priceString);
                    out.println(productName);
                } 
            
            
            %></h1>
    </div>
    <div class="rhs"></div>
    </body>
</html>
