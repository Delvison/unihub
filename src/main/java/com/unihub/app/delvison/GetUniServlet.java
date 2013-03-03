/*
this servlet reads all universities from a text file and stores
them in an array list in a seperate java class (UniDefaults.java)
*/

package com.unihub.app;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

public class GetUniServlet extends HttpServlet{  

  protected void doGet(HttpServletRequest req,
  HttpServletResponse res) throws ServletException, IOException {
    
    UniDefaults uni = UniDefaults.create();
    PrintWriter pw = res.getWriter();
      pw.println("<html><head><title>Read Text File</title></head><body>");
    String filename = "/WEB-INF/resources/list-of-universities.txt";
    ServletContext context = getServletContext();
    InputStream inp = context.getResourceAsStream(filename);
    if (inp != null) {
      InputStreamReader isr = new InputStreamReader(inp);
      BufferedReader reader = new BufferedReader(isr);
      
      while(reader.readLine() != null){
      uni.universities.add(reader.readLine());
      }
      pw.println("</body></html>");
    }else{
      pw.println("<li>no good");
    }
    res.sendRedirect("cookieform.jsp");
  }
}
