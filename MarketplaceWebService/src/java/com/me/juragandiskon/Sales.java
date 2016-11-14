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
@WebService(serviceName = "Sales")
public class Sales {
    static final int CATALOG_LENGTH = 100;
    static final String NULL_STRING = "*";
    
    //JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd_MP?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "cmrudi";
    static final String PASS = "takengon";
    static final String USER_AGENT = "Mozilla/5.0";
    
    @WebMethod(operationName = "getSales")
    public ArrayList<String> getSales(@WebParam(name = "access_token") String access_token) throws IOException {
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
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            // Execute SQL query
            Statement stmt = conn.createStatement();
            String quer;
            quer = "SELECT * FROM product, purchase_data WHERE product.product_id = purchase_data.product_id AND product.username = ?";
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
                //waktu : hari, tanngal bulan tahun
                result.add(rs.getString("timestamp"));
                //gambar produk
                result.add(rs.getString("image_address"));
                //nama produk
                result.add(rs.getString("product_name"));
                //harga total

                //kalkulasi
                satuan = rs.getString("price");
                kuantitas = rs.getString("quantity");
                total = new Long(Integer.valueOf(satuan)*Integer.valueOf(kuantitas));

                //add to result
                result.add(Long.toString(total));

                //kuantitas barang
                result.add(rs.getString("quantity"));
                //harga satuan
                result.add(rs.getString("price"));
                //username pembeli
                result.add(rs.getString("username"));
                //nama pembeli
                result.add(rs.getString("buyer_name"));
                //alamat pembeli
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
