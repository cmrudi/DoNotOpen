<%-- 
    Document   : confirmationPurchase
    Created on : Nov 8, 2016, 8:05:43 PM
    Author     : fazarafi
--%>

<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="java.net.URL"%>

<%-- start web service invocation --%>
    
    <%-- start web service invocation --%>
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
   
        String USER_AGENT = "Mozilla/5.0";
        String url = "http://localhost:8082/IdentityService/PurchaseServlet?access_token="+selectedCookie;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent",USER_AGENT);
        int responseCode = con.getResponseCode();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer responseText = new StringBuffer();
        while ((inputLine = in.readLine()) !=null) {
            responseText.append(inputLine);
        }
        String[] parse = responseText.toString().split("-");
   
%>
   
<%
    
        String[] info = new String[10];
        int productNum = 0;
        String pageUri = request.getRequestURI();
        pageUri = pageUri.substring(0, 15);
        int user_id;
        String username = "";
        int prodId = 0; 
        try {
            com.me.juragandiskon.ConfirmationPurchase_Service service = new com.me.juragandiskon.ConfirmationPurchase_Service();
            com.me.juragandiskon.ConfirmationPurchase port = service.getConfirmationPurchasePort();
	// TODO initialize WS operation arguments here
    
    // TODO process result here
        prodId = Integer.parseInt(request.getParameter("prod_id").toString());
    
    //result
	java.util.List<java.lang.String> result = port.getPurchaseInfo(selectedCookie, prodId);
        
        user_id = Integer.parseInt(result.get(0));
        username = result.get(1);
        productNum = Integer.parseInt(result.get(2));
        
        int i = 3;
        for (int j = 1 ; j<7; j++) {
            info[j] = result.get(i);
            i++;
        }
        
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
                <h4 class="hiUsername">Hi, <% out.println(username); %></h4>
                <div class="separator"></div>
                <a type="button" id="logoutButton" href="http://localhost:8082/IdentityService/LogoutServlet?id=<% out.println(selectedCookie); %>">logout</a>
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
                <span id="init" value=""><% out.println(info[2]); %></span>
                <input id="hiddenPrice" type="hidden" value="<% out.println(info[2]); %>" >

                <br>
                Delivery To : 
                <br>
                <br>
                Consignee <br>
                <input type = "text" name = "fullname" value = "<% out.println(parse[1]); %>">
                <p id="fullNameAlert"></p><br>
                Full Address <br>

                <textarea name="fulladdress" id="fulladdress"  rows="4" cols="127" ><% out.println(parse[3]); %></textarea>
                <p class="warning" id="fullAddressAlert"></p><br>
                Postal Code <br>
                <input type = "text" name = "postalcode" value = "<% out.println(parse[4]); %>">
                <p class="warning" id="postalCodeAlert"></p><br>
                Phone Number <br>
                <input type = "text" name = "phonenumber" value = "<% out.println(parse[5]); %>">
                <p class="warning" id="phoneNumberAlert"></p><br>
                12 Digits Credit Card Number<br>
                <input type = "text" id = "creditcard" name = "creditcard">
                <p class="warning" id="cardAlert"></p><br>
                3 Digits Card Verification Value <br>
                <input type = "text" id = "verifnum" name = "verifnum">
                <p class="warning" id="verifAlert"></p><br>

                <input class="button-right-group" type="button" value="CANCEL" id="CANCEL" onclick="<% out.print("href=\""+pageUri+"catalog.jsp"+"\"");%>">
                <input class="button-right-group" type="submit" name="confirm" value="CONFIRM">


            </form>
    <%
        String[] data = new String[10];
        String buyerName = request.getParameter("fullname");
        String quantity = request.getParameter("quantity");
        String creditCard = request.getParameter("creditcard");
        String verifNum = request.getParameter("verifnum");
        String buyerAddress = request.getParameter("fulladdress");
        String postalCode = request.getParameter("postalcode");
        String phoneNumber = request.getParameter("phonenumber");
        if (verifNum != null) {
            
            try {
                com.me.juragandiskon.ConfirmationPurchase_Service service = new com.me.juragandiskon.ConfirmationPurchase_Service();
                com.me.juragandiskon.ConfirmationPurchase port = service.getConfirmationPurchasePort();
                 // TODO initialize WS operation arguments here
                 Integer x = new Integer(prodId);
                java.lang.String prod_Id = x.toString();
                java.lang.String accessToken = selectedCookie;

                // TODO process result here
                java.lang.String result = port.purchaseProduct(prod_Id, accessToken, buyerName, quantity, creditCard, verifNum, buyerAddress, postalCode, phoneNumber);
                
            } catch (Exception ex) {
                // TODO handle custom exceptions here
            }
        }
    %>
    <%-- end web service invocation --%>
                    
   
   


            <!--CONTAINER BOTTOM BORDER-->
	</div>
	</body>
</html>