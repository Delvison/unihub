package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet("/logout")
public class Logout extends HttpServlet {

	public void doGet(HttpServletRequest req, 
		HttpServletResponse res) throws ServletException, IOException {

		HttpSession session = req.getSession();
		String servletPath = 
			((String)session.getAttribute("path_for_login")).replaceFirst("/","");
		session.invalidate();

		res.sendRedirect(servletPath);

	}//end of doGet

}//end class