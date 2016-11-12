/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.me.juragandiskon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.jws.WebParam;
import javax.jws.WebService;

/**
 *
 * @author fazarafi
 */
@WebService(serviceName = "YourProduct")
public class YourProduct {
    static final int YOURPRODUCT_LENGTH = 100;
    static final String NULL_STRING = "*";
    
    //JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "cmrudi";
    static final String PASS = "takengon";
    
    public ArrayList<String> getProducts(@WebParam(name = "id") int user_id) {
        ArrayList<String> result;
        result = new ArrayList();
        try{
            
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql;
            sql = "SELECT product.product_id, product.username, product.product_name, product.price, product.description, product.total_likes, product.total_purchased, product.image_address, product.timestamp FROM product, user_authentication as ua WHERE deleted = 0 AND product.username = ua.username AND ua.id = ?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1,user_id);
            ResultSet rs = pre.executeQuery();
            rs.last();
            result.add(String.valueOf(rs.getRow()));
            rs.beforeFirst();
        while (rs.next()) {
                result.add(rs.getString("product_id"));
                result.add(rs.getString("username"));
                result.add(rs.getString("product_name"));
                result.add(rs.getString("price"));
                result.add(rs.getString("description"));
                result.add(rs.getString("total_likes"));
                result.add(rs.getString("total_purchased"));
                result.add(rs.getString("image_address"));
                result.add(rs.getString("timestamp"));
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

    /**
     * Web service operation
     */
    public String editProduct(@WebParam(name = "id") int user_id, @WebParam(name = "product_id") int prod_id) {
        //TODO write your implementation code here:
        return null;
    }

    /**
     * Web service operation
     */
    public String deleteProduct() {
        //TODO write your implementation code here:
        return null;
    }

    
    
}
