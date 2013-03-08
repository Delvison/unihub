package com.unihub.app;

import java.math.BigInteger;
import java.io.*;
import java.security.*;
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

  res.setContentType("text/html");
  PrintWriter out = res.getWriter();
  String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
  String grav_url = "something";
  String address;
  
  if( user == null ) {
    address = "/login?url=/profile";
  }else {
    address = "mark/profile.jsp";
  }

  RequestDispatcher dispatcher = req.getRequestDispatcher(address);
  dispatcher.forward(req, res);
}

public String gravatar_for(User user) throws NoSuchAlgorithmException {
  String plaintext = user.getEmail();
  MessageDigest m = MessageDigest.getInstance("MD5");
  m.reset();
  m.update(plaintext.getBytes());
  byte[] digest = m.digest();
  BigInteger bigInt = new BigInteger(1,digest);
  String hashtext = bigInt.toString(16);
  // Now we need to zero pad it if you actually want the full 32 chars.
  while(hashtext.length() < 32 ){
    hashtext = "0"+hashtext;
  }
  return "http://www.gravatar.com/avatar/" + hashtext;
}


}
