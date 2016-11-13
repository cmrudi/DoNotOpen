<%-- 
    Document   : confirmationPurchase
    Created on : Nov 8, 2016, 8:05:43 PM
    Author     : fazarafi
--%>
    <%-- start web service invocation --%><hr/>
    
    <%-- start web service invocation --%><hr/>
    <%
    
        String[] info = new String[10];
        int productNum = 0;
        String pageUri = request.getRequestURI();
        pageUri = pageUri.substring(0, 15);
        int userId = 0;
    
    try {
	com.me.juragandiskon.ConfirmationPurchase_Service service = new com.me.juragandiskon.ConfirmationPurchase_Service();
	com.me.juragandiskon.ConfirmationPurchase port = service.getConfirmationPurchasePort();
	 // TODO initialize WS operation arguments here
	userId = Integer.parseInt(request.getParameterValues("id").toString());
	int prodId = Integer.parseInt(request.getParameterValues("prod_id").toString());
	// TODO process result here
	java.util.List<java.lang.String> result = port.getPurchaseInfo(userId, prodId);
        
        int i = 1;
        for (i = 1 ; i<7; i++) {
            info[i] = result.get(i);
        }
        
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
    
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
                <h4 class="hiUsername">Hi, username</h4>
                <div class="separator"></div>
                <button type="button" id="logoutButton" onclick="" >logout</button>
            </ul>
        </div>
    <h2>Please confirm your purchase</h2>
            <hr><br><br>

            <!--CONTAINER UPPER BORDER-->
            <form name="purchaseForm" action="" onsubmit="return validatePurchase()" method = "POST">
                Product 	: <% out.println(info[1]); %> 
                <br>
                Price	 	: IDR <% out.println(info[2]); %>

                <br>
                Quantity 	:<input type = "num" id="qty" name = "quantity" value ="1" onkeyup="return countTotalPrice()">

                <br>
                Total Price	: IDR <span id="total" value="<?php print printPrice($price) ?>"> </span>
                <span id="init" value=""><?php echo printPrice($price) ?></span>
                <input id="hiddenPrice" type="hidden" value="<?php echo $price ?>" >

                <br>
                Delivery To : 
                <br>
                <br>
                Consignee <br>
                <input type = "text" name = "fullname" value = "<% out.println(info[3]); %>">
                <p id="fullNameAlert"></p><br>
                Full Address <br>

                <textarea name="fulladdress" id="<% out.println(info[4]); %>"  rows="4" cols="127" ><?php echo $fullAddress ?></textarea>
                <p class="warning" id="fullAddressAlert"></p><br>
                Postal Code <br>
                <input type = "text" name = "postalcode" value = "<% out.println(info[5]); %>">
                <p class="warning" id="postalCodeAlert"></p><br>
                Phone Number <br>
                <input type = "text" name = "phonenumber" value = "<% out.println(info[6]); %>">
                <p class="warning" id="phoneNumberAlert"></p><br>
                12 Digits Credit Card Number<br>
                <input type = "text" id = "creditcard" name = "creditcard">
                <p class="warning" id="cardAlert"></p><br>
                3 Digits Card Verification Value <br>
                <input type = "text" id = "verifnum" name = "verifnum">
                <p class="warning" id="verifAlert"></p><br>

                <input class="button-right-group" type="button" value="CANCEL" id="CANCEL" onclick="<% out.print(pageUri+"catalog.jsp?"+"id="+userId);%>">
                <input class="button-right-group" type="submit" name="confirm" value="CONFIRM">


            </form>


            <!--CONTAINER BOTTOM BORDER-->
	</div>
	</body>
</html>