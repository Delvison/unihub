// @author Delvison
package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;

public class CommentServlet extends HttpServlet{ 
  
  HttpSession session;
  
  protected void doGet(HttpServletRequest req,
  HttpServletResponse res) throws ServletException, IOException {
    session = req.getSession(); /* get current session */	
      /* get the username */
    CommentObj cmt = CommentObj.create();
    String userName="";
    try{
      userName = (String)session.getAttribute("username");
      String comment = req.getParameter("comment"); 
      String currentItem = req.getParameter("itemId"); 
      if (comment == null || userName.equals("")){
        res.sendRedirect("sorry");
      }else{
        cmt.addComment(userName,comment,Integer.parseInt(currentItem));
        res.sendRedirect("item?id="+currentItem);
      }
    }catch(NullPointerException e){
      res.sendRedirect("sorry");    
    }
  }
}
