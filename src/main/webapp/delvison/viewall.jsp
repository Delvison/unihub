<html>
<head>
  <%@include file="header.jsp" %>
  <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.Stuff, java.util.*" %>
  <%
    ListingsObj lis = ListingsObj.create();
  %>

</head>

<body>
  <div name="searchbar" style="background-color:LightGray">
    <!--search bar goes here -->
    <center>

      <FORM ACTION="search" METHOD="GET" >
        <div>
          <select name = "school">
        <option>All</option>
        <option>Art Supplies</option>
        <option>Books</option>
        <option>Bicycles</option>
        <option>Electronics</option>
        <option>Cell Phones</option>
        <option>Furniture</option>
        <option>Musical Instruments</option>
        <option>Misc.</option>
      </select>
        <input type="text" name="q">
        <INPUT TYPE="SUBMIT" value="Search">
        </div>
    </center>
  </div>

  <div name="allListings">
  <% for (Stuff s: lis.stuffs){
       String[] c = s.getContentArray();
       int id = s.getId(); 
  %>
       <li><a href="i?id=<%=id%>"><%=c[0]+"- "+c[1]%></a>
       <%=c[3]+", "+c[4]%></li> 
  <%}%>
  </div>
</body>

</html>
