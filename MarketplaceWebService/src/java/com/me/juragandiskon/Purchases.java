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
 * @author cmrudi
 */
@WebService(serviceName = "Purchases")
public class Purchases {
    //static final int CATALOG_LENGTH = 100;
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
    @WebMethod(operationName = "getPurchases")
    public ArrayList<String> getPurchases(@WebParam(name = "access_token") String access_token) throws IOException {
        //TODO write your implementation code here:
        String check ="error";
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
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Execute SQL query
            String quer;
            quer = "SELECT product.product_name, product.username as seller, product.image_address as gambar, product.price as harga, purchase_data.* FROM product, purchase_data WHERE product.product_id = purchase_data.product_id AND purchase_data.username = ?";
            PreparedStatement pre = conn.prepareStatement(quer);
            pre.setString(1,username);
            ResultSet rs = pre.executeQuery();
            rs.last();
            result.add(id);
            result.add(username);
            result.add(String.valueOf(rs.getRow()));
            rs.beforeFirst();
            String satuan;
            String kuantitas;
            Long total;
            while (rs.next()) {
                //waktu : hari, tanggal bulan tahun
                result.add(rs.getString("timestamp"));
                // gambar produk
                result.add(rs.getString("gambar"));
                //nama produk
                result.add(rs.getString("product_name"));

                //harga total

                //kalkulasi
                satuan = rs.getString("harga");
                kuantitas = rs.getString("quantity");
                total = new Long(Integer.valueOf(satuan)*Integer.valueOf(kuantitas));

                //add to result
                result.add(Long.toString(total));

                //kuantitas produk yang dibeli
                result.add(rs.getString("quantity"));
                //harga satuan produk (harga 1 produk, BUKAN TOTAL)
                result.add(rs.getString("harga"));
                //penjual (siapa yang menjual produk)
                result.add(rs.getString("seller"));
                //nama pembeli (nama sendiri)
                result.add(rs.getString("buyer_name"));
                //alamat pembeli (alamat sendiri)
                result.add(rs.getString("buyer_address"));
                //kode pos pembeli
                result.add(rs.getString("postal_code"));
                //no. hp pembeli
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
    /**
     * This is a sample web service operation
     */
    @WebMethod(operationName = "validateAccessToken")
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
