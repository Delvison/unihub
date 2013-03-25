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



		<div class="hero-unit" style="background-color:White">
                        <table width="100%">
                          <tr>
                            <td>
			    <img src="design/images/y_u_no.jpg">
                            </td>
                            <td style="padding:30px">
			    <h1>WELCOME TO UNIHUB</h1>
			    <p>Want a less sketchy classified directory tailored for the college student? 
			    	    <a href="signup">Sign Up!</a>
			    </p>
                            </td>
                          </tr>
                        </table>
		</div>


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

			<div class="span4" style="background-color:white">
				<h2>Events</h2>
				<table class="table">

					<% for(int i = 0; i < holder.numOfEvents(); i++){ %>

						<tr>
							<td>
								<h3><%= holder.getEvent(i).getTitle() %></h3>
								<p><%= holder.getEvent(i).getDes() %></p>
								<p> Following=<%= holder.getEvent(i).printFollowers() %></p>
								<a href="#">Attending</a> | <a href="#">More Info</a>
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
