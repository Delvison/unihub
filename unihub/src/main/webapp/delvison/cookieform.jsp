<!--jsp to set location cookie-->
<%@include file="header.jsp" %>
<%@ page import="com.unihub.app.UniDefaults,com.unihub.app.DummyData, java.util.*" %>
<%
  UniDefaults uni = UniDefaults.create();
  ArrayList<String> univers = uni.universities;
  DummyData.generate();
%>

  <body>
         <div class='span4 sidebar' data-spy="scroll" style="background-color:White">
    <center>
      <h2>Choose Location</h2>
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
    </center>
    </div>
  </body>
</html>
