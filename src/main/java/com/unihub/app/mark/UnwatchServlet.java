package com.unihub.app;

import java.io.*;                                                                    
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/unwatch")
public class UnwatchServlet extends HttpServlet {
                                          
HttpSession session;

@Override
public void doPost(HttpServletRequest req,
                  HttpServletResponse res)    
    throws ServletException, IOException {                          

  session = req.getSession();
  Dbase ubase = Dbase.create();
  res.setContentType("text/html");
  String watchedname = req.getParameter("watchname");                      
  User loggedin = (User)session.getAttribute("user");
  ubase.getUser(loggedin.getName()).unwatch(watchedname);
  res.sendRedirect("user?u_id=" + ubase.getUser(watchedname).getId());
//  address = "home";
  
//  RequestDispatcher dispatcher = req.getRequestDispatcher(address);
//  dispatcher.include(req, res);                                   
}   
  
} 
