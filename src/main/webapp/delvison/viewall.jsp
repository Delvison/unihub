<html>
<head>
  <%@include file="header.jsp" %>
  <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.Stuff, java.util.*" %>
  <%
    ListingsObj lis = ListingsObj.create();
  %>

</head>

<body>
  <% for (Stuff s: lis.stuffs){
       String[] c = s.getContentArray();
       int id = s.getId(); 
  %>
       <li><a href="i?id="<%=id%>"><%=c[0]+"- "+c[1]%></a>
       <%=c[3]+", "+c[4]%></li>
  <%}%>

</body>

</html>
