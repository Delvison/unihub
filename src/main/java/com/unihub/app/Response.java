/************
*ANDY'S FILE*
************/
package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.net.URL;
import java.util.Scanner;


public class Response extends HttpServlet {
/*
Purpose of this class is to take the user search
and put it through google search to get a hold 
of the JSON then parse and show to user*/

	public void doGet(HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {

		String requestUrl = "https://www.googleapis.com/shopping/search/v1/public/products"+
		"?key=AIzaSyAdUWvd01fA0X3wvtEdGACC9Vk4FMX5ytM&country=US&q=978-0596009205&alt=json";

		URL googleRequest = new URL(requestUrl);
		Scanner scan = new Scanner(googleRequest.openStream());

		PrintWriter out = res.getWriter();
		while(scan.hasNext())
			out.println(scan.nextLine());


	}//end of doPost method

}//end of class