package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.*;

import java.util.*;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

@WebServlet("/retrieveHistory")
public class RetrieveHistory extends HttpServlet {
    
    HttpSession session;

    public void doGet(HttpServletRequest req,HttpServletResponse res) throws ServletException, IOException {
        
        PrintWriter out = res.getWriter();
        out.println("<HTML><HEAD> </HEAD> <BODY>");
        /*
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
        */

        session = req.getSession();
        List<String> klist = new ArrayList();
        klist = (List<String>) session.getAttribute("keywords");

        out.println("<UL>");
        ListIterator it = klist.listIterator();
        while(it.hasNext()){
            String key = (String) it.next();
            String link = key.replace(" ","%20");
            out.println("<li><a href=/unihub/amazon?search="+link+">"+key+"</a> </li>");
        }
        out.println("</UL>");

        out.println("<DIV><a href=/unihub/amazonSearch>Back to search </a> </DIV>");
        out.println("</BODY> </HTML>");
    }
}