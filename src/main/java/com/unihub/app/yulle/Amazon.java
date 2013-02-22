package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Amazon extends HttpServlet {
    
		public void doGet(HttpServletRequest req,
		HttpServletResponse res) throws ServletException, IOException {
        
            final String AWS_ACCESS_KEY_ID = "AKIAIZI2VON3T5UUKTZQ";
            
            final String AWS_SECRET_KEY = "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";
            
            final String ENDPOINT = "ecs.amazonaws.com";
            
            
            
            PrintWriter out = res.getWriter();
            out.println("<H1>Amazon Search:</H1>");
            out.println("<FORM> <INPUT TYPE=\"text\" name=\"search\">" +
                        "<INPUT TYPE=\"SUBMIT\">" +
                        "</FORM>");
		
            String keywords = req.getParameter("search");
            //String keywords = "lord%20rings%20fellowship";
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
                System.out.println("Signed Request is \"" + requestUrl + "\"");

                title = fetchTitle(requestUrl);
                detailUrl = fetchDetailPage(requestUrl);
                out.println("Found on Amazon: \"<a href="+detailUrl+">" + title + "\"</a>");
                price = fetchPrice(requestUrl);
                out.println();
                out.println("New from: \"" + price + "\"");
                //out.println("Detail Page: \"" + detailUrl + "\"");
                
                out.println();
            }catch (RuntimeException e){
                out.println("book not found");
            }
	}//end of doGet method

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
