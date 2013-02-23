/* Delvison ################################################################# */

/*
This servlet takes the info passed in from createpost.jsp and 'creates' the a 
listing object
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

    String userName="";
    try{
      userName = (String)session.getAttribute("username");
    }catch(NullPointerException e){
      res.sendRedirect("login");
    }
    
    //String user = req.getParameter("user");
    String name = req.getParameter("name");
    String price = req.getParameter("price");
    String university = req.getParameter("university");
    String loc = req.getParameter("location");
    

    Listings lis = Listings.create();
    lis.addStuff(userName,name,price,university,loc);
   

    res.sendRedirect("viewalllistings");
 
  }
}


