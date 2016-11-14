/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.juragandiskon;

import static com.me.juragandiskon.Catalog.JDBC_DRIVER;
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
import java.sql.SQLException;
import java.sql.Statement;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author cmrudi
 */
@WebService(serviceName = "Like")
public class Like {
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
    @WebMethod(operationName = "setLike")
    public String setLike(@WebParam(name = "productId") String productId, @WebParam(name = "accessToken") String accessToken) throws IOException {
        //TODO write your implementation code here:
        String message = "";
        String username;
        String id;
        String response = validateAccessToken(accessToken);
        String[] parse = response.split("-");
        id = parse[0];
        username = parse[1];
        
        try{
            
            // Register JDBC driver
            Class.forName(JDBC_DRIVER);
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT * FROM like_data WHERE product_id = ? AND user_id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,Integer.valueOf(productId));
            pre.setInt(2,Integer.valueOf(id));
            ResultSet rs = pre.executeQuery();
            String sqlUpdate1, sqlUpdate2;
            if (!rs.next()) {            
                sqlUpdate1 = "INSERT INTO like_data(product_id,user_id) VALUES (?,?)";
                sqlUpdate2 = "UPDATE product SET total_likes = total_likes + 1 WHERE product_id = ?";
            }
            else {
                sqlUpdate1 = "DELETE FROM like_data WHERE product_id = ? AND user_id = ?";
                sqlUpdate2 = "UPDATE product SET total_likes = total_likes - 1 WHERE product_id = ?";
            }
            PreparedStatement pre1 = conn.prepareStatement(sqlUpdate1);
            pre1.setInt(1,Integer.valueOf(productId));
            pre1.setInt(2,Integer.valueOf(id));
            
            PreparedStatement pre2 = conn.prepareStatement(sqlUpdate2);
            pre2.setInt(1,Integer.valueOf(productId));
            pre1.executeUpdate();
            pre2.executeUpdate();
            message = "successfullying";
            
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
            message = String.valueOf(se);
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
       
        }
        
        return message;
    }
}
