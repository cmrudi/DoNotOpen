/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.juragandiskon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author cmrudi
 */
@WebService(serviceName = "AddProduct")
public class AddProduct {
    static final int CATALOG_LENGTH = 100;
    static final String NULL_STRING = "*";
    
    //JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd_MP?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "cmrudi";
    static final String PASS = "takengon";
    static final String USER_AGENT = "Mozilla/5.0";
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "hello")
    public String hello(@WebParam(name = "name") String txt) {
        return "Hello " + txt + " !";
    }

    /**
     * Web service operation
     */
    @WebMethod(operationName = "addProductToDB")
    public String addProductToDB(@WebParam(name = "productName") String productName, @WebParam(name = "price") String price, @WebParam(name = "description") String description, @WebParam(name = "imageAddress") String imageAddress, @WebParam(name = "accessToken") String accessToken) {
        //TODO write your implementation code here:
        String username_new = "";
        try{
            
            String id;
            String response = validateAccessToken(accessToken);
            String[] parse = response.split("-");
            id = parse[0];
            username_new = parse[1]; 
            long unixTime = System.currentTimeMillis() / 1000L;
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "INSERT INTO product(username, product_name, price, description, total_likes,total_purchased, image_address,timestamp) VALUES (?,?,?,?,?,?,?,?)";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,username_new);
            pre.setString(2,productName);
            pre.setInt(3,Integer.valueOf(price));
            pre.setString(4,description);
            pre.setInt(5,0);
            pre.setInt(6,0);
            pre.setString(7,imageAddress);
            pre.setInt(8, (int) unixTime);
            
            pre.executeUpdate();
            
            
            
         }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
       
        }       
        return username_new;
    }
    
    public String validateAccessToken (String access_token) throws MalformedURLException, IOException {
        String url = "http://localhost:8082/IdentityService/validateTokenServlet?access_token="+access_token;
        URL obj = new URL(url);
        HttpURLConnection con = (HttpURLConnection) obj.openConnection();
        
        con.setRequestMethod("GET");
        con.setRequestProperty("User-Agent",USER_AGENT);
        int responseCode = con.getResponseCode();
        
        BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
        String inputLine;
        StringBuffer response = new StringBuffer();
        while ((inputLine = in.readLine()) !=null) {
            response.append(inputLine);
        }
        return response.toString();
    }
}
