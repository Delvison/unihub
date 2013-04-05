// @author Delvison
/*
this servlet is used to create a cookie that holds the value of 
location inputted by the user
*/

package com.unihub.app;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class LocationServlet extends HttpServlet {

 
  public void doPost(HttpServletRequest req, 
    	 HttpServletResponse res) throws ServletException, IOException {
    	 
	String school=req.getParameter("school");
	String state=req.getParameter("state");
	String university=req.getParameter("university");
	String both = school+"&"+state;

	Cookie cookie = new Cookie ("school&state",both);
	cookie.setMaxAge(365 * 24 * 60 * 60);
	res.addCookie(cookie);
	
	res.sendRedirect("home");
  }
}
