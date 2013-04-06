// @author Delvison
/*
This servlet takes the info passed in from createpost.jsp and 
creates a listing object(Stuff.java)
*/

package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.Date;
import javax.naming.*;
import javax.ejb.*;


public class ListingsServlet extends HttpServlet {

  HttpSession session;
 
   
 
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {
HttpSession session;
        //CalculatorBean c= (CalculatorBean) InitialContext.lookup("java:global/unihub/CalculatorBean");
      String name = req.getParameter("name"); /* get name of item */
      String price = req.getParameter("price"); /* get price */
      String university = req.getParameter("university"); /* get university */
      String loc = req.getParameter("location"); /* get location */
      String cat = req.getParameter("category"); /* get category */
      String desc = req.getParameter("description"); /* get description */
      String bid = req.getParameter("bid"); 

    /* First, Check if the listing exist */
      String itemId = req.getParameter("id");

    if (itemId == null){
      /* CREATE LISTING */
  
      session = req.getSession(); /* get current session */	

      /* get the username */
      String userName="";
      try{
        userName = (String)session.getAttribute("username");
      }catch(NullPointerException e){
        res.sendRedirect("login");
      }
    
      //String timeNow = new java.util.Date().toString();
      ListingsObj lis = ListingsObj.create();
      if (name == null || university == null ||userName==null||desc==null){
        /* for now. need an error message for future though */
        res.sendRedirect("sorry");
      }else{
        Date now = new Date();
        int currentId = lis.addStuff(userName,name,price,university,loc,cat,desc,now,bid);
        res.sendRedirect("uploadPhoto?id="+Integer.toString(currentId));
      }
    }else{
      /*EDIT THE LISTING */
      Stuff found = this.getObj(itemId);
      found.updateContent(name, price, university, loc, cat, desc, bid);
      res.sendRedirect("item?id="+itemId);
    }
  }

  /* Checks whether or not the listing already exists */
  private boolean checkExist(String itemId){
    return false;
  }

  private Stuff getObj(String itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff found;
    found = lis.getStuff(Integer.parseInt(itemId));
    return found;
  }
}
