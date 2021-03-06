<% 

  String url = "https://maps.googleapis.com/maps/api/place/nearbysearch/xml?key=AIzaSyAdUWvd01fA0X3wvtEdGACC9Vk4FMX5ytM&location=43.45267,-76.543722&radius=2000&sensor=true";
  String[] smallList = null;

  try {
  DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
  DocumentBuilder build = dbf.newDocumentBuilder();
  Document doc = build.parse(url);
  NodeList linkNodeList = doc.getElementsByTagName("name");
  smallList = new String[3];
  smallList[0] = linkNodeList.item(1).getTextContent();
  smallList[1] = linkNodeList.item(2).getTextContent();
  smallList[2] = linkNodeList.item(3).getTextContent();

  } catch (Exception e) {
    //Then just hardcode for now like dev does
    smallList = new String[3];
    smallList[0] = "SUNY Oswego Campus Center";
    smallList[1] = "Walmart, Oswego NY";
    smallList[2] = "Fast Trac, Oswego NY";
  }       




%>


  <body>
    <div class="container-fluid top-buffer" data-spy="scroll" data-target="#events">
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

          <!--Events-->
          <div id="events" class="well nav sidebar-nav affix-top scrollable-table">
            <CENTER>
              <h3 style="color: #999999; margin-top:0px; margin-bottom:0px; " class="le-font">Events</h3>
            </CENTER>
              <table class="table">

                <% for(Event event : list){ %>

            <tr>
              <td>
                <h4><%= event.getTitle() %></h4>
                <p>on <%= event.getThingy() %> @<%= event.getTime() %></p>
                <p><%= event.getDes() %></p>
                <p><%= event.howManyGoing() %></p>
                <a href="attend?id=<%=event.getId() %> ">Attending</a>
              </td>
            </tr>

          <% } %>
          <!--This bottom part is only for linking to viewing all events -->
          <tr>
            <td>
              <CENTER><h4><a href="events">View All</a></h4><CENTER>
            </td>
          </tr>

        </table>
      </div>

        </div><!--/span-->
        <div class="span9 jetstrap-highlighted">
      <div id="myCarousel" class="carousel slide" data-pause="remove">
      <div class="carousel-inner">
        <div class="item active">
          <img src="design/images/blubooks-sm.jpg">
          <div class="container jetstrap-highlighted">
            <div class="carousel-caption">
              <h1><p style="color:white">Welcome to UniHub</p></h1>
              <p class="lead"> </p>
            </div>
          </div>
        </div><br>
      
      <!--Personalized to location-->
      <div class="shadow">
        <div class="container-fluid">
            <ul class="inline">
              <li><h3> <%=sc%>, <%=st%></h3></li>
              <li><a href="populateUniversities">Change Location</a></li>
            </ul>
          <div class="row-fluid">
            <div class="container-fluid span5">
              <h3>Weather</h3>
              <p>
                <% List<String> w = weather.weatherLookup("13126"); %>
        
                  <table>
                    <tr>
                      <td>
                    <img src="<%=w.get(4)%>" alt="some_text">
            </td><td>
                     <font size="9"><%=w.get(0)%> &degF</font><br>
                      <font size="2">Max: <%=w.get(1)%>&degF</font>
                      <font size="2">Min: <%=w.get(2)%>&degF</font>
  </td></tr></table>
                 <br>
                  <font size="5"><%=w.get(3)%></font>
              </p>
            </div>
            <div class="span1" style="width:1px;height:160px;background-color:gray;float:left;"></div> 
            <div class="span6">
              <h3>Recommended Meeting Spots</h3>
              <p>
                <ul>

                  <% for(String le : smallList) { %>

                    <li><%= le %> 
                      <a href="https://maps.google.com/?q=<%= le %>">View Map</a> 
                    </li>

                  <% } %>

                </ul>
              </p>
            </div>
          </div>
        </div>
      </div>
      <br>

      <!--Recent listings Carousel-->          
      <% if (lis.getArrayListSize() > 0) { %>
      <div class="shadow" style="height:450px">
        <div class="container-fluid">
          <h3>Recently Posted</h3>
          <div id="listingsCarousel" class="carousel slide">
            <div class="carousel-inner">
              <devjsp:itemInfo itemId="1">
              <div class="item active">
                <div class="container-fluid">
                  <div class="row -fluid">
                    <div class="span4 offset1"><br><br><br>
                      <a href="#" class="thumbnail">
                        <img src="listings/1/1.jpg" alt="">
                      </a>
                    </div>
                    <div class="span6">
                      <div>
                        <br><br>
                        <h4><strong><a href="item?id=${itemId}">${itemName} - $${itemPrice} (${itemUniversity}, ${itemLocation})</a></strong></h4>
                      </div>
                      <br><br><br>
                      <p>
                        ${itemDescription}
                      </p>
                      <p>
                        <a class="btn" href="item?id=${itemId}">View Listing</a>
                      </p>
                    </div>
                  </div>
                  <div class="row-fluid">
                    <div class="span9 offset1">
                      <p></p>
                      <p>
                        <i class="icon-user"></i> by <a href="profile">${itemUser}</a>
                        | <a href="viewalllistings">${itemCategory}</a>
                        | <i class="icon-calendar"></i> ${itemTime}
                        | <i class="icon-comment"></i> <a href="#">3 Comments</a>
                        | <i class="icon-share"></i> <a href="#">39 Likes</a>
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </devjsp:itemInfo > 
              <devjsp:forEachListing limit="6" searchTerm="null">
              <div class="item">
                <div class="container-fluid">
                  <div class="row -fluid">
                    <div class="span4 offset1"><br><br><br>
                      <a href="#" class="thumbnail">
                        <img src="${listingPhoto}" alt="">
                      </a>
                    </div>
                    <div class="span6">
                      <div>
                        <br><br>
                        <h4><strong><a href="item?id=${listingId}">${listingName} - $${listingPrice} (${listingUniversity}, ${listingLocation})</a></strong></h4>
                      </div>
                      <br><br><br>
                      <p>
                        ${listingDescription}
                      </p>
                      <p>
                        <a class="btn" href="item?${listingId}">View Listing</a>
                      </p>
                    </div>
                  </div>
                  <div class="row-fluid">
                    <div class="span9 offset1">
                      <p></p>
                      <p>
                        <i class="icon-user"></i> by <a href="#">${listingUser}</a>
                        | <a href="viewalllistings">${listingCategory}</a>
                        | <i class="icon-calendar"></i> April 16th, 2013
                        | <i class="icon-comment"></i> <a href="#">3 Comments</a>
                        | <i class="icon-share"></i> <a href="#">39 Likes</a>
                      </p>
                    </div>
                  </div>
                </div>
              </div>
            </devjsp:forEachListing > 
            </div>
             <a class="carousel-control left" href="#listingsCarousel" data-slide="prev">&lsaquo;</a>
             <a class="carousel-control right" href="#listingsCarousel" data-slide="next">&rsaquo;</a>
          </div>
        </div>
      </div>
      <% }else{ %>
        <div class="shadow">
          <div class="container-fluid">
          <h3>Recently Posted</h3>
          <p><i>    Sorry, but no listings exist at the moment. When they do, you'll be able to cycle through
            recent listings on this panel.</i></p><br><br>
        </div></div>
      <%}%>

      <br>
      <!--My listings portion-->
      <% if (user != null){ %>
      <% if (lis.getArrayListSize() > 0) { %>
      <div class="shadow" style="height:290px">
        <div class="container-fluid">
          <div class="span6">
            <ul class="inline">
              <li><h3>My Listings</h3></li>
              <li><a href="#">View all</a></li>
            </ul>
            <table class="table table-striped">
              <devjsp:forEachListing user="<%=user%>" limit="4" searchTerm="null">
                <tr>
                  <td valign="center">
                    <ul class="inline">
                      <li><p>
                      <a href="item?id=${listingId}">
                         ${listingName} - $${listingPrice} 
                      </a>
                      ${listingUniversity}, ${listingLocation}
                      </p></li>
                      <li class="pull-right">${listingDate}</li>
                    </ul>
                  </td>
                </tr>
              </devjsp:forEachListing>
            </table>
          </div>
          <div class="span1" style="width:1px;height:160px;background-color:gray;float:left;"></div>           
          <div class="span5">
            <h3>Recent Activity</h3>
            <devjsp:printActivities byWhat="university" limit="4" >
              <li><i>${itemActivity}</i></li>
            </devjsp:printActivities>
          </div>
        </div>
      </div>
      <%}}%>  

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