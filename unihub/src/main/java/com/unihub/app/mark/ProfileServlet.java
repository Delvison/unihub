package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.naming.*;
import javax.ejb.*;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

@EJB
UserStatefulBI usr;
HttpSession session;

@Override
public void doGet(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  session = req.getSession();
  String uname = "";
  if( session.getAttribute("username") != null ) {
     uname = (String)session.getAttribute("username");
  }
  res.setContentType("text/html");
  PrintWriter out = res.getWriter();
  String address;
  
  if( usr.getUser(uname) == null ) {
    address = "/login?url=/profile";
  }else {
    address = "mark/profile.jsp";
  }

  RequestDispatcher dispatcher = req.getRequestDispatcher(address);
  dispatcher.include(req, res);
} 

}
