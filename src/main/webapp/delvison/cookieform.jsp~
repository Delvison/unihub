<html>
  <head>
    <%@include file="header.jsp" %>
    <title>Set Locationt</title>
       <%@ page import="com.unihub.app.UniDefaults,com.unihub.app.DummyData, java.util.*" %>
       <%
       UniDefaults uni = UniDefaults.create();
       ArrayList<String> univers = uni.universities;
       DummyData.generate();
       %>
  </head>

  <body>
    <form method="post" action="setcookie.jsp">
      <select name = "school">
        <option>SUNY Oswego</option>
        <option>Stanford</option>
        <option>Washington State</option>
      </select>
      <br>

      <select name = "state">
        <option>New York</option>
        <option>California</option>
        <option>Washington</option>
      </select>
      <br>
      
      <select name = "university">
        <%
          for (String u:univers){
        %>
            <option><%=u%></option>
        <%}%>
      </select>
      <br>
      <input type="submit" class="btn btn-primary" value="Submit">
    </form>
  </body>
</html>
