package com.unihub.app;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class HomeServlet extends HttpServlet {
  public String[] getLosCookies(HttpServletRequest request)
  throws ServletException{
    String[] vals;
    String cookieName = "school&state";
    Cookie cookies [] = request.getCookies ();
    Cookie myCookie = null;
    if (cookies != null){
      for (int i = 0; i < cookies.length; i++){
        if (cookies [i].getName().equals (cookieName)){
          myCookie = cookies[i];
          break;
        }
      }
    }
    String temp = myCookie.getValue();
    vals = temp.split("&");
    return vals;
    }
}
