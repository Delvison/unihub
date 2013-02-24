<%-- 
    Document   : profile
    Created on : Feb 23, 2013, 8:08:10 PM
    Author     : Grifafa
--%>

<%@ page language="java" import="com.unihub.app.User,
                                javax.servlet.*,
                                javax.servlet.http.*" %>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>User Profile</title>
    </head>
    <body>
        <% User user = (User)session.getAttribute("user");  %>
        <% if (user == null) { %>
        <a href="../login.jsp">Login</a>
        <% }else{ %>
        <h3><%=user.getName()%></h3>
        <h4><%=user.getSchool()%></h4>
        <a href="../index.jsp"> My Listings </a>
        <%}%>
    </body>
</html>
