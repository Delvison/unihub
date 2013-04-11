package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.naming.*;
import javax.ejb.*;

@WebServlet("/reputation")
public class RepServlet extends HttpServlet{

  @EJB
  UserStatefulBI usr;
  @EJB
  ListingObjEJBStateless lst;
  HttpSession session;

  @Override
  protected void doGet(HttpServletRequest req,
  HttpServletResponse res) throws ServletException, IOException {
    session = req.getSession(); /* get current session */
    ListingsObj listings = ListingsObj.create();
  
    /* get the username */
    String userName="";
    int itemId = 0;
    try{
      userName = (String)session.getAttribute("username");
      itemId = Integer.parseInt(req.getParameter("itemId"));
      String itemUserName = lst.getUser(itemId);
      User user = usr.getUser(userName);
      if (userName.equals(null)){
        res.sendRedirect("validate?where=item?id="+itemId);
      }else{
        usr.incRep(itemUserName);
        usr.addToVoted(userName, itemId); 
        res.sendRedirect("item?id="+itemId);
      }
    }catch(NullPointerException e){
      res.sendRedirect("sorry");
    }
  }
}

