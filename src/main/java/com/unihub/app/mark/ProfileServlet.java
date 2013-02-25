package com.unihub.app;

import java.io.*;
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
User user = (User)session.getAttribute("user");
//if( user == null ) res.sendRedirect("login");

res.setContentType("text/html");
PrintWriter out = res.getWriter();
String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";

out.println(
  "<html>\n" +
  "<body>\n" +
  "<a href='home'>Home</a>|<a href='viewalllistings'>Listings</a><hr>" +
  user.getName() + "<br/>\n" +
  user.getSchool() + "<br/>\n" +
  "</body>" +
  "</html>"
  );

}

}
