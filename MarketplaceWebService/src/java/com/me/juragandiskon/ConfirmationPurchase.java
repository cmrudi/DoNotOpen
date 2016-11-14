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
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author fazarafi
 */
@WebService(serviceName = "ConfirmationPurchase")
public class ConfirmationPurchase {
    static final int CONF_LENGTH = 100;
    static final String NULL_STRING = "*";
    
    //JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd_MP?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "cmrudi";
    static final String PASS = "takengon";
    static final String USER_AGENT = "Mozilla/5.0";
    

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPurchaseInfo")
    public ArrayList<String> getPurchaseInfo( @WebParam(name = "access_token") String access_token, @WebParam(name = "prod_id") int prod_id) throws IOException {
        //TODO write your implementation code here:
        String check = "slalusa";
        String username;
        String id;
        String response = validateAccessToken(access_token);
        String[] parse = response.split("-");
        id = parse[0];
        username = parse[1];
        int user_id = Integer.valueOf(id);
        ArrayList<String> result = new ArrayList<String>();
        
        try{
            
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            check = "tessat";
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM product WHERE product_id=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, prod_id);
            ResultSet rs = pre.executeQuery();
            rs.last();
            result.add(id);
            result.add(username);
            result.add(String.valueOf(rs.getRow()));
            rs.beforeFirst();
            while (rs.next()) {
                result.add(rs.getString("product_name"));
                result.add(rs.getString("price"));
            }
            
            sql = "SELECT * FROM user_authentication as ua,user_data as ud WHERE ua.username=ud.username and id = ?";
            pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            rs = pre.executeQuery();
            rs.last();
            result.add(String.valueOf(rs.getRow()));
            rs.beforeFirst();
            while (rs.next()) {
                result.add(rs.getString("full_name"));
                result.add(rs.getString("full_address"));
                result.add(rs.getString("postal_code"));
                result.add(rs.getString("phone_number"));
            }
            
            
            
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
       
        }
        
        return result;
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

    /**
     * Web service operation
     */
    @WebMethod(operationName = "purchaseProduct")
    public String purchaseProduct(@WebParam(name = "prod_id") String prod_id, @WebParam(name = "access_token") String access_token, @WebParam(name = "buyerName") String buyerName, @WebParam(name = "quantity") String quantity, @WebParam(name = "creditCard") String creditCard, @WebParam(name = "verifNum") String verifNum, @WebParam(name = "buyerAddress") String buyerAddress, @WebParam(name = "postalCode") String postalCode, @WebParam(name = "phoneNumber") String phoneNumber) {
        String error = "error";
        String username_new = "";
        //TODO write your implementation code here:
        try {
            String id;
            String response = validateAccessToken(access_token);
            error = response;
            String[] parse = response.split("-");
            id = parse[0];
            username_new = parse[1]; 
            
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Execute SQL query
            Statement stmt = conn.createStatement();
            // Execute SQL query
           long unixTime = System.currentTimeMillis() / 1000L;
            
            String sql = "INSERT INTO `purchase_data`(`product_id`,`quantity`,`username`, `buyer_name`,`buyer_address`, `postal_code`, `phone_number`,`credit_card`, `verif_card`,`timestamp`) VALUES (?,?,?,?,?,?,?,?,?,?)";
        
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,Integer.valueOf(prod_id));
            
            pre.setInt(2,Integer.valueOf(quantity));
            pre.setString(3,username_new);
            pre.setString(4,buyerName);
            pre.setString(5,buyerAddress);
            pre.setString(6,postalCode);
            pre.setString(7,phoneNumber);
            pre.setString(8,creditCard);
            pre.setString(9,verifNum);
            error = prod_id + "|" + quantity + "|" + username_new + "|" + buyerName + "|" + buyerAddress + "|" + postalCode + "|" + phoneNumber + "|" + creditCard + "|" + verifNum;
            pre.setInt(10, (int) unixTime);
            
            // (4) execute the sql timestamp insert statement, then shut everything down
            
            pre.executeUpdate();
            
            pre.close();
            
            
        } catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
        
        }

        return error;
    }
    
    
}