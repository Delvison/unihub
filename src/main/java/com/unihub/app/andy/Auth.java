/************
*ANDY'S FILE*
************/
package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/authenticate")
public class Auth extends HttpServlet {
	/*
	Purpose of this class is to get the request from a users login
	and authenticate it, then redirect the user to where they were last
	*/
	@Override
	public void doPost(HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {

		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		String servletPath = 
			((String)req.getSession().getAttribute("path_for_login")).replaceFirst("/", "");

		if(AuthUtilities.authenticate(userName, password)) {
			//successfully logged in so create cookie or session
			//also remove calling path since it served its purpose
			req.getSession().removeAttribute("path_for_login");
			req.getSession().setAttribute("username", userName);
			res.sendRedirect(servletPath);
		}
		else
			res.sendRedirect("login.jsp");


	}//end of doPost method


}//end class