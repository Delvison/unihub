// @author Delvison
/* This servlet processes bids for individual listings. */
package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.*;

public class BidServlet extends HttpServlet {
  @EJB
  BidEJB b;
  protected void doGet(HttpServletRequest req,
  HttpServletResponse res) throws ServletException, IOException {
        
    try{
      //get attributes from the request 
      String userName = req.getParameter("userName");
      String bidPrice = req.getParameter("bidPrice"); 
      String currentItem = req.getParameter("itemId"); 

      //if the username = null, display error. redirect to login.
      if (userName.equals("null") || userName == null){
        res.sendRedirect("sorry");    
      } else {
        //b.placeBid(Integer.parseInt(currentItem),userName,bidPrice);
        res.sendRedirect("item?id="+currentItem);
      }
    }catch(NumberFormatException e){
      PrintWriter out = res.getWriter();
      out.print("DEBUG:::: Invalid bid. Either null or it wasn't numbers.");      
    }catch (RuntimeException ex){
      //DISPLAY AN ERROR PAGE (STILL NEED ONE)
      PrintWriter out = res.getWriter();
      out.print("DEBUG:::: bid lower than current price or owner of item attempting to bid");
    }
  }
}