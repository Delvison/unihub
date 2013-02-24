<html>
<head>
  <%@include file="header.jsp" %>
</head>

  <body>
    <form action="createlisting" method="GET">
      Name of item:<input type="text" name="name" ><br>
      Price of item:<input type="text" name="price" ><br>
      <% if (myCookie == null) { %>
        Location:<input type="text" name="location" ><br>
      <% } else { %> 
        Location: <%=sc%><br>
        <input type="hidden" name="location" value="<%=st%>">
      <% } %>
      <input type="hidden" name="university" value="<%=sc%>">
      <input type="submit" value="Submit">
    </form>
  </body>
