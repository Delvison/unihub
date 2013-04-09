<!--view all listings jsp-->
  <%@include file="header.jsp" %>
  <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.Stuff, java.util.*" %>
  <%@ page isELIgnored="false" %>
  <%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>
  <%ListingsObj lis = ListingsObj.create();%>
  <%String cat = (String)request.getParameter("cat");%>


<body data-spy="scroll" data-target="#sidebar">

 <center>
  <div class="container-fluid">
  <div id='content' class='row-fluid'>

      <!--Search Pane-->
      <div class="sidebar span3" id="sidebar" style="background-color:White">
        <h2>Search</h2>
        <FORM ACTION="searchServlet" METHOD="GET" >
          <INPUT CLASS="span11" TYPE="text" name="search" placeholder="Search">
            <!--<input class="span11" type="text" name="q" placeholder="Search"><br>-->
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
        <div class="tabbable">
          <ul class="nav nav-tabs">
            <li class="active">
              <a href="#filterTab" data-toggle="tab">Filter</a>
            </li>
            <li><a href="#searchHistoryTab" data-toggle="tab">
              Search History</a>
            </li>
            <li><a href="#sortByTab" data-toggle="tab">Sort by..</a></li>
          </ul>
        </div>
        <div class="tab-content">
          <div class="tab-pane" id="searchHistoryTab">
            <!--Yulle's search history here-->
            <ul class="unstyled">
              <devjsp:searchHistory>
                <li>${searchHistory}</li>
              </devjsp:searchHistory>
            </ul>
          </div>
          <div class="tab-pane active" id="filterTab">
            <h3>Filter by:</h3>
              <ul class="nav nav-tabs nav-stacked">
                <li><a href="viewalllistings?cat=All">All</a></li>
                <li><a href="viewalllistings?cat=Art">Art Supplies</a></li>
                <li><a href="viewalllistings?cat=Books">Books</a></li>
                <li><a href="viewalllistings?cat=Bicycles">Bicycles</a></li>
                <li><a href="viewalllistings?cat=Phones">Cell Phones</a></li>
                <li><a href="viewalllistings?cat=Electronics">Electronics</a></li>
                <li><a href="viewalllistings?cat=Furniture">Furniture</a></li>
                <li><a href="viewalllistings?cat=Musical">Musical Instruments</a></li>
                <li><a href="viewalllistings?cat=Misc.">Misc.</a></li>
              <ul>
          </div>
          <div class="tab-pane" id="sortByTab">
            <h3>Sort by:</h3>
              <ul class="nav nav-tabs nav-stacked">
                <li><a href="">Most recent</a></li>
                <li><a href="">Least recent</a></li>
                <li><a href="">Most Expensive</a></li>
                <li><a href="">Least Expensive</a></li>
                <li><a href="">University</a></li>
              <ul>
          </div>
        </div>
      </div>
      
      <!--Listings Pane -->
      <div class='span8 main' style="background-color:White">
        <h2>Listings</h2>
        <h4><i><%=cat%></i> - <%=sc%></h4>
          <% if (lis.stuffs.size() == 0) {%>
            <p><i>No listings exist.</i></p>
          <%}%>
        <table class="table table-striped">
          <devjsp:forEachListing category="<%=cat%>" >
            <tr>
              <td valign="center">
                <ul class="inline">
                  <li><a href="item?id=${listingId}" style="font-size:16px;"> 
                    ${listingName} - $${listingPrice} </a> - ${listingUniversity}, ${listingLocation}</li>
                  <li class="pull-right"><p><i>${listingCategory}</i></p></li>
                </ul>
                <ul class="inline">
                  <li><i>Posted by <a href="profile">${listingUser}</a></i></li>
                  <li class="pull-right"><i>${listingDate}</i></li>
                </ul>
              </td>
            </tr>
          </devjsp:forEachListing>
        </table>
      </div>
    </div>
  </div>
 </center>
</body>
</html>