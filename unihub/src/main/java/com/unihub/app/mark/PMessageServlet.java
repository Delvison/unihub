package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.naming.*;
import javax.ejb.*;

@WebServlet("/message")
public class PMessageServlet extends HttpServlet {

@EJB
UserStatelessBI usr;
@EJB
MessageBI msg;
HttpSession session;

@Override
public void doPost(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  PrintWriter out = res.getWriter();
  session = req.getSession();
  String toName = req.getParameter("toName");
  String contents = req.getParameter("contents");
  String address = "";
  String fromName  = (String)session.getAttribute("username");
  Dbase ubase = Dbase.create();
  res.setContentType("text/html");
  User ownr = usr.getUser(fromName);
  msg.createMessage(ownr, fromName, toName, contents);
//  msg.addToReceived(toName);
//  msg.addToSent(fromName);

  res.sendRedirect( "user?u_id=" + ubase.getUser(toName).getId() );
}

}
