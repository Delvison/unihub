package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.naming.*;
import javax.ejb.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet("/createuser")
public class CreateUserServlet extends HttpServlet {

@EJB
UserStatelessBI usr;
@EJB
Authenticate bean;
HttpSession session;

@Override
public void doPost(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  session = req.getSession();
  res.setContentType("text/html");
  PrintWriter out = res.getWriter();

  String uname = req.getParameter("username");
  String pass = req.getParameter("password");

  usr.createUser(uname,
                 pass,
                 req.getParameter("email")+".edu",
                 req.getParameter("school"));

  
  //not yet implemented
  //usr.sendConfirmationEmail();
  out.println( "A User was Created" );

  try {
  if(bean.authenticate(uname, pass)) {
    session.removeAttribute("path_for_login");
    session.setAttribute("username", uname);
    res.sendRedirect("index");
  }
  else res.sendRedirect("login"); 
  } catch(NoSuchAlgorithmException e) {}
    catch(InvalidKeySpecException e) {}
  

}

}
