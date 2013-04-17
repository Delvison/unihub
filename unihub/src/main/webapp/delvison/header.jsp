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
            background-color:#F7f7f7;
            box-shadow: 3px 3px 7px #cccccc;
          }
    </style>


    <link rel="stylesheet" href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />
    <script src="http://code.jquery.com/jquery-1.9.1.js"></script>
    <script src="http://code.jquery.com/ui/1.10.2/jquery-ui.js"></script>
    <link rel="stylesheet" href="/resources/demos/style.css" />
    <script>
    $(function() {
      $( "#datepicker" ).datepicker();
    });
    </script>





  </head>
    
  <%@ include file="nav.jsp" %>
