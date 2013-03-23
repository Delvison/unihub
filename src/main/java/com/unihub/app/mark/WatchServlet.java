package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/watch")
public class WatchServlet extends HttpServlet {

HttpSession session;

@Override
public void doPost(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  PrintWriter out = res.getWriter();
  session = req.getSession();
  Dbase ubase = Dbase.create();
  res.setContentType("text/html");
  String watchedname = req.getParameter("watchname");
  User loggedin = ubase.getUser(((User)session.getAttribute("user")).getName());
  if( loggedin.isWatching(watchedname) ) {
    loggedin.unwatch(watchedname);
  } else {
    loggedin.watch(watchedname);
  }
  String address = "user?u_id=" + ubase.getUser(watchedname).getId();
  res.sendRedirect(address);
}

}
