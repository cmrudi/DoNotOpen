<%-- 
    Document   : catalog
    Created on : Nov 13, 2016, 05:35 PM
    Author     : Dyas
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
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
%>   
    <%
    String[][] products = new String[100][11];
    String pageUri = request.getRequestURI();
    pageUri = pageUri.substring(0, 15);
    int productNum = 0;
    int user_id;
    String username = "";
    
    cookies = request.getCookies();
    %>
    
      
    <%-- start web service invocation --%><hr/>
    <%
    try {
	com.me.juragandiskon.Purchases_Service service = new com.me.juragandiskon.Purchases_Service();
	com.me.juragandiskon.Purchases port = service.getPurchasesPort();
	 // TODO initialize WS operation arguments here
	java.lang.String accessToken = selectedCookie;
	// TODO process result here
	java.util.List<java.lang.String> result = port.getPurchases(accessToken);
        
        user_id = Integer.parseInt(result.get(0));
        username = result.get(1);
        productNum = Integer.parseInt(result.get(2));
        int i = 3;
            int j;
        
        for (j = 0; j< productNum; j++) {
            products[j][0] = result.get(i); //timestamp
            i++;
            products[j][1] = result.get(i); //gambar
            i++;
            products[j][2] = result.get(i); //product_name
            i++;
            products[j][3] = result.get(i); //total
            i++;
            products[j][4] = result.get(i); //kuantitas
            i++;
            products[j][5] = result.get(i); //harga
            i++;
            products[j][6] = result.get(i); //penjual
            i++;
            products[j][7] = result.get(i); //buyerName
            i++;
            products[j][8] = result.get(i); //buyerAddress
            i++;
            products[j][9] = result.get(i); //postalCode
            i++;
            products[j][10] = result.get(i); //PhoneNumber
            i++;
        }
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>

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
        <h2>Here are your purchases</h2>
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
*/              out.println(products[i][0]);
            %>
            <hr>
            <div>
                <div class="left-container"><img id="catalogImage" src="img/<% out.println(products[i][1]); %>"></div>
                <div class="mid-container">
                    <p><b><% out.println(products[i][2]); %></b><br>
                    <% out.println("IDR " + products[i][3]); %><br>
                    <% out.println(products[i][4] + " pcs"); %><br>
                    <% out.println("@IDR" + (products[i][5])); %><br>
                    <% out.println("bought from <b>" + products[i][6] + "</b>"); %><br></p>

                </div>
                <div class="right-container">
                    <br><p id="transaction-Desc">
                    <% out.println("Delivery to <b>" + products[i][7] + "</b><br>"); %><br>
                    <% out.println(products[i][8]); %><br>
                    <% out.println(products[i][9]); %><br>
                    <% out.println(products[i][10]); %><br><br><br><br></p><br><br>
                </div>
            </div>
            <br>
            <hr>
            <br>
            <hr>
                
            <% }    %>
            
    </div>
    <div class="rhs"></div>
</body>
</html>
