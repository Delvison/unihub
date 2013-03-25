package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/reputation")
public class RepServlet extends HttpServlet{

  HttpSession session;
  @Override
  protected void doGet(HttpServletRequest req,
  HttpServletResponse res) throws ServletException, IOException {
    session = req.getSession(); /* get current session */
    ListingsObj listings = ListingsObj.create();
    Dbase ubase = Dbase.create();
      /* get the username */
    String userName="";
    try{
      userName = (String)session.getAttribute("username");
      Stuff currentItem = listings.getStuff(Integer.parseInt(req.getParameter("itemId")));
      User user = ubase.getUser(userName);
      User itemUser = ubase.getUser(currentItem.getUser());
      if (userName.equals(null)){
        res.sendRedirect("validate?where=item?id="+currentItem.getId());
      }else{
        itemUser.incRep();
        user.addToVoted((Integer)currentItem.getId()); 
        res.sendRedirect("item?id="+currentItem.getId());
      }
    }catch(NullPointerException e){
      res.sendRedirect("sorry");
    }
  }
}

