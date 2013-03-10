<!--view all listings jsp-->
<head>
  <%@include file="header.jsp" %>
  <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.Stuff, java.util.*" %>
  <%@ page isELIgnored="false" %>
  <%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>
  <%ListingsObj lis = ListingsObj.create();%>
</head>

<body>

 <center>
  <div id='content' class='row-fluid'>

      <!--Search Pane-->
      <div class='span3 sidebar offset1' data-spy="scroll" style="background-color:White">
        <h2>Search</h2>
        <FORM ACTION="search" METHOD="GET" >
          <input class="span11" type="text" name="q" placeholder="Search"><br>
          <select name = "category" class="span11">
            <option>All</option>
            <option>Art Supplies</option>
            <option>Books</option>
            <option>Bicycles</option>
            <option>Electronics</option>
            <option>Cell Phones</option>
            <option>Furniture</option>
            <option>Musical Instruments</option>
            <option>Misc.</option>
          </select><br>
          <input type="submit" class="btn btn-primary" value="Search">
        </FORM>
      </div>
      
      <!--Listings Pane -->
      <div class='span7 main' style="background-color:White">
        <h2>Listings</h2>
        <p><i><%=sc%></i></p>
          <% if (lis.stuffs.size() == 0) {%>
            <p><i>No listings exist.</i></p>
          <%}%>
        <table class="table table-striped">
          <devjsp:forEachListing >
            <tr>
              <td valign="center">
                <p>
                  <a href="item?id=${listingId}"> 
                     ${listingName} - $${listingPrice} </a>
                  ${listingUniversity}, ${listingLocation}
              </p>
              </td>
            </tr>
          </devjsp:forEachListing>
        </table>
      </div>
  </div>
 </center>
</body>
</html>
