package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import java.util.HashMap;
import java.util.Map;


@Stateful
@Remote(SearchEJB.class)
@WebService
public class SearchSession implements SearchEJB {
	@WebMethod
	public ArrayList<String> amazonSearch(String keywords) throws RuntimeException{
		final String AWS_ACCESS_KEY_ID = "AKIAIZI2VON3T5UUKTZQ";            
        final String AWS_SECRET_KEY = "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";            
        final String ENDPOINT = "ecs.amazonaws.com";

        SignedRequestsHelper helper = null;
        try {
        	helper = SignedRequestsHelper.getInstance(ENDPOINT, AWS_ACCESS_KEY_ID, AWS_SECRET_KEY);
        } catch (Exception e) {
           	e.printStackTrace();
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
            	
           	ArrayList<String> result =  new ArrayList<String>();
           	result.add(title);
           	result.add(detailUrl);
           	result.add(price);

           	return result;
        }catch (RuntimeException e){
           	throw new RuntimeException();
            //res.sendRedirect("/unihub/bookNotFound");//in this case title equals null
        }	
	}

	@WebMethod
	public String[] googleSearch(String keywords) throws Exception{
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
			
			return linkArray;

		} catch (Exception e) {			
			throw new Exception();
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