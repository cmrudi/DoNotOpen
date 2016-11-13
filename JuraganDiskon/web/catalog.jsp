<%-- 
    Document   : catalog
    Created on : Nov 3, 2016, 8:51:39 PM
    Author     : cmrudi
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%
   Cookie cookie = null;
   Cookie[] cookies = null;
   String selectedCookie = "";
   // Get an array of Cookies associated with this domain
   cookies = request.getCookies();
   if( cookies != null ){
      out.println("<h2> Found Cookies Name and Value</h2>");
      for (int i = 0; i < cookies.length; i++){
         cookie = cookies[i];
         out.print("Name : " + cookie.getName( ) + ",  ");
         out.print("Value: " + cookie.getValue( )+" <br/>");
         if (cookie.getName().equals("JuraganDiskon")) {
             selectedCookie = cookie.getValue();
             out.print("Selected Value: " + cookie.getValue( )+" <br/>");
         }
      }
  }else{
      out.println("<h2>No cookies founds</h2>");
  }
%>
    <%-- start web service invocation --%>
    <%
    String[][] catalog = new String[100][10];
    int productNum = 0;
    try {
	com.me.juragandiskon.Catalog_Service service = new com.me.juragandiskon.Catalog_Service();
	com.me.juragandiskon.Catalog port = service.getCatalogPort();
	// TODO process result here
        
	java.util.List<java.lang.String> result = port.getCatalog(selectedCookie);//please check user id here
        productNum = Integer.parseInt(result.get(0));
        int i = 1;
        for (int j = 0; j < productNum; j++ ) {
            catalog[j][0] = result.get(i); //product_id
            i++;
            catalog[j][1] = result.get(i); //username
            i++;
            catalog[j][2] = result.get(i); //product_name
            i++;
            catalog[j][3] = result.get(i); //price
            i++;
            catalog[j][4] = result.get(i); //description
            i++;
            catalog[j][5] = result.get(i); //total_likes
            i++;
            catalog[j][6] = result.get(i); //total_purchased
            i++;
            catalog[j][7] = result.get(i); //image_address
            i++;
            catalog[j][8] = result.get(i); //timestamp
            i++;
            catalog[j][9] = result.get(i); //liked
            i++;
    
    }
        
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%>



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
        <h2>What are you going to buy today?</h2>
            <hr><br><br>
            <form name="searchForm" action="catalog.jsp" onsubmit="return validateSearchForm()" method = "POST">
                <p id="inputTextAlert"></p>
                <p id="radioAlert"></p>
                <div id="searchItem" >
                        <input type = "text"  name = "searchItem">

                </div>
                <div id="submitSearchItem">
                        <input type="submit" id="searchItemSubmitButton" value="Go">
                </div><br>
                <p>by</p>
                <input type="radio" id="searchChoice1" name="searchChoice" value="product"> Product<br>
                <input type="radio" id="searchChoice2" name="searchChoice" value="store"> Store<br><br><br>
            </form>
            <% String searchText = request.getParameter("searchItem");
                String byProduct = request.getParameter("searchChoice"); %>
                <%-- start web service invocation --%>
    <%
    if (searchText != null) {
        try {
            com.me.juragandiskon.Catalog_Service service = new com.me.juragandiskon.Catalog_Service();
            com.me.juragandiskon.Catalog port = service.getCatalogPort();
             // TODO initialize WS operation arguments here
            java.lang.String textSearch = searchText;
            java.lang.String searchMethod = byProduct;
            int id = 1;
            // TODO process result here
            java.util.List<java.lang.String> result = port.searchCatalog(textSearch, searchMethod, id);
                 
            productNum = Integer.parseInt(result.get(0));
            int i = 1;
            for (int j = 0; j < productNum; j++ ) {
                catalog[j][0] = result.get(i); //product_id
                i++;
                catalog[j][1] = result.get(i); //username
                i++;
                catalog[j][2] = result.get(i); //product_name
                i++;
                catalog[j][3] = result.get(i); //price
                i++;
                catalog[j][4] = result.get(i); //description
                i++;
                catalog[j][5] = result.get(i); //total_likes
                i++;
                catalog[j][6] = result.get(i); //total_purchased
                i++;
                catalog[j][7] = result.get(i); //image_address
                i++;
                catalog[j][8] = result.get(i); //timestamp
                i++;
                catalog[j][9] = result.get(i); //liked
                i++;

            }
            
        } catch (Exception ex) {
            // TODO handle custom exceptions here
        }
    }
    %>
    <%-- end web service invocation --%>

            
            <% for (int i=0; i<productNum; i++){ %>
            <hr>
            <br>
            <br>
            <p><% out.println(catalog[i][1] + "  uploaded at "+ catalog[i][8]); %></p>
            <hr>
            <div>
                <div class="left-container"><img id="catalogImage" src="img/<% out.println(catalog[i][7]); %>"></div>
                <div class="mid-container">
                    <p><b><% out.println(catalog[i][2]); %></b><br><% out.println(catalog[i][3]); %><br><% out.println(catalog[i][4]); %></p>
                </div>
                <div class="right-container">
                    <br><p id="totalLikes"><% out.println(catalog[i][5]); %> likes</p>
                    <p><% out.println(catalog[i][6]); %> purchases<br></p>
                      <button type="button" class="<% if (catalog[i][9].equals("1")) { out.print("likedButton");} else { out.print("likeButton");} %>" id="likeButton">Like</button>
                      <a type="button" id="buyButton" href="/JuraganDiskon/confirmationPurchase.jsp">Buy</a>
                </div>
            </div>
            <br>
            <hr>
            <br><br>
            <% } %>
            
    </div>
    <div class="rhs"></div>
    </body>
</html>

