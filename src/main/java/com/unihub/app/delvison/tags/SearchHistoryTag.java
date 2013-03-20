package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.util.*;
import javax.servlet.http.HttpSession;  

public class SearchHistoryTag extends SimpleTagSupport{
  public void doTag() throws JspException, IOException{
  	 PageContext pc = (PageContext) getJspContext();  
    HttpSession session = pc.getSession(); 
  	List<String> klist = new ArrayList();
    klist = (List<String>) session.getAttribute("keywords");
  
    if(session.getAttribute("keywords") != null){
    	ListIterator it = klist.listIterator();
        String key = (String) it.next();
        getJspContext().setAttribute("searchHistory",key);
        getJspBody().invoke(null);
    }else{
    	String none = "No history found.";
    	getJspContext().setAttribute("searchHistory",none);
        getJspBody().invoke(null);
    }
  }
}