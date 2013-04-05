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

@WebServlet("/amazon")
public class Amazon extends HttpServlet {
 
    static HttpSession session;

	public void doGet(HttpServletRequest req,
		HttpServletResponse res) throws ServletException, IOException {
        
        final String AWS_ACCESS_KEY_ID = "AKIAIZI2VON3T5UUKTZQ";            
        final String AWS_SECRET_KEY = "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";            
        final String ENDPOINT = "ecs.amazonaws.com";
		
        PrintWriter out = res.getWriter();  
        String keywords = req.getParameter("search");
        keepSearchHistory(req, keywords);

        SignedRequestsHelper helper;
        try {
            helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
            e.printStackTrace();
            return;
        }
        
       	String requestUrl = null;
    	String title = null;
    	String price = null;
       	String detailUrl = null;

        /* The helper can sign requests in two forms - map form and string form */
       	/*
         * Here is an example in map form, where the request parameters are stored in a map.
         */
        Map<String, String> params = new HashMap<String, String>();
        params.put("Service", "AWSECommerceService");
        params.put("Version", "2013-02-15");
        params.put("Operation", "ItemSearch");
        params.put("AssociateTag", "uni00d-20"); // Added Mark's Associate Tag
        params.put("IdType","ASIN");
        params.put("ResponseGroup","Offers, Small");
        params.put("SearchIndex","Books");
        params.put("Keywords", keywords);
        try{
            requestUrl = helper.sign(params);
            title = fetchTitle(requestUrl);
            detailUrl = fetchDetailPage(requestUrl);            
            price = fetchPrice(requestUrl);            
            res.sendRedirect("/unihub/amazonSearch?title="+title+
                             "&description="+detailUrl+
                             "&price="+price);
        }catch (RuntimeException e){
            res.sendRedirect("/unihub/bookNotFound");//in this case title equals null
        }
	}//end of doGet method

    /*
    private static void keepSearchHistory(HttpServletRequest req,
                                          HttpServletResponse res,
                                          String keywords){
        Cookie cookies[] = req.getCookies();
        Cookie mycookie = null;
        boolean found = false;
        if (cookies != null){
            for (int i = 0; i < cookies.length; i++){
                if (cookies[i].getName().equals ("searches")){
                    mycookie = cookies[i];
                    found = true;
                    break;
                }
            }
            if(!found){
                mycookie = new Cookie ("searches", keywords);
                mycookie.setMaxAge(60*60*25*7);
                res.addCookie(mycookie);
            }else{
                String temp = mycookie.getValue() + "&" + keywords;
                mycookie.setValue(temp);
                mycookie.setMaxAge(60*60*25*7);
                res.addCookie(mycookie);
            }

       }
    }*/

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
           
    private static String fetchPrice(String requestUrl){
        String title = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            Node priceNode = doc.getElementsByTagName("FormattedPrice").item(0);
            Node currencyNode = doc.getElementsByTagName("CurrencyCode").item(0);
            title = priceNode.getTextContent() + " " + currencyNode.getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return title;
    }
    
    /*
     * Utility function to fetch the response from the service and extract the
     * title from the XML.
     */
    private static String fetchTitle(String requestUrl){
        String title = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            Node titleNode = doc.getElementsByTagName("Title").item(0);
            title = titleNode.getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return title;
    }

    /*
     * Utility function to fetch the response from the service and extract the
     * detail page URL from the XML.
     */
    private static String fetchDetailPage(String requestUrl){
        String title = null;
        try {
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(requestUrl);
            Node detailNode = doc.getElementsByTagName("DetailPageURL").item(0);
            title = detailNode.getTextContent();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return title;
    }
}//end class
