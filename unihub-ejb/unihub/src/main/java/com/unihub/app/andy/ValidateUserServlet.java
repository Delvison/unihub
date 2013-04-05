/*
**INFO:
**This servlet can be used to validate whether or 
**not the user is logged in.
**To use, direct a link to this servlet and append **your intended location to the where parameter.
**
**Example -- localhost:8080/unihub/validate?where=home
*/

package com.unihub.app;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;


@WebServlet("/validate")
public class ValidateUserServlet extends HttpServlet {

  HttpSession session;
 
  public void doGet(HttpServletRequest req, HttpServletResponse res) 
  throws ServletException, IOException {
   
    /* get the intended location */	 
    String whereTo = req.getParameter("where");
    
    session = req.getSession(); /* get current session */	
    session.setAttribute("path_for_login", whereTo);

    /* Use Andy's validation to ensure user is logged in */
    String userName;
    try{
      userName = (String)session.getAttribute("username");
    }catch(NullPointerException e){
      userName = "";
    }
    
    /*
    Realized there is no need to authenticate all over again.
    Like Alex said, we need to check whatever flag we have to see
    if a user was ever successfully logged on to just direct them straight to wherever
    they need to go. In our case the only way a userName
    would ever be present would be if they were successfully logged in already
    and hence le flag!*/

    if(userName != null && !userName.equals("")) {
      /* if logged in, send user to intended location */
      res.sendRedirect(whereTo.replaceFirst("/", ""));
    } else{
      /* if not logged in, send to login page */
      res.sendRedirect("sorry");
    } 


  }//end of doGetMethod

}//end of class
