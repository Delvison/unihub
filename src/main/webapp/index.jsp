<!--This shall be our main home screen -->
<%@ page import="com.unihub.app.HtmlOutputUtilities, com.unihub.app.Event" %>
<%
	/*
	This will temporarily be here since I will get this info from
	the database when its set up*/
	String[] cats = new String[] {"Textbooks", "Jobs", "Electronics", "Cars", "Your mom"};

	Event[] events = new Event[] {new Event("Fuck Bitches", "9:00PM", "Pimp Pad", "Come join us to fuck da bitches!"), 
				new Event("Resume Builder", "9:00AM", "OLS", "Cum so we can help you build your resume!"), 
				new Event("Pizza Party", "12:00PM", "Lounge", "After fucking the bitches for hours, come eat to refuel!") };


%>



<%@ include file="/delvison/header.jsp" %>

<body>
	<div class="container-fluid">



		<div class="hero-unit" style="background-color:White">
			<img src="design/images/y_u_no.jpg">
			<%= request.getQueryString() %>
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
					<% for(int i = 0; i < events.length; i++){ %>

						<tr>
							<td>
								<h3><%= events[i].getTitle() %></h3>
								<p><%= events[i].getDes() %></p>
							</td>
						</tr>

					<% } %>

				</table>
			</div>

		</div>




	</div>

</body>

</html>
