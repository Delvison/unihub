<%@ page import="com.unihub.app.Events, com.unihub.app.Event, com.unihub.app.EventsBean,
					javax.ejb.*, javax.naming.InitialContext, java.util.ArrayList" %>

<%! @EJB Events bean; %>
<%
/*Just gonna initialize my list of events here to output
it nicely*/
InitialContext context = new InitialContext();
bean = (Events)context.lookup("ejb:unihub-ear/unihub-ejb//EventsBean!com.unihub.app.Events");
ArrayList<Event> holder = bean.getEvents();
//EventListHolder holder = EventListHolder.getInstance();

%>


<%@ include file="/delvison/header.jsp" %>

	<body>

		<div class="container-fluid">


			<div class="span8" style="background-color:white">
				<!--This div holds the list of events-->
				<h2>Events</h2>

				<table class="table">

					<% for(Event event : holder) {%>

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
							<input type="text" name="date" placeholder="03/18/2013" id="datepicker">
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