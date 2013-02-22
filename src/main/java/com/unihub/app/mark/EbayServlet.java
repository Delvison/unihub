package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.ws.BindingProvider;
import javax.xml.ws.handler.MessageContext;
import javax.xml.ws.handler.Handler;

//import ebay.apis.eblbasecomponents.*;
//import ebay.apis.eblbasecomponents.HalfCatalogProductType;
//import ebay.apis.eblbasecomponents.ProductIDCodeType;
//import ebay.apis.eblbasecomponents.ProductIDType;

@WebServlet("/search")
public class EbayServlet extends HttpServlet {

    private static final String APPID = "MarkWill-00a1-4cb0-b23d-5d85d0c939f1";
    private static final String CALLNAME = "FindHalfProducts";
    private static final String VERSION = "527";
    private static final String BASEURL = "http://open.api.ebay.com/shopping?";
    private static BindingProvider bp;

@Override
public void doGet(HttpServletRequest req,
                  HttpServletResponse res)
    throws ServletException, IOException {

String keywords = (req.getParameter("search")).replace(" ", "%20");
res.setContentType("text/html");
PrintWriter out = res.getWriter();
String docType = "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.0 " + "Transitional//EN\">\n";
String myAppId = "MarkWill-00a1-4cb0-b23d-5d85d0c939f1";

out.println(
  "<html>\n" +
  "<body>\n" +
  "The response should be here: " +
  "<a href=http://open.api.ebay.com/shopping?callname=FindHalfProducts&appid=" +
  myAppId +
  "&version=527&QueryKeywords=" +
  keywords +
  "&responseencoding=SOAP>Here is an XML response from eBay" +
  "</a>\n" +
  "</body>\n" +
  "</html>\n"
  );

}

}
