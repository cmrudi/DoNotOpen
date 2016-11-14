<%-- 
    Document   : like
    Created on : Nov 13, 2016, 10:08:16 PM
    Author     : cmrudi
--%>

<%
    String productId = request.getParameter("prod_id");
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
    

        //-- start web service invocation --
    String result = "";
    try {
	com.me.juragandiskon.Like_Service service = new com.me.juragandiskon.Like_Service();
	com.me.juragandiskon.Like port = service.getLikePort();
	 // TODO initialize WS operation arguments here
	java.lang.String accessToken = selectedCookie;
	// TODO process result here
	result = port.setLike(productId, accessToken);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    out.println(result);
    
    String site = new String("http://localhost:8080/JuraganDiskon/catalog.jsp");
    response.setStatus(response.SC_MOVED_TEMPORARILY);
    response.setHeader("Location", site);
    
    %>
    <%-- end web service invocation --%><hr/>

    


%>
