package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

HttpSession session;

@Override
public void doGet(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  session = req.getSession();
  Dbase ubase = Dbase.create();
  String uname = "";
  if( session.getAttribute("username") != null ) {
     uname = (String)session.getAttribute("username");
  }
  User user = ubase.getUser(uname);
  res.setContentType("text/html");
  PrintWriter out = res.getWriter();
  String address;
  
  if( user == null ) {
    address = "/login?url=/profile";
  }else {
    address = "mark/profile.jsp";
  }

  RequestDispatcher dispatcher = req.getRequestDispatcher(address);
  dispatcher.include(req, res);
} 

}