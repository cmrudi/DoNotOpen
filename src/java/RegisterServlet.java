/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author cmrudi
 */
public class RegisterServlet extends HttpServlet {
    //JDBC driver name and database URL
    static final String JDBC_DRIVER="com.mysql.jdbc.Driver";  
    static final String DB_URL="jdbc:mysql://localhost:3306/tubes_wbd?zeroDateTimeBehavior=convertToNull";

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
        String fullname;
        String username;
        String email;
        String password;
        String fulladdress;
        String postalcode;
        String phonenumber;
        String message = "";
        String sql;
        
        
        fullname = request.getParameter("fullname");
        username = request.getParameter("username");
        email = request.getParameter("email");
        password = request.getParameter("password");
        fulladdress = request.getParameter("fulladdress");
        postalcode = request.getParameter("postalcode");
        phonenumber = request.getParameter("phonenumber");
        
        try{
            
            // Register JDBC driver
            Class.forName("com.mysql.jdbc.Driver");
            
            
            // Open a connection
            Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
            
            Statement stmt1 = conn.createStatement();
            sql = "SELECT username FROM user_authentication WHERE username = ?";
            PreparedStatement pres = conn.prepareStatement(sql);
            pres.setString(1,username);
            ResultSet rs = pres.executeQuery();
            if (!rs.next()) {
                Statement stmt2 = conn.createStatement();
                sql = "SELECT email FROM user_authentication WHERE email = ?";
                PreparedStatement pres2 = conn.prepareStatement(sql);
                pres2.setString(1,email);
                ResultSet rs2 = pres2.executeQuery();
                if (!rs2.next()) {
                    // Execute SQL query
                    Statement stmt3 = conn.createStatement();
                    sql = "INSERT INTO user_data (username,full_name,email,full_address,postal_code,phone_number) VALUES (?,?,?,?,?,?)";        
                    PreparedStatement pre = conn.prepareStatement(sql);
                    pre.setString(1,username);
                    pre.setString(2,fullname);
                    pre.setString(3,email);
                    pre.setString(4,fulladdress);
                    pre.setString(5,postalcode);
                    pre.setString(6,phonenumber);
                    pre.executeUpdate();

                    message = "Successfull";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/catalog.jsp").forward(request, response);
                    stmt3.close();
                }
                else {
                    message = "Email already in used";
                    request.setAttribute("message", message);
                    request.getRequestDispatcher("/register.jsp").forward(request, response);
                }
                stmt2.close();
            }
            else {
                message = "Username already in used";
                request.setAttribute("message", message);
                request.getRequestDispatcher("/register.jsp").forward(request, response);
            }
            stmt1.close();
            
            
            
   
            
            // Clean-up environment
            
            
            
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
            out.println("<title>Servlet IdentityService</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>usernameOrEmail " +fullname +"</h1>");
            out.println("<h1>password " +password +"</h1>");
            out.println("<h1>output :" + message +"</h1>");
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
