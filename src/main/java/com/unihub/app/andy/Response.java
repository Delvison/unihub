/************
*ANDY'S FILE*
************/
package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.net.URL;
import java.util.Scanner;

/*Imports for XML parser*/
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

@WebServlet("/le_test")
public class Response extends HttpServlet {
/*
Purpose of this class is to take the user search
and put it through google search to get a hold 
of the JSON then parse and show to user*/
	@Override
	public void doPost(HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {

		PrintWriter out = res.getWriter();
		String userQuery = req.getParameter("query").trim();

		String requestUrl = "https://www.googleapis.com/shopping/search/v1/public/products"+
		"?key=AIzaSyAdUWvd01fA0X3wvtEdGACC9Vk4FMX5ytM&country=US&q="+
		((userQuery == null || userQuery.equals(""))?"fwiceubfnuire":formatSearch(userQuery))+
		"&alt=atom";


		/*This be a test to see if XML works
		with the way Yulle found*/
		try {
			/*Create DocumentBuilder which calls the URL and parses it*/
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder build = dbf.newDocumentBuilder();
			Document doc = build.parse(requestUrl);
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
			
				req.setAttribute("links", linkArray);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		RequestDispatcher dispatcher = req.getRequestDispatcher("response");
		dispatcher.forward(req, res);

	}//end of doPost method



	/*
	These methods are generic enough to be placed
	in a Utilities class as static methods
	*/

	public String htmlLinkOutput(String url, String name) {

		return "<a href=\""+url+"\">"+name+"</a>";

	}//end htmlLinkOut

	

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
	}//end of formatUrl






}//end of class