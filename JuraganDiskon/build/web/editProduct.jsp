<%-- 
    Document   : editProduct
    Created on : Nov 12, 2016, 5:21:56 AM
    Author     : fazarafi
--%>
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
        
        String[] info = new String[10];
        int productNum = 0;
        String pageUri = request.getRequestURI();
        pageUri = pageUri.substring(0, 15);
        int user_id;
        String username = "";
        
        int prodId = 0; 
        String productId = "0";
        // TODO process result here
        productId = request.getParameter("prod_id");
        prodId = Integer.parseInt(productId);
    
    try {
	com.me.juragandiskon.EditProduct_Service service = new com.me.juragandiskon.EditProduct_Service();
	com.me.juragandiskon.EditProduct port = service.getEditProductPort();
	 // TODO initialize WS operation arguments here
	java.lang.String accessToken = selectedCookie;
	// TODO process result here
	java.util.List<java.lang.String> result = port.getEditingProdInfo(prodId, accessToken);
	
    
        int i = 3;
        for (int j = 1 ; j<10; j++) {
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
        <h2>Please edit your product here</h2>
        <hr><br><br>

        <form name="addProductForm" enctype="multipart/form-data" action="UploadImageEdit" onsubmit="return validateAddProductForm()" method="POST">
                Product name <br>
                <input type="hidden" name="uname" value="<% out.print(productId) ;%>"> 
                <input type = "text" name = "productName" value="<% out.print(info[3]);%>">
                <p class="warning" id="productNameAlert"></p><br>
                Description (max 200 chars) <br>
                <textarea name="desc" id="productDescription" rows="5" cols="127"><% out.print(info[5]);%></textarea>
                <p class="warning" id="productDescriptionAlert"></p><br>
                Price (IDR) <br>
                <input type = "text" name = "productPrice" value="<% out.print(info[4]);%>">
                <p class="warning" id="productPriceAlert"></p><br>
                
                <input type="file" name="file" id="file" value="<% out.print(info[6]);%>">
                <p class="warning" id="productImageAlert"></p><br>
                <input class="button-right-group" type="button" name="cancel" id="cancelAddProductButtons" value="CANCEL" onclick="cancelAddProduct()">
                <input class="button-right-group" type="submit" name="submit" value="ADD">
                <br>
        </form>

    </div>
    <div class="rhs"></div>
    </body>
</html>
