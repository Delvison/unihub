package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/message")
public class PMessageServlet extends HttpServlet {

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

  Message m = new Message(fromName, toName, contents);
  ubase.getUser(toName).addToRecieved(m);
  ubase.getUser(fromName).addToSent(m);

  res.sendRedirect( "user?u_id=" + ubase.getUser(toName).getId() );
}

}
