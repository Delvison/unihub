<%@ page language="java"
import="java.util.*"%>

<%
String school=request.getParameter("school");
String state=request.getParameter("state");
String both = school+"&"+state;

Date now = new Date();
String timestamp = now.toString();
Cookie cookie = new Cookie ("school&state",both);
cookie.setMaxAge(365 * 24 * 60 * 60);
response.addCookie(cookie);
%>

<html>
<head>
<title>Cookie Saved</title>
</head>
<body>
<p><a href="showcookievalue.jsp">Next Page to view the cookie value</a><p>
<hr>
<a href="home">Home</a>

</body>
