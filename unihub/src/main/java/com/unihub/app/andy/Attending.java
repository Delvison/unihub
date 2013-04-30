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
import javax.ejb.*;

@WebServlet("/attend")
public class Attending extends HttpServlet {
	@EJB
	Events bean;

	public void doGet(HttpServletRequest req, 
				HttpServletResponse res) throws ServletException, IOException{

		HttpSession session = req.getSession();
		String servletPath = (session.getAttribute("path_for_login") != null) ?
			((String)session.getAttribute("path_for_login")).replaceFirst("/", "") : "index";

		/*
		If I never got an event id with it
		just redirect back to where they came from
		*/
		String testId = req.getParameter("id");
		
		if(testId == null) {

			res.sendRedirect(servletPath);

		}
		else {

			int id = Integer.parseInt(testId);
			/*
			Check if user is logged in
			if not send to loggin and redirect here as usual*/
			String userName = (String)req.getSession().getAttribute("username");

			if(userName == null) {

				session.setAttribute("path_for_login", "attend?"+req.getQueryString());
				res.sendRedirect("login");

			} else {
				/*Will need to use */
				Dbase dbase = Dbase.create();
				User user = dbase.getUser(userName);

				/*Does nothing for now since I need user*/
				boolean result = bean.attemptAttending(id, userName);

				EventListHolder holder = EventListHolder.getInstance();
				Event event = holder.findEventWithId(id);
				if(event.isAlreadyFollowing(user.getId())) {
					/*
					Already attending so don't add follower
					I'll just redirect wherever they came from*/
					res.sendRedirect(servletPath);

				} else {

					event.addFollower(user.getId());

					res.sendRedirect("events");

				}
				
			}

		}


	}//end of doGet()





}//end of class