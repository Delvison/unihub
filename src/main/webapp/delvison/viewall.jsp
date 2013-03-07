<html>
<head>
  <%@include file="header.jsp" %>
  <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.Stuff, java.util.*" %>
  <%
    ListingsObj lis = ListingsObj.create();
  %>

</head>

<body>
  <center>
  <div name="searchbar" style="background-color:LightGray; width:1020px">
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
        <INPUT TYPE="SUBMIT" class="btn btn-primary" value="Search">
        </div>
    </center>
  </div>
  </center>
  
  <center>
  <div name="allListings" style="width:1020px">

    <table cellpadding="2" cellspacing="0" border="0" width="1020">
    <% for (Stuff s: lis.stuffs){
         String[] c = s.getContentArray();
         int id = s.getId(); 
    %>  
       <tr>
         <td><p><a href="i?id=<%=id%>"><%=c[0]+"- "+c[1]%></a>
         <%=c[3]+", "+c[4]%></p></td>
       </tr> 
  <%}%>
  </table>

  </div>
  </center>
</body>
</html>
