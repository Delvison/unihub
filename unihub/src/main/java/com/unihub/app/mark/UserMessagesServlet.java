package com.unihub.app;

import java.io.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/usermessages")
public class UserMessagesServlet extends HttpServlet {

HttpSession session;

@Override
public void doGet(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  session = req.getSession();
  String address = "";
  res.setContentType("text/html");

  if( session.getAttribute("username") == null ) {
    res.sendRedirect("index");
  }else {
    address = "mark/usermessages.jsp";
    RequestDispatcher dispatcher = req.getRequestDispatcher(address);
    dispatcher.include(req, res);
  }

} 

}
