/************
*ANDY'S FILE*
************/
package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.ejb.*;

@WebServlet("/login")
public class Auth extends HttpServlet {
	@EJB 
	Authenticate bean;

	/*
	Purpose of this class is to get the request from a users login
	and authenticate it, then redirect the user to where they were last
	*/
	@Override
	public void doPost(HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String userName = req.getParameter("username");
		String password = req.getParameter("password");

		String servletPath = (session.getAttribute("path_for_login") != null) ?
			((String)session.getAttribute("path_for_login")).replaceFirst("/", "") : "home";

		try 
		{
			if(bean.authenticate(userName, password)) {
				//successfully logged in so create cookie or session
				//also remove calling path since it served its purpose
				session.removeAttribute("path_for_login");
				session.setAttribute("username", userName);


				res.sendRedirect(servletPath);
			}
			else
				res.sendRedirect("login");
		}
		catch(NoSuchAlgorithmException e) {}
		catch(InvalidKeySpecException e) {}

	}//end of doPost method

	/*
	I decided to actually implement a get request for authenticate
	which is only used for making login appear and passing it the right stuff
	like what the previous
	*/
	public void doGet(HttpServletRequest req,
		HttpServletResponse res) throws ServletException, IOException {

		String path = (String)req.getSession().getAttribute("path_for_login");


		if(req.getSession().getAttribute("user") == null) {
			RequestDispatcher dis = req.getRequestDispatcher("login-form");
			dis.forward(req, res);
		} else {
			if(path == null)
				res.sendRedirect("index");
			else
				res.sendRedirect(path.replaceFirst("/", ""));
		}


	}//end of doGet method

}//end class
