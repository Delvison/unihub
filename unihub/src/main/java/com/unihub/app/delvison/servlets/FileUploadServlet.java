// @author Delvison
/*
This servlet is meant for handling File Uploads
specifically jpg and png
it was made by following this tutorial:
http://docs.oracle.com/javaee/6/tutorial/doc/glraq.html

@author Delvison
*/

package com.unihub.app;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.logging.*;

import javax.servlet.annotation.WebServlet;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.ServletException;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.EJB;

@WebServlet(name = "FileUploadServlet", urlPatterns = { "/upload" })
@MultipartConfig /* tells servlet to expect requests made up of 
                                 multipart/form-data MIME type*/
public class FileUploadServlet extends HttpServlet {
  @EJB
  ListingObjEJB lis;

  private final static Logger LOGGER = 
            Logger.getLogger(FileUploadServlet.class.getCanonicalName());
  private String image_url;
  HttpSession session;

     
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    response.setContentType("text/html;charset=UTF-8");
    /* get current session */ 
    session = request.getSession(); 
    //get the listings' id
    String itemId = request.getParameter("id");

    /* get the username */
    String userName="";
    try{
        userName = (String)session.getAttribute("username");
    }catch(NullPointerException e){
        response.sendRedirect("sorry");
    }
    if (userName == null){
      response.sendRedirect("sorry");
    }else if(!userName.equals(lis.getUser(Integer.parseInt(itemId)))){
      response.sendRedirect("uploadPhoto?id="+itemId+"&msg=error");
    }else{
      //set up image url
      image_url = "/listings/"+itemId;
      //get relative path
      String path = request.getSession().getServletContext().getRealPath(image_url);
      //get Part from POST
      final Part filePart = request.getPart("file");
      //get filename from path (also from POST)
      final String fileName = getFileName(filePart);

      // Check for .jpg or .png extension
      String extension = "";
      int i = fileName.lastIndexOf('.');
      if (i > 0) {
        extension = fileName.substring(i+1);
      }

      /* CHECK FOR VALIDITY HERE */
        //has to be jpg | png && Listing must have < 4 photos
      if (extension.equals("jpg")||extension.equals("png")){
        if (lis.getPicAmount(Integer.parseInt(itemId)) < 4){

          //check if dir already exists
          File chkDir = new File(path);
          lis.setDir(Integer.parseInt(itemId),path);
          if (!chkDir.exists()){
            //create dir
            chkDir.mkdir();
          }
          //declare outputstream
          OutputStream out = null;
          //declare inputstream
          InputStream filecontent = null;
          try {
            out = new FileOutputStream(new File(path + File.separator + fileName));
            filecontent = filePart.getInputStream();
            int read = 0;
            final byte[] bytes = new byte[1024];
          
            while ((read = filecontent.read(bytes)) != -1) {
              out.write(bytes, 0, read);
            }
            /* ##FILE UPLOAD SUCCESS HERE## */
            // ADD 1 to the item's picture amount upon success
            lis.setPicAmount(Integer.parseInt(itemId));
            LOGGER.log(Level.INFO, "File{0}being uploaded to {1}", new Object[]{fileName, path});
            response.sendRedirect("uploadPhoto?id="+itemId+"&msg=success");
          } catch (FileNotFoundException fne) {
            response.sendRedirect("uploadPhoto?id="+itemId+"&msg=error");
            LOGGER.log(Level.SEVERE, "Problems during file upload. Error: {0}", 
            new Object[]{fne.getMessage()});
          } finally {
            if (out != null) {
              out.close();
            }
            if (filecontent != null) {
              filecontent.close();
            }
          }
        } else {
          /* ELSE, 4 pictures exist aleady for item */
          response.sendRedirect("uploadPhoto?id="+itemId+"&msg=limit");
        }
      }else{            
        response.sendRedirect("uploadPhoto?id="+itemId+"&msg=error");
      }  
    }
  }

  private String getFileName(final Part part) {
    final String partHeader = part.getHeader("content-disposition");
    LOGGER.log(Level.INFO, "Part Header = {0}", partHeader);
    for (String content : part.getHeader("content-disposition").split(";")) {
        if (content.trim().startsWith("filename")) {
            return content.substring(
                    content.indexOf('=') + 1).trim().replace("\"", "");
        }
    }
    return null;
  }
}
