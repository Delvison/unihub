<!DOCTYPE html>
<html>
  <head>
  <%@include file="bootstrap.jsp"%>
  
  <!---##############JAVA PORTION###############################-->

  <!--jsp that is needed when directing user from this page
  to logim and back. Only needed when the user expressly clicks
  login though. Devs validate is better suited for get request
  validation-->
  <%@include file="/andy/auth_headers.jsp" %>
  <%@ page import="com.unihub.app.AuthUtilities, com.unihub.app.Dbase" %>
  <%@ page isELIgnored="false" %>
  <%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>



  <%
    String cookieName = "school&state";
    String sc = " "; 
    String st= " ";
    Cookie cookies [] = request.getCookies ();
    Cookie myCookie = null;

    if (cookies != null){
      for (int i = 0; i < cookies.length; i++){
        if (cookies [i].getName().equals (cookieName)){
           myCookie = cookies[i];
           break;
        }
      }
    }
    if (myCookie != null){
      String temp = myCookie.getValue();
      String[] vals = temp.split("&");
      sc = vals[0];
      st = vals[1];
    }
  %>

  <style>
        .shadow {
          background-color:#ffffff;
          box-shadow: 7px 7px 3px #888888;
        }
  </style>
  </head>
    
  <%@ include file="nav.jsp" %>
