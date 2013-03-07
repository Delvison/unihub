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
  User newbie = new User(req.getParameter("name"),
                         req.getParameter("password"),
                         req.getParameter("email")+".edu",
                         "Oswego");
  usersbase.addUser(newbie);
  //not yet implemented
  //sendConfirmationEmail(newbie);
  out.println( "A User was Created" );
  res.sendRedirect("home");

}

}
