// @author Delvison
/* this servlet processes comments posted
for individual listings */

//comments are currently kept in CommentObj's Arraylist

package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.*;

public class CommentServlet extends HttpServlet{ 
  @EJB 
  CommentEJB coms;
  HttpSession session;
  @EJB 
  ActivityEJB activityManager;

  
  protected void doGet(HttpServletRequest req,
  HttpServletResponse res) throws ServletException, IOException {
    session = req.getSession(); /* get current session */	

    String comment = req.getParameter("comment"); 
    String currentItem = req.getParameter("itemId"); 
    /* get the username from session */    
    String userName="";
    try{
      userName = (String)session.getAttribute("username");
      if (userName.equals("")){
        res.sendRedirect("sorry");
      }
      if (comment == null||comment.equals("")){
        //if the comment is null, dont add it.
        res.sendRedirect("item?id="+currentItem);
      }else{
        //add comment and redirect to same listing
        coms.addComment(userName,comment,Integer.parseInt(currentItem));
        //activityManager.createActivity(Integer.parseInt(currentItem), userName, 1);
        res.sendRedirect("item?id="+currentItem);
      }
    }catch(NullPointerException e){
      //if username is null, redirect.
      res.sendRedirect("sorry");    
    }
  }
}
