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
import java.sql.Statement;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmrudi
 */
@WebServlet(urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {
    static final String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
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
           
        String usernameOrEmail;
        String password;
        String output = "";
        
        String messagess = "empty";
        
        usernameOrEmail = request.getParameter("usernameOrEmail");
        password = request.getParameter("password"); 
        
        try{
            
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            // Execute SQL query
            String sql;
            String sqlUpdate;
            if (usernameOrEmail.matches(EMAIL_REGEX)) {
                sql = "SELECT password FROM user_authentication WHERE email= ?";
                sqlUpdate = "UPDATE user_authentication SET access_token = ? WHERE email = ?";
            }
            else {
                sql = "SELECT password FROM user_authentication WHERE username= ?";
                sqlUpdate = "UPDATE user_authentication SET access_token = ? WHERE username = ?";
            }
            PreparedStatement pre = conn.prepareStatement(sql);
            pre.setString(1,usernameOrEmail);
            ResultSet rs = pre.executeQuery();
            String pass = "";
            if (rs.next()) {            
                pass = rs.getString("password");
            }
            String message;
            if (pass.equals(password)) {
                String uuid = UUID.randomUUID().toString();
                PreparedStatement preId = conn.prepareStatement(sqlUpdate);
                preId.setString(1,uuid);
                messagess = uuid;
                preId.setString(2,usernameOrEmail);
                preId.executeUpdate();
                
                
                
                Cookie userCookie = new Cookie("JuraganDiskon", uuid);
                // setting cookie to expiry in 60 mins
                userCookie.setMaxAge(60 * 60);
                userCookie.setPath("/");
                response.addCookie(userCookie);
                response.sendRedirect("http://localhost:8080/JuraganDiskon/catalog.jsp");
                
            }
            else {
                message = "Username or password incorrect";
                response.sendRedirect("http://localhost:8080/JuraganDiskon/index.jsp?message=" + URLEncoder.encode(message, "UTF-8"));
            }  
            
            // Clean-up environment
            rs.close();
            conn.close(); 
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
          
        } //end try
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet LoginServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet LoginServlet at " + request.getContextPath() + "</h1>");
            out.println("<h1>Error Checking " + messagess + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
        
        
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
