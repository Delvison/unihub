<%-- 
    Document   : profile
    Created on : Feb 23, 2013, 8:08:10 PM
    Author     : Grifafa
--%>

<!-- Not Currently Used
See ProfileServlet in java/mark -->

<%@ page language="java" import="com.unihub.app.User,
                                java.security.*,
                                javax.servlet.*,
                                javax.servlet.http.*" %>

<%@ include file="../delvison/header.jsp"%>

    <body>
        <% User currentuser = (User)session.getAttribute("user"); %>
        <%  String gravatar = "";
            try {
              gravatar = currentuser.gravatar(); 
            } catch(NoSuchAlgorithmException e) {
              out.println("No Such Algorithm Exception");
            } %>
        <img src=<%=gravatar%>></img><br/>
        <h3><%=currentuser.getName()%></h3><br/>
        <h4><%=currentuser.getSchool()%></h4>
    </body>
</html>
