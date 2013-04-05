/* This servlet takes a photo's filepath from a GET 
and then removes the photo that is at that path. */

// @author Delvison

package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class RemovePhotoServlet extends HttpServlet {
 
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
    String rmFile = req.getParameter("dir");
    //String itemId = (String)req.getAttribute("id");   
    File rm = new File(rmFile);
    //File.delete(rmFile);
    rm.delete();
    String[] getId = rmFile.split("/");
    String itemId = getId[getId.length-2];
    res.sendRedirect("uploadPhoto?id="+itemId+"&msg=removed");
  }
}