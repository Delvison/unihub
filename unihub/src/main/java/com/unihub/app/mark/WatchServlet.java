package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.naming.*;
import javax.ejb.*;

@WebServlet("/watch")
public class WatchServlet extends HttpServlet {

@EJB
UserStatefulBI usr;
HttpSession session;

@Override
public void doPost(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

  PrintWriter out = res.getWriter();
  session = req.getSession();
  res.setContentType("text/html");
  String watchedname = req.getParameter("watchname");
  String sessionuname = (String)session.getAttribute("username");
  if( usr.isWatching(sessionuname, watchedname) ) {
    usr.unwatch(sessionuname, watchedname);
  } else {
    usr.watch(sessionuname, watchedname);
  }
  String address = "user?u_id=" + usr.getId(watchedname);
  res.sendRedirect(address);
}

}
