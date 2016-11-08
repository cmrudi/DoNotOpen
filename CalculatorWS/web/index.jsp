<%-- 
    Document   : index
    Created on : Nov 6, 2016, 11:56:19 PM
    Author     : cmrudi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        <h1>    <%-- start web service invocation --%><hr/>
    <%
    try {
	org.me.calculatorws.CalculatorWebService_Service service = new org.me.calculatorws.CalculatorWebService_Service();
	org.me.calculatorws.CalculatorWebService port = service.getCalculatorWebServicePort();
	 // TODO initialize WS operation arguments here
	java.lang.String name = "test";
	// TODO process result here
	java.lang.String result = port.hello(name);
	out.println("Result = "+result);
    } catch (Exception ex) {
	// TODO handle custom exceptions here
    }
    %>
    <%-- end web service invocation --%><hr/>
</h1>
    </body>
</html>
