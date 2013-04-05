<%@ page import="com.unihub.app.EventListHolder" %>

<%
/*Just gonna initialize my list of events here to output
it nicely*/

EventListHolder holder = EventListHolder.getInstance();

%>


<%@ include file="/delvison/header.jsp" %>

	<body>

		<div class="container-fluid">


			<div class="span8" style="background-color:white">
				<!--This div holds the list of events-->
				<h2>Events</h2>

				<table class="table">

					<% for(int i = 0; i < holder.numOfEvents(); i++) {%>

					<tr>
						<td>
							<h3><%= holder.getEvent(i).getTitle() %></h3>
							<p><%= holder.getEvent(i).getDes() %></p>
							<a href="#">Attending</a> | <a href="#">More Info</a>
						</td>
					</tr>

					<% } %>


				</table>

			</div>

			<div class="span4 login-form" style="background-color:white">
				<!--This div holds a form to submit a new event-->
				<h3>Submit Event</h3>
				<form action="submit-event" method="POST">
					<fieldset>

						<div class="clearfix">
							<input type="text" name="title" placeholder="Title">
						</div>

						<div>
							<input type="text" name="location" placeholder="Location">
						</div>

						<div class="clearfix">
							<input type="text" name="date" placeholder="03/18/90">
						</div>

						<div class="clearfix">
							<input type="text" name="time" placeholder="3:00pm">
						</div>

						<div class="clearfix">
							<TEXTAREA id="description" rows="7" class="span3" 
							placeholder="Description" name="description"></TEXTAREA>
						</div>

						<div class="clearfix">
							<button class="btn btn-primary" type="submit">Submit</button>
						</div>

					</fieldset>
				</form>

			</div>




		</div>



	</body>

</html>