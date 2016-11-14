/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author cmrudi
 */
@WebServlet(urlPatterns = {"/PurchaseServlet"})
public class PurchaseServlet extends HttpServlet {
    //JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd_IS?zeroDateTimeBehavior=convertToNull";

    //  Database credentials
    static final String USER = "cmrudi";
    static final String PASS = "takengon";
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String responseText = "ttt";
        String access_token = request.getParameter("access_token");
            
        // Execute SQL query
        String sql;
        try{
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            sql = "SELECT username FROM user_authentication WHERE access_token = ?";
            
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,access_token);
            ResultSet rs = pre.executeQuery();
            String id;
            String username;
            if (rs.next()) {            
                username = rs.getString("username");
                
                String sql2 = "SELECT full_name,email,full_address,postal_code,phone_number FROM user_data WHERE username = ?";
                PreparedStatement pre2 = conn.prepareStatement(sql2);
                pre2.setString(1,username);
                ResultSet rs2 = pre2.executeQuery();
                String full_name = "";
                String email = "";
                String full_address = "";
                String postal_code = "";
                String phone_number = "";
                if (rs2.next()) {
                    full_name = rs2.getString("full_name");
                    email = rs2.getString("email");
                    full_address = rs2.getString("full_address");
                    postal_code = rs2.getString("postal_code");
                    phone_number = rs2.getString("phone_number");
                }
                responseText = username + "-" + full_name + '-' + email + "-" + full_address + "-" + postal_code + "-" + phone_number;
                
                response.setStatus(HttpServletResponse.SC_OK);
                response.getWriter().write(responseText);
                response.getWriter().flush();
                response.getWriter().close();
            }
            else {
                String message = "Please login, your token is invalid";
                response.sendRedirect("http://localhost:8080/JuraganDiskon/index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
            }
            
            
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
          
        } //end try
        
            
        
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
