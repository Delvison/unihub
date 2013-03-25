/*
Servlet that its whole purpose in life is to take an event id,
find it in the array list of events then add the user that will be attending.

When the database is set up this will be as easy as just adding the association
to a table to easily query users following a specifc event
*/

package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/attend")
public class Attending extends HttpServlet {

	public void doGet(HttpServletRequest req, 
				HttpServletResponse res) throws ServletException, IOException{

		int id = Integer.parseInt(req.getParameter("id"));
		Dbase dbase = Dbase.create();
		User user = dbase.getUser((String)req.getSession().getAttribute("username"));

		EventListHolder holder = EventListHolder.getInstance();
		Event event = holder.findEventWithId(id);
		event.addFollower(user.getId());

		res.sendRedirect("index");




	}//end of doGet()





}//end of class