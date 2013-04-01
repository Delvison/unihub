// @author Delvison
/* This servlet processes bids for individual listings. */
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
      //get attributes from the request 
      String userName = req.getParameter("userName");
      String bidPrice = req.getParameter("bidPrice"); 
      String currentItem = req.getParameter("itemId"); 

      //if the username = null, display error. redirect to login.
      if (userName.equals("null") || userName == null){
        res.sendRedirect("sorry");    
      } else {
        //else, get the old price from the Stuff object so that we can compare
        //with the bid that was inputted.
        oldPrice = lis.getStuff(Integer.parseInt(currentItem)).getPrice();
      }
      
      //if the user logged in != the user that owns the listing &&
      //the inputted bid value > the oldPrice 
      if (!userName.equals(lis.getStuff(Integer.parseInt(currentItem)).getUser()) && 
        (Integer.parseInt(bidPrice) > Integer.parseInt(oldPrice))){
        //place the bid (Stuff.bid(user,bidprice))
        lis.getStuff(Integer.parseInt(currentItem)).bid(userName, bidPrice);
        //redirect back to the item that was just bid on
        res.sendRedirect("item?id="+currentItem);
      } else {
        //DISPLAY AN ERROR PAGE (STILL NEED ONE)
        PrintWriter out = res.getWriter();
        out.print("DEBUG:::: bid lower than current price or owner of item attempting to bid");
      }
    }catch(NumberFormatException e){
      PrintWriter out = res.getWriter();
      out.print("DEBUG:::: Invalid bid. Either null or it wasn't numbers.");    
    }
  }
}