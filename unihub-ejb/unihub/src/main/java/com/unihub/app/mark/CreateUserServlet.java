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

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@WebServlet("/createuser")
public class CreateUserServlet extends HttpServlet {

HttpSession session;

@Override
public void doPost(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  session = req.getSession();
  Dbase usersbase = Dbase.create();
  res.setContentType("text/html");
  PrintWriter out = res.getWriter();

  /*
  Andy's methods for encrypting a password
  */
  byte[] salt = null;
  byte[] encryptedPassword = null;
  try {
    salt = AuthUtilities.generateSalt();
    encryptedPassword = AuthUtilities.getEncryptedPassword(req.getParameter("password"), salt);
  }
  catch(NoSuchAlgorithmException e) {}
  catch(InvalidKeySpecException e) {}


  User newbie = new User(req.getParameter("username"),
                         encryptedPassword,
                         req.getParameter("email")+".edu",
                         req.getParameter("school"),
                         salt);
  usersbase.addUser(newbie);
  //not yet implemented
  //sendConfirmationEmail(newbie);
  out.println( "A User was Created" );
  res.sendRedirect("home");

}

}
