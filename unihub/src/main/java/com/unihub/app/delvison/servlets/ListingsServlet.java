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
  @EJB static ListingObjEJB lis;
  HttpSession session;
 
  public void doGet(HttpServletRequest req, HttpServletResponse res)
    throws ServletException, IOException {

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
  
        if (name == null || university == null ||userName==null||desc==null){
          /* for now. need an error message for future though */
          res.sendRedirect("sorry");
        }else{
          int currentId = lis.addStuff(userName,name,price,university,loc,cat,desc,bid);
          int picAmount = lis.getPicAmount(currentId);
          res.sendRedirect("uploadPhoto?id="+Integer.toString(currentId)+
             "&amnt="+Integer.toString(picAmount));
        }
      }else{
      /*EDIT THE LISTING */
      lis.updateContent(Integer.parseInt(itemId), name, price, university, loc, cat, desc, bid);
      res.sendRedirect("item?id="+itemId);
      }
  }
}
