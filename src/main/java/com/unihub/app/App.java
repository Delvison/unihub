package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

//@WebServlet("/")
public class App extends HttpServlet
{
    public void doGet(HttpServletRequest req, 
    	HttpServletResponse res) throws ServletException, IOException {

    	PrintWriter out = res.getWriter();
    	out.println("Hello Bitches... again");


    }//end of method


}//end of class
