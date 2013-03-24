package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class BidServlet extends HttpServlet {
  
  protected void doGet(HttpServletRequest req,
  HttpServletResponse res) throws ServletException, IOException {
    ListingsObj lis = ListingsObj.create();
    String oldPrice="";
        
    try{ 
      String userName = req.getParameter("userName");
      String bidPrice = req.getParameter("bidPrice"); 
      String currentItem = req.getParameter("itemId"); 

      if (userName.equals("null") || userName == null){
        res.sendRedirect("sorry");    
      } else {
        oldPrice = lis.getStuff(Integer.parseInt(currentItem)).getPrice();
      }
      
      if (!userName.equals(lis.getStuff(Integer.parseInt(currentItem)).getUser()) && 
        (Integer.parseInt(bidPrice) > Integer.parseInt(oldPrice))){
        lis.getStuff(Integer.parseInt(currentItem)).bid(userName, bidPrice);
        res.sendRedirect("item?id="+currentItem);
      } else {
        //give some warning because either the user who owns the
        //item is attempting to bid on it or the bid is not higher
        //than the current price
        PrintWriter out = res.getWriter();
        out.print("DEBUG:::: bid lower than current price or owner of item attempting to bid");
      }
    }catch(NumberFormatException e){
      PrintWriter out = res.getWriter();
      out.print("DEBUG:::: Invalid bid. Either null or it wasn't numbers.");    
    }
  }
}