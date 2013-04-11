<!--This shall be our main home screen -->
<%@ page import="com.unihub.app.HtmlOutputUtilities, com.unihub.app.Event, 
        com.unihub.app.EventListHolder" %>
<%
  /*
  This will temporarily be here since I will get this info from
  the database when its set up*/
  String[] cats = new String[] {"Art Supplies", "Books", "Bicycles", "Jobs", 
                  "Electronics", "Cars", "Cell Phones", "Furniture", 
                  "Musical Instruments", "Misc."};

  EventListHolder holder = EventListHolder.getInstance();

%>



<%@ include file="/delvison/header.jsp" %>

  <body>
    <div class="container-fluid">
      <div class="row-fluid">
        <div class="span3">
          <div class="well sidebar-nav">
            <ul class="nav nav-list">
              <li class="nav-header">Categories</li>
              <% for (int i=0; i < cats.length; i++){ %>
                  <li>
                    <a href="viewalllistings?cat=<%=cats[i]%>"><%=cats[i]%></a>
                  </li>
              <%}%>
            </ul>
          </div><!--/.well -->
          <br>
                <div class="well sidebar-nav">
        <h2>Events</h2>
        <table class="table">

          <% for(int i = 0; i < holder.numOfEvents(); i++){ %>

            <tr>
              <td>
                <h3><%= holder.getEvent(i).getTitle() %></h3>
                <p>on <%= holder.getEvent(i).getThingy() %></p>
                <p><%= holder.getEvent(i).getDes() %></p>
                <p><%= holder.getEvent(i).howManyGoing() %></p>
                <a href="attend?id=<%=holder.getEvent(i).getId() %> ">Attending</a> | <a href="#">More Info</a>
              </td>
            </tr>

          <% } %>
          <!--This bottom part is only for linking to viewing all events -->
          <tr>
            <td>
              <h4><a href="events">View All</a></h3>
            </td>
          </tr> 

        </table>
      </div>

        </div><!--/span-->
        <div class="span9 jetstrap-highlighted">
 <div id="myCarousel" class="carousel slide" data-pause="remove">
      <div class="carousel-inner">
        <div class="item active">
          <img class="" src="design/images/books.jpg">
          <div class="container jetstrap-highlighted">
            <div class="carousel-caption">
              <h1><p style="color:white">Welcome to UniHub!</p></h1>
              <p class="lead"> UniHub is an online classified listing service specifically geared towards the college ecosystem. On UniHub, you are able to sell and buy things from fellow members of your university. The stuff you need quick and easy. So go ahead and give it a try!</p>
              <a class="btn btn-large btn-primary" href="signup">Sign up today</a>
            </div>
          </div>
        </div><br>
      
      <%@ include file="/delvison/rightTabListingsIncl.jsp" %>
      <br>
      <div class="shadow">
          <ul class="inline">
            <li><h3> SUNY Oswego, NY </h3></li>
            <li><a href="populateUniversities">Change Location</a></li>
          </ul>
          <p>
            Show stuff specific to location here.
          </p>
      </div>


      <hr>
      <footer>
        <p>&copy; UniHub</p>
      </footer>
    </div><!--/.fluid-container-->
    

    <style>
      
      body {
        padding-bottom: 40px;
      }
      .sidebar-nav {
        padding: 9px 0;
      }
      
      @media (max-width: 980px) {
        /* Enable use of floated navbar text */
        .navbar-text.pull-right {
          float: none;
          padding-left: 5px;
          padding-right: 5px;
        }
      }
      
    </style>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.7.2/jquery.min.js">
    </script>
    <script src="assets/js/bootstrap.js">
    </script>
    <script>

    </script>
  </body>
</html>