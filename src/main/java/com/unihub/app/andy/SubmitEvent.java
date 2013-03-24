/*
Servlet that its whole purpose in life is to 
get the info from a submitted event and add it to the list of events
whether it be in the Singleton or database
*/
package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/submit-event")
public class SubmitEvent extends HttpServlet {

	public void doPost(HttpServletRequest req, 
					HttpServletResponse res) throws ServletException, IOException {



		EventListHolder holder = EventListHolder.getInstance();

		String title = (String)req.getParameter("title");
		String location = (String)req.getParameter("location");
		String description = (String)req.getParameter("description");

		holder.addEvent(title, location, "9:00pm", description);

		res.sendRedirect("events");


	}//end of doPost




}//end of class