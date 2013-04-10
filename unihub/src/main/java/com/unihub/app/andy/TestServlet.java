package com.unihub.app;

/*
My test Servlet just to see if I have the Session Bean set up*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ejb.*;
import java.util.ArrayList;
//import com.unihub.app.Event;
//import com.unihub.app.EventListHolder;

@WebServlet("/testing-my-bean")
public class TestServlet extends HttpServlet {
	@EJB
	Events bean;

	public void doGet(HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException{
		

		ArrayList<Event> list = bean.getEvents();
		Event event = list.get(0);

		PrintWriter out = res.getWriter();

		out.println(event.getTitle());


	}//end of doGet



}//end of class