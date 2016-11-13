<%-- 
    Document   : purchasingResponse
    Created on : Nov 12, 2016, 10:15:15 PM
    Author     : fazarafi
--%>

<%@page import="java.util.Date"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Timestamp"%>
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
    <h2>Purchases</h2>
    </body>
    <%
        String JDBC_DRIVER="com.mysql.jdbc.Driver";  
        String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd?zeroDateTimeBehavior=convertToNull";

        //  Database credentials
        String USER = "cmrudi";
        String PASS = "takengon";
        
        // Register JDBC driver
        Class.forName("com.mysql.jdbc.Driver");

        // Open a connection
        Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
        
        String buyerName = request.getParameter("fullname");
        String quantity = request.getParameter("quantity");
        String creditCard = request.getParameter("creditcard");
        String verifNum = request.getParameter("verifnum");
        String buyerAddress = request.getParameter("fulladdress");
        String postalCode = request.getParameter("postalcode");
        String phoneNumber = request.getParameter("phonenumber");
        Date date= new Date();
        int timeNow = (int) date.getTime();
        
        String sql = "INSERT INTO `purchase_data`(`product_id`,`quantity`,`username`, `buyer_name`,`buyer_address`, `postal_code`, `phone_number`,`credit_card`, `verif_card`,`timestamp`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        PreparedStatement pre = conn.prepareStatement(sql);
        pre.setString(1,request.getParameter("prod_id"));
        pre.setString(2,quantity);
        pre.setString(3,"nama");
        pre.setString(4,buyerName);
        pre.setString(5,buyerAddress);
        pre.setString(6,postalCode);
        pre.setString(7,phoneNumber);
        pre.setString(8,creditCard);
        pre.setString(9,verifNum);
        pre.setInt(10, timeNow);

        // (4) execute the sql timestamp insert statement, then shut everything down
        pre.executeUpdate();
        pre.close();
        
        %>
</html>
