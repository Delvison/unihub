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


public class ValidateUserServlet extends HttpServlet {

  HttpSession session;
 
  public void doGet(HttpServletRequest req, 
    	 HttpServletResponse res) throws ServletException, IOException {
   
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
    /* the request only has the username so i set a dummy password
    to pass validation granted that a user is logged in */
    String password = "dummyPass";
    /* call Andy's method */
    Boolean login = AuthUtilities.authenticate(userName, password);

    if(login == true) {
      /* if logged in, send user to intended location */
      res.sendRedirect(whereTo.replaceFirst("/", ""));
    } else{
      /* if not logged in, send to login page */
      res.sendRedirect("sorry");
    } 
  }
}
