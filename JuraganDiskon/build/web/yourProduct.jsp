<%-- 
    Document   : yourProduct
    Created on : Nov 8, 2016, 8:33:28 PM
    Author     : fazarafi
--%>
    <%@page import="com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date()"%>
<%@page import="com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date()"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%-- start web service invocation --%>
    <%
    String[][] products = new String[100][9];
    int productNum = 0;
    
    try {
	com.me.juragandiskon.YourProduct_Service service = new com.me.juragandiskon.YourProduct_Service();
	com.me.juragandiskon.YourProduct port = service.getYourProductPort();
	 // TODO initialize WS operation arguments here
	int id = 0;
	// TODO process result here
	java.util.List<java.lang.String> result = port.getProducts(1);
	productNum = Integer.parseInt(result.get(0));
        int i = 1;
        int j;
        
        for (j = 0; j< productNum; j++) {
            products[j][0] = result.get(i); //product_id
            i++;
            products[j][1] = result.get(i); //username
            i++;
            products[j][2] = result.get(i); //product_name
            i++;
            products[j][3] = result.get(i); //price
            i++;
            products[j][4] = result.get(i); //description
            i++;
            products[j][5] = result.get(i); //total_likes
            i++;
            products[j][6] = result.get(i); //total_purchased
            i++;
            products[j][7] = result.get(i); //image_address
            i++;
            products[j][8] = result.get(i); //timestamp
            i++;
            
        }
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>

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
        <h2>What are you going to sell today?</h2>
        <hr>
            <br><br>
          <% for (int i=0; i<productNum; i++){ %>
            <p>
            
                <% 
                /*
                SimpleDateFormat d1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                SimpleDateFormat t1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date d = d1.parse(products[i][8]);
                Date t = t1.parse(products[i][8]);
                
                StringBuilder date = new StringBuilder( d1.format(d) );
                StringBuilder time = new StringBuilder( t1.format(t) );
                date.toString();
                time.toString();
                
                out.println("<b>"+date+"</b><br>"+"at "+time);    
*/              out.println(products[i][8]);
            %>
            <hr>
            <div>
                <div class="left-container"><img id="catalogImage" src="img/<% out.println(products[i][7]); %>"></div>
                <div class="mid-container">
                    <p><b><% out.println(products[i][2]); %></b><br><% out.println(products[i][3]); %><br><% out.println(products[i][4]); %></p>
                </div>
                <div class="right-container">
                    <br><p id="totalLikes"><% out.println(products[i][5]); %> likes</p>
                    <p><% out.println(products[i][6]); %> purchases<br></p>
                        <button type="button" id="editButton" onclick="<?php print "location.href='".$getURL."editProduct.php?id=".$id."&productId=".$row['product_id']."';"?>">EDIT</button>
                        <button type="button" id="deleteButton" name="deletingProduct" value="<% out.print(products[i][0]); %>">DELETE</button>
                </div>
            </div>
            <br>
            <br>
            <hr>
            <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            <hr>
            <br>
				
            <% } %>
            
    </div>
    <div class="rhs"></div>
    </body>
</html>
