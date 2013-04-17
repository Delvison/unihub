package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.naming.*;
import javax.ejb.*;

@WebServlet("/user")
public class UserServlet extends HttpServlet {

@EJB
UserStatefulBI usr;
HttpSession session;

@Override
public void doGet(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  session = req.getSession();
  String u_id = "", address = "", curruname = "";
  res.setContentType("text/html");
  u_id = req.getParameter("u_id");

  if( (String)session.getAttribute("username") != null ) {
    curruname = (String)session.getAttribute("username");
  }

  if( u_id == null ) {
    address = "index";
  }else if( u_id.equals("all") ) {
    address = "mark/allusers.jsp";
  }else if( usr.getName(Integer.parseInt(u_id)).equals(curruname) &&
              (curruname != "") ) {
    address = "profile";
  }else {
    address = "mark/user.jsp";
  }
  
  RequestDispatcher dispatcher = req.getRequestDispatcher(address);
  dispatcher.include(req, res);
}

}
