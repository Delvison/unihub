package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/user")
public class UserServlet extends HttpServlet {

@Override
public void doGet(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  String u_id = req.getParameter("u_id");

  res.setContentType("text/html");
  String address;

  if( u_id.equals("all") ) {
    address = "mark/allusers.jsp";
  }else {
    address = "mark/user.jsp";
  }

  RequestDispatcher dispatcher = req.getRequestDispatcher(address);
  dispatcher.forward(req, res);
}

}
