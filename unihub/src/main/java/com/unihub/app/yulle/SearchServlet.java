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

public class SearchServlet extends HttpServlet {
    @EJB
    SearchEJB search;
    static HttpSession session;

	public void doGet(HttpServletRequest req,
		              HttpServletResponse res) throws ServletException, IOException {

		String keywords = req.getParameter("search");
        keepSearchHistory(req, keywords);

        if(false){ //verifies if there is any results for the search in the local database.

        }else{ //if nothing was found in the local database, search in the "third parties".
        	
        	/*-------------AmazonSearch----------------*/
        	try{
                req.setAttribute("amazon", search.amazonSearch(keywords));
        	}catch (RuntimeException e){
            	RequestDispatcher dispatcher = req.getRequestDispatcher("bookNotFound");
                dispatcher.forward(req, res);
                //res.sendRedirect("/unihub/bookNotFound");//in this case title equals null
        	}

        	/*-------------EbaySearch----------------*/



			/*-------------GoogleSearch----------------*/
			try{
				req.setAttribute("google", search.googleSearch(keywords));
			} catch (Exception e) {
				RequestDispatcher dispatcher = req.getRequestDispatcher("bookNotFound");
                dispatcher.forward(req, res);	
			}
			RequestDispatcher dispatcher = req.getRequestDispatcher("gsearch");
			dispatcher.forward(req, res);
        }
	}


	private static void keepSearchHistory(HttpServletRequest req, String keywords){
        session = req.getSession();
        List<String> klist = new ArrayList();
        if(session.getAttribute("keywords")==null){
            klist.add(keywords);
            session.setAttribute("keywords", klist);
        }else{
            klist = (List<String>) session.getAttribute("keywords");
            klist.add(keywords);
            session.setAttribute("keywords", klist);
        }    
    }
}

