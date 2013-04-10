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
	String[] cats = new String[] {"Art Supplies", "Books", "Bicycles", "Jobs", 
									"Electronics", "Cars", "Cell Phones", "Furniture", 
									"Musical Instruments", "Misc."};

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

		<div class="container-fluid">
			<div class="span8" style="background-color:white">
				<h2>Classifieds</h2>
				
				<% for(int i = 0; i < cats.length; i++) {
					if(i % 2 == 0) { %>

						<%= 
						HtmlOutputUtilities.bootStrapRow(cats[i], i+1 < cats.length ? cats[i+1]: null) %>
				<%
					}

				} %>

			</div>

			<div class="span4 scrollable-table" style="background-color:white">
				<h2>Events</h2>
				<table class="table">

					<% for(Event event : list){ %>

						<tr>
							<td>
								<h3><%= event.getTitle() %></h3>
								<p>on <%= event.getThingy() %> @<%= event.getTime() %></p>
								<p><%= event.getDes() %></p>
								<p><%= event.howManyGoing() %></p>
								<a href="attend?id=<%=event.getId() %> ">Attending</a> | <a href="#">More Info</a>
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
