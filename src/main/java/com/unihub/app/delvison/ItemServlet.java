/* 
this servlet is meant for retrieving data on an item that was clicked in 
the listings page
*/

package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class ItemServlet extends HttpServlet {

  static String PAGE_HEADER = "<html><head></head><body>";
  static String PAGE_FOOTER = "</body></html>";
 
  public void doGet(HttpServletRequest req, 
    	 HttpServletResponse res) throws ServletException, IOException {
    /* get id from url */
    String id = (String)req.getParameter("id");
    int x = Integer.valueOf(id);
    /* get listingobj */
    ListingsObj lis = ListingsObj.create();
    /* find 'Stuff' by id */
    Stuff stuf = lis.getStuff(x);
    
    PrintWriter out = res.getWriter();
    out.println(PAGE_HEADER);
    out.print("Name: "+stuf.name);
    out.println("- "+stuf.price);
    out.println("<br>Owner:"+stuf.user);
    out.println("<br>University: "+stuf.university+ ", "+stuf.location);
    out.println(PAGE_FOOTER);
  }  
}
