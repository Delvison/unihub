/* Delvison ################################################################# */

/*
This servlet takes the info passed in from createpost.jsp and 'creates' a listing object
*/

package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ListingsServlet extends HttpServlet {

  HttpSession session;
 
  public void doGet(HttpServletRequest req, 
    	 HttpServletResponse res) throws ServletException, IOException {
    	 
    session = req.getSession(); /* get current session */	

    /* get the username */
    String userName="";
    try{
      userName = (String)session.getAttribute("username");
    }catch(NullPointerException e){
      res.sendRedirect("login");
    }
    
    String name = req.getParameter("name"); /* get name of item */
    String price = req.getParameter("price"); /* get price */
    String university = req.getParameter("university"); /* get university */
    String loc = req.getParameter("location"); /* get location */
    String cat = req.getParameter("category"); /* get category */
    String desc = req.getParameter("description"); /* get description */
    boolean bid; 
    
    /* determine whether or not bid mode was selected */
    if (req.getParameter("bid") != null){
      bid = true;
    }else{
      bid = false;
    }
    
    //String timeNow = new java.util.Date().toString();
    ListingsObj lis = ListingsObj.create();
    if(name == null || university == null || loc ==null ||userName==null){
      /* for now. need an error message for future though */
      res.sendRedirect("sorry");
    }else{
      lis.addStuff(userName,name,price,university,loc);
      res.sendRedirect("viewalllistings");
    }
  }
}
