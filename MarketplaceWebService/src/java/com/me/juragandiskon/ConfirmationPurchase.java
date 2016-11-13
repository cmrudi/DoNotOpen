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
    static final String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "cmrudi";
    static final String PASS = "takengon";


    /**
     * Web service operation
     */
    @WebMethod(operationName = "getPurchaseInfo")
    public ArrayList<String> getPurchaseInfo( @WebParam(name = "user_id") int user_id, @WebParam(name = "prod_id") int prod_id) {
        //TODO write your implementation code here:
        ArrayList<String> result = new ArrayList();
        
        try{
            
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String sql = "SELECT * FROM product WHERE product_id=?";
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setInt(1, prod_id);
            ResultSet rs = pre.executeQuery();
            rs.last();
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
    
    
    
}