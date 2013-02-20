/************
*ANDY'S FILE*
************/
package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Auth extends HttpServlet {
	/*
	Purpose of this class is to get the request from a users login
	and authenticate it, the redirect to wherever the user needs to go
	*/
	@Override
	public void doPost(HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {

		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		if(AuthUtilities.authenticate(userName, password)) {
			//successfully logged in so create cookie or session
			req.getSession().setAttribute("username", userName);
			res.sendRedirect("index.jsp");
		}
		else
			res.sendRedirect("login.jsp");


	}//end of doPost method


}//end class