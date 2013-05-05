<!DOCTYPE html>
<!--This shall be our main home screen -->
<%@ page import="com.unihub.app.HtmlOutputUtilities, com.unihub.app.Event, 
        com.unihub.app.EventListHolder, javax.ejb.EJB, javax.naming.*, java.util.*, com.unihub.app.ListingObjEJBStateful, com.unihub.app.WeatherEJB, com.unihub.app.WeatherSession, com.unihub.app.Event, com.unihub.app.Events, com.unihub.app.EventsBean, java.util.ArrayList, javax.xml.parsers.DocumentBuilder, javax.xml.parsers.DocumentBuilderFactory, org.w3c.dom.Document, org.w3c.dom.Node, org.w3c.dom.NodeList"%>


<%! @EJB ListingObjEJBStateful lis;
    @EJB WeatherEJB weather;
    @EJB Events bean;
     %>

<%
  /*
  This will temporarily be here since I will get this info from
  the database when its set up*/
  String[] cats = {"Appliances",
    "Art Supplies",
    "Bikes",
    "Books",
    "Cars" ,
    "Cell Phones",
    "Clothes",
    "Computers",
    "Electronics",
    "Freebies",
    "Furniture",
    "Games",
    "Jobs",
    "Music",
    "Musical Instruments",
    "Movies",
    "Pets",
    "Sporting Goods",
    "Wanted",
    "Everything Else.."};

  EventListHolder holder = EventListHolder.getInstance();
  String user = (String)session.getAttribute("username");
  Context context = new InitialContext();
  lis = (ListingObjEJBStateful) context.lookup("ejb:unihub-ear/unihub-ejb//ListingObjEJBStateful!com.unihub.app.ListingObjEJBStateful?stateful");
  weather = (WeatherEJB) context.lookup("ejb:unihub-ear/unihub-ejb//WeatherEJB!com.unihub.app.WeatherEJB");
  bean = (Events) context.lookup("ejb:unihub-ear/unihub-ejb//EventsBean!com.unihub.app.Events");
  ArrayList<Event> list = bean.getEvents();

%>
<%@ include file="/delvison/header.jsp" %>

<!-- This page checks if user logged in, if so show home, if not show index-test -->




<%

	String userName;
    try{
      userName = (String)session.getAttribute("username");
    }catch(NullPointerException e){
      userName = "";
    }




	if(userName != null && !userName.equals("")) {
      /* if logged in, send user to intended location */
%>
		<%@ include file="/delvison/home.jsp" %>
<%
      
    } else{

      /* if not logged in, send to login page */
%>
		<%@ include file="/andy/index.jsp" %>
<%    

    }
%>














