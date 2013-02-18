package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ListingsServlet extends HttpServlet {

 
  public void doGet(HttpServletRequest req, 
    	 HttpServletResponse res) throws ServletException, IOException {

    String user = "user1";
    //String user = req.getParameter("user");
    String name = req.getParameter("name");
    String price = req.getParameter("price");
    String university = req.getParameter("university");
    String loc = req.getParameter("location");
    

    Listings lis = Listings.create();
    lis.addStuff(user,name,price,university,loc);
   

    res.sendRedirect("viewalllistings");
 
    PrintWriter out = res.getWriter();	
    out.println("<h1>doing stuff</h1>");

  }
}


