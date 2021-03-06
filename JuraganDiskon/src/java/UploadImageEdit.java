/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import com.me.juragandiskon.EditProduct_Service;
import com.me.juragandiskon.IOException_Exception;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Paths;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.ws.WebServiceRef;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author cmrudi
 */
@WebServlet(urlPatterns = {"/UploadImageEdit"})
public class UploadImageEdit extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8081/MarketplaceWebService/EditProduct.wsdl")
    private EditProduct_Service service;

    
    private static final long serialVersionUID = 1L;
     
    // location to store file uploaded
    private static final String UPLOAD_DIRECTORY = "img";
 
    // upload settings
    private static final int MEMORY_THRESHOLD   = 1024 * 1024 * 3;  // 3MB
    private static final int MAX_FILE_SIZE      = 1024 * 1024 * 40; // 40MB
    private static final int MAX_REQUEST_SIZE   = 1024 * 1024 * 50; // 50MB


    
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
            throws ServletException, IOException, FileUploadException, IOException_Exception {
        // Check that we have a file upload request
        PrintWriter writer = response.getWriter();
        String productName = "";
        String description = "";
        String price = "";
        String pictureName = "";
        String productId = "";
        
        Cookie cookie = null;
        Cookie[] cookies = null;
        String selectedCookie = "";
        // Get an array of Cookies associated with this domain
        cookies = request.getCookies();
        if( cookies != null ){
           for (int i = 0; i < cookies.length; i++){
              cookie = cookies[i];
              if (cookie.getName().equals("JuraganDiskon")) {
                  selectedCookie = cookie.getValue();
              }
           }
       }else{
           writer.println("<h2>No cookies founds</h2>");
       }
        

        
        
        if (!ServletFileUpload.isMultipartContent(request)) {
            // if not, we stop here
            
            writer.println("Error: Form must has enctype=multipart/form-data.");
            writer.flush();
            return;
        }
 
        // configures upload settings
        DiskFileItemFactory factory = new DiskFileItemFactory();
        // sets memory threshold - beyond which files are stored in disk
        factory.setSizeThreshold(MEMORY_THRESHOLD);
        // sets temporary location to store files
        factory.setRepository(new File(System.getProperty("java.io.tmpdir")));
 
        ServletFileUpload upload = new ServletFileUpload(factory);
         
        // sets maximum size of upload file
        upload.setFileSizeMax(MAX_FILE_SIZE);
         
        // sets maximum size of request (include file + form data)
        upload.setSizeMax(MAX_REQUEST_SIZE);
        
            
        // constructs the directory path to store upload file
        // this path is relative to application's directory
        String uploadPath = new File(new File(getServletContext().getRealPath("")).getParent()).getParent() + "/web/" + UPLOAD_DIRECTORY;
         
        // creates the directory if it does not exist
        File uploadDir = new File(uploadPath);
        if (!uploadDir.exists()) {
            uploadDir.mkdir();
        }
        
        try {
            // parses the request's content to extract file data
            @SuppressWarnings("unchecked")
            List<FileItem> formItems = upload.parseRequest(request);
            
            if (formItems != null && formItems.size() > 0) {
                // iterates over form's fields
                int k = 0;
                for (FileItem item : formItems) {
                    // processes only fields that are not form fields
                    if (!item.isFormField()) {
                        k++;
                        writer.println("if = " + k);
                        
                        
                            String fileName = new File(item.getName()).getName();
                            pictureName = fileName;
                            String filePath = uploadPath + File.separator + fileName;
                            File storeFile = new File(filePath);

                            // saves the file on disk
                            item.write(storeFile);
                            request.setAttribute("message","Upload has been done successfully!");
                        writer.println("pictureName = " + pictureName);
                    }
                    else {
                        k++;
                        writer.println("else = " + k);
                        
                        // Get the field name
                        String fieldName = item.getName();
                        // Get the field value
                        String value = item.getString();
                        if (k == 0) {

                        }
                        else if (k == 1) {
                            productId = value.trim();
                            writer.println("productId = " +productId );
                        }
                        else if (k == 2) {
                            productName = value;
                            writer.println("productName = " +productName);
                        }
                        else if (k == 3) {
                            description = value;
                            writer.println("description = " +description);
                        }
                        else if (k == 4) {
                            price = value;
                            writer.println("price = " + price);
                        }
       
                    }
                 
                }
            }
            
        } catch (Exception ex) {
            request.setAttribute("message",
                    "There was an error: " + ex.getMessage());
        }
        String update = editTheProduct(Integer.valueOf(productId), productName, price, description, pictureName, selectedCookie);
        writer.println(update);
        
        //redirects client to message page
        getServletContext().getRequestDispatcher("/yourProduct.jsp").forward(request, response);
    
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException_Exception ex) {
            Logger.getLogger(UploadImageEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (FileUploadException ex) {
            Logger.getLogger(UploadImage.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException_Exception ex) {
            Logger.getLogger(UploadImageEdit.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    private String editTheProduct(int productId, java.lang.String productName, java.lang.String price, java.lang.String description, java.lang.String imageAddress, java.lang.String accessToken) throws IOException_Exception {
        // Note that the injected javax.xml.ws.Service reference as well as port objects are not thread safe.
        // If the calling of port operations may lead to race condition some synchronization is required.
        com.me.juragandiskon.EditProduct port = service.getEditProductPort();
        return port.editTheProduct(productId, productName, price, description, imageAddress, accessToken);
    }

    

   

    



}
