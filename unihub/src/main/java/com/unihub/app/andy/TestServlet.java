package com.unihub.app;

/*
My test Servlet just to see if I have the Session Bean set up*/

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ejb.*;

@WebServlet("/testing-my-bean")
public class TestServlet extends HttpServlet {
	@EJB
	TestInterface bean;

	public void doGet(HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException{
		

		String result = bean.getResponse("Andy");


		PrintWriter out = res.getWriter();

		out.println(result);


	}//end of doGet



}//end of class