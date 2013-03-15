package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;


@WebServlet("/user")
public class UserServlet extends HttpServlet {

HttpSession session;

@Override
public void doGet(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  session = req.getSession();
  String u_id = req.getParameter("u_id");
  String curruname = ((User)session.getAttribute("user")).getName();
  Dbase ubase = Dbase.create();
  res.setContentType("text/html");
  String address;

  if( u_id.equals("all") ) {
    address = "mark/allusers.jsp";
  }else if(ubase.getUser(Integer.parseInt(u_id)).getName().equals(curruname)) {
    address = "mark/profile.jsp";
  }else {
    address = "mark/user.jsp";
  }

  RequestDispatcher dispatcher = req.getRequestDispatcher(address);
  dispatcher.forward(req, res);
}

}
