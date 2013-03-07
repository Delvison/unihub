<%-- 
    Document   : profile
    Created on : Feb 23, 2013, 8:08:10 PM
    Author     : Grifafa
--%>

<!-- Not Currently Used
See ProfileServlet in java/mark -->

<%@ page language="java" import="com.unihub.app.User,
                                javax.servlet.*,
                                javax.servlet.http.*" %>
<!DOCTYPE html>

<html>
    <head>
        <%@ include file="../delvison/header.jsp"%>
        <title>User Profile</title>
    </head>
    <body>
        <% User user = (User)session.getAttribute("user");  %>
        <%  try {
            String gravatar = user.gravatar(); 
            } catch(NoSuchAlgorithmException e) {
              out.println("No Such Algorithm Exception");
            } %>
        <img src=<%=gravatar%>></img><br/>
        <h3><%=user.getName()%></h3><br/>
        <h4><%=user.getSchool()%></h4>
    </body>
</html>
