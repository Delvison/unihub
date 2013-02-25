<html>
<head>
  <%@include file="header.jsp" %>
</head>

  <body>
    <form action="createlisting" method="GET">
      <% if (myCookie == null) { %>
        Location: <a href="cookieform.jsp">Location not set</a><br>
      <% } else { %> 
        Location: <%=sc%><br>
        <input type="hidden" name="location" value="<%=st%>">
      <% } %>
        <input type="hidden" name="university" value="<%=sc%>">
      <br>
      Name of item:<input type="text" name="name" ><br>
      Price of item:<input type="text" name="price" ><br>

      <input type="submit" value="Submit">
    </form>
  </body>
