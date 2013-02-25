package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.*;

import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@WebServlet("/retrieveHistory")
public class RetrieveHistory extends HttpServlet {
    
    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        
        PrintWriter out = res.getWriter();
        out.println("<HTML><HEAD> </HEAD> <BODY>");
        
        
        Cookie cookies[] = req.getCookies();
        Cookie mycookie = null;
        if (cookies != null){
            for (int i = 0; i < cookies.length; i++){
                if (cookies[i].getName().equals ("searches")){
                    mycookie = cookies[i];
                    break;
                }
            }
            if (mycookie==null) {
                out.println("No History Found.");
                out.println("<DIV><a href=/unihub/amazon>Back to seach </a> </DIV>");
                return;
            }
            String[] keywords = mycookie.getValue().split("&");
            out.println("Search History:");
            out.println("<UL>");
            for(int i=0;i<keywords.length;i++){
                String link = keywords[i].replace(" ","%20");
                out.println("<li><a href=/unihub/amazon?search="+link+">"+keywords[i]+"</a> </li>");
            }
            out.println("</UL>");
        }
        out.println("<DIV><a href=/unihub/amazon>Back to seach </a> </DIV>");
        out.println("</BODY> </HTML>");
    }
}