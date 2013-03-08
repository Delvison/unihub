<html>
<head>
  <%@include file="header.jsp" %>
  <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.Stuff, java.util.*" %>
  <%
    ListingsObj lis = ListingsObj.create();
  %>
  
    <style type='text/css'>
    body {
      background-color: #CCC;
    }
  </style>

</head>

<body>
<div id='content' class='row-fluid'>
      <!--Search Pane-->
      <div class='span3 sidebar' style="background-color:White">
        <h2>Search</h2>
        <FORM ACTION="search" METHOD="GET" >
          <div class="input-prepend">
            <span class="add-on"><i class="icon-search"></i></span>
            <input class="span2" type="text" name="q"
                   style="width:180px">
          </div>
          <br>
          <select name = "school" style="width:208px">
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
          <br>
          <input type="submit" class="btn btn-primary" value="Search">
        </FORM>
      </div>
      
      <!--Listings Pane -->
      <div class='span9 main' style="background-color:White">
        <h2>Listings</h2>
          <% if (lis.stuffs.size() == 0) {%>
            <p><i>No listings exist.</i></p>
          <%}%>
        <table>
            <% for (Stuff s: lis.stuffs){
                   String[] c = s.getContentArray();
                   int id = s.getId(); %>
          <tr>
            <td><p><a href="i?id=<%=id%>"><%=c[0]+"- "+c[1]%></a>
              <%=c[3]+", "+c[4]%></p>
            </td>
          </tr>
             <%}%>
        </table>
      </div>
</div>
</body>
</html>
