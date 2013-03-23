package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;



public class BidServlet extends HttpServlet {
  
  protected void doGet(HttpServletRequest req,
  HttpServletResponse res) throws ServletException, IOException {
    ListingsObj lis = ListingsObj.create();
    String userName="";
    
    try{ //Nullpointer if no user is logged in
      userName = req.getParameter("userName");
      String bidPrice = req.getParameter("bidPrice"); 
      String currentItem = req.getParameter("itemId"); 

      if (bidPrice.equals("") || bidPrice == null || userName.equals("") || userName == null){
        res.sendRedirect("item?id"+currentItem);
      }
      
      String oldPrice = lis.getStuff(Integer.parseInt(currentItem)).getPrice();

      if (!userName.equals(lis.getStuff(Integer.parseInt(currentItem)).getUser()) && 
        (Integer.parseInt(bidPrice) > Integer.parseInt(oldPrice))){
        lis.getStuff(Integer.parseInt(currentItem)).bid(userName, bidPrice);
        res.sendRedirect("item?id="+currentItem);
      }

      else{
        //give some warning because either the user who owns the
        //item is attempting to bid on it or the bid is not higher
        //than the current price
        PrintWriter out = res.getWriter();
        out.print("DEBUG:::: bid lower than current price or owner of item attempting to bid");
      }
    }catch(NullPointerException e){
      res.sendRedirect("sorry");    
    }
  }
}