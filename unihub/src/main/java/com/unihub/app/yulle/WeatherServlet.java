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
import org.w3c.dom.NodeList;
import javax.ejb.*;

@WebServlet("/weather")
public class WeatherServlet extends HttpServlet {
    @EJB
    WeatherEJB weather;
    public void doGet(HttpServletRequest req,
		              HttpServletResponse res) throws ServletException, IOException {
    	PrintWriter out = res.getWriter();
    	String ipAddress = req.getRemoteAddr();
    	try{
    		List<String> temp = weather.weatherLookup("13126"); //hardcoded Oswego ZIP code
    		out.print("Temperature: " + temp.get(0));
      		out.print("   |   Max: " + temp.get(1));
      		out.print("   |   Min: " + temp.get(2));
      		out.print("   |   Condition: " + temp.get(3));
    	}catch(RuntimeException e){
    		out.print("weatherLookup didn't find a match for the key");
    	}	
    }
}    