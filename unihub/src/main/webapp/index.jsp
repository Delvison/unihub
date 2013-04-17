<!--This shall be our main home screen -->
<%@ page import="com.unihub.app.HtmlOutputUtilities, com.unihub.app.Event, 
				com.unihub.app.Events,
				javax.ejb.*, java.util.ArrayList, javax.naming.InitialContext, 
				com.unihub.app.EventsBean" %>
<%! @EJB Events bean; %>
<%
	/*
	This will temporarily be here since I will get this info from
	the database when its set up*/
	String[] cats = {"Appliances",
    "Art Supplies",
    "Bikes",
    "Books",
    "Cars" ,
    "Cell Phones",
    "Clothes",
    "Computers",
    "Electronics",
    "Freebies",
    "Furniture",
    "Games",
    "Jobs",
    "Music",
    "Musical Instruments",
    "Movies",
    "Pets",
    "Sporting Goods",
    "Wanted",
    "Everything Else.."};

	//EventListHolder holder = EventListHolder.getInstance();
	InitialContext context = new InitialContext();
	bean = (Events) context.lookup("ejb:unihub-ear/unihub-ejb//EventsBean!com.unihub.app.Events");
	ArrayList<Event> list = bean.getEvents();
%>



<%@ include file="/delvison/header.jsp" %>

<body>
	<div class="container-fluid">



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
        </div>
        <br>

        <!-- Cool things about the site -->
        <center>
        <div class="container-fluid">
          <div class="row-fluid span12" style="padding-top:40px padding-bottom:40px">
           <div class="span4">
             <img src="design/images/cap2.png">
             <h3>What is Unihub?</h3>
           </div>
           <div class="span4">
             <img src="design/images/tower2.png">
             <h3>Who is it for?</h3>
           </div>
           <div class="span4">
             <img src="design/images/Book2.png">
             <h3>Why you'll love it!</h3>
           </div>
          </div>
        </div>
        </center>

		<div class="container-fluid">

			<!-- The cool looking  -->
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
			</div>

			<div class="span5 scrollable-table well">
				<h2>Events</h2>
				<table class="table">

					<% for(Event event : list){ %>

						<tr>
							<td>
								<h3><%= event.getTitle() %></h3>
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
							<h4><a href="events">View All</a></h3>
						</td>
					</tr>	

				</table>
			</div>

		</div>

	</div>

</body>

</html>
