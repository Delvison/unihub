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

public class SearchServlet extends HttpServlet {
    static HttpSession session;

	public void doGet(HttpServletRequest req,
		              HttpServletResponse res) throws ServletException, IOException {

		String keywords = req.getParameter("search");
        keepSearchHistory(req, keywords);

        if(false){ //verifies if there is any results for the search in the local database.

        }else{ //if nothing was found in the local database, search in the "third parties".
        	
        	/*-------------AmazonSearch----------------*/
        	final String AWS_ACCESS_KEY_ID = "AKIAIZI2VON3T5UUKTZQ";            
            final String AWS_SECRET_KEY = "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";            
            final String ENDPOINT = "ecs.amazonaws.com";

            SignedRequestsHelper helper;
        	try {
            	helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        	} catch (Exception e) {
            	e.printStackTrace();
            	return;
        	}
        
       		String arequestUrl = null;
    		String title = null;
    		String price = null;
       		String detailUrl = null;
        	
        	Map<String, String> params = new HashMap<String, String>();
        	params.put("Service", "AWSECommerceService");
        	params.put("Version", "2013-02-15");
        	params.put("Operation", "ItemSearch");
        	params.put("AssociateTag", "uni00d-20"); // Added Mark's Associate Tag
        	params.put("IdType","ASIN");
        	params.put("ResponseGroup","Offers, Small");
        	params.put("SearchIndex","All");//Books
        	params.put("Keywords", keywords);
        	try{
            	arequestUrl = helper.sign(params);
            	title = fetchTitle(arequestUrl);
            	detailUrl = fetchDetailPage(arequestUrl);            
            	price = fetchPrice(arequestUrl);
            	
            	List<String> result =  new ArrayList<String>();
            	result.add(title);
            	result.add(detailUrl);
            	result.add(price);

            	req.setAttribute("amazon", result);
        	}catch (RuntimeException e){
            	RequestDispatcher dispatcher = req.getRequestDispatcher("bookNotFound");
                dispatcher.forward(req, res);
                //res.sendRedirect("/unihub/bookNotFound");//in this case title equals null
        	}

        	/*-------------EbaySearch----------------*/



			/*-------------GoogleSearch----------------*/
			String grequestUrl = "https://www.googleapis.com/shopping/search/v1/public/products"+
			"?key=AIzaSyAdUWvd01fA0X3wvtEdGACC9Vk4FMX5ytM&country=US&q="+
			((keywords == null || keywords.equals(""))?"fwiceubfnuire":formatSearch(keywords))+
			"&alt=atom";

			try {
				DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
				DocumentBuilder build = dbf.newDocumentBuilder();
				Document doc = build.parse(grequestUrl);
				NodeList linkNodeList = doc.getElementsByTagName("s:link");
				NodeList nameNodeList = doc.getElementsByTagName("name");

				String[] linkArray = null;

				if(linkNodeList.getLength() > 0)
					linkArray = new String[linkNodeList.getLength()];

				for(int i = 0; i < linkNodeList.getLength(); i++) {
					String store = linkNodeList.item(i).getTextContent();
					String name = nameNodeList.item(i).getTextContent();
					linkArray[i] = htmlLinkOutput(store, name);
				}
			
				req.setAttribute("google", linkArray);

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

    public String formatSearch(String userSearch){
        String[] holder = userSearch.split(" ");
        String appendies = "%22";

        for(int i = 0; i < holder.length; i++) {
            appendies+=holder[i];
            if(i != holder.length-1)
                appendies+="+";
        }
        appendies+="%22";

        return appendies;
    }

    public String htmlLinkOutput(String url, String name) {
        return "<a href=\""+url+"\">"+name+"</a>";
    }
}

