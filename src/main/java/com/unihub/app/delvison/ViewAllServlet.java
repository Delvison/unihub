package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ViewAllServlet extends HttpServlet {

   static String PAGE_HEADER = "<html><head><title>LISTINGS</title><body>";
   static String PAGE_FOOTER = "</body></html>";
      
  public void doGet(HttpServletRequest req, 
    	 HttpServletResponse res) throws ServletException, IOException {
    
    Listings lis = Listings.create();
    int amount = lis.stuffs.size();
    
    PrintWriter out = res.getWriter();	
    out.println(PAGE_HEADER); 
    out.println("<h1>All Listings</h1>"); 
    
    for (int i = 0; i < amount; i++){
      Stuff a = lis.stuffs.get(i);
      String contents = a.getContent();
      out.println("<li>"+contents);
    }
    out.println("<hr>");
    String h = "<a href="+"home"+">home</a>";
    String a = "<a href="+"createpost"+">Create a listing</a>";
    out.print(h+" | ");
    out.print(a);
    out.println(PAGE_FOOTER); 
  }
}
