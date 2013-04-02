// @author Delvison
/* this servlet processes comments posted
for individual listings */

//comments are currently kept in CommentObj's Arraylist

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

    CommentObj cmt = CommentObj.create();
    String comment = req.getParameter("comment"); 
    String currentItem = req.getParameter("itemId"); 
    /* get the username from session */    
    String userName="";
    try{
      userName = (String)session.getAttribute("username");
      if (userName.equals("")){
        res.sendRedirect("sorry");
      }else{
        //add comment and redirect to same listing
        cmt.addComment(userName,comment,Integer.parseInt(currentItem));
        res.sendRedirect("item?id="+currentItem);
      }
    }catch(NullPointerException e){
      //if username is null, redirect.
      res.sendRedirect("sorry");    
    }
  }
}