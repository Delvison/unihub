package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

import javax.servlet.annotation.*;

@WebServlet("/clearHistory")
public class ClearHistory extends HttpServlet {
	
	static HttpSession session;

	public void doGet(HttpServletRequest req,
		HttpServletResponse res) throws ServletException, IOException {
		session = req.getSession();
		session.removeAttribute("keywords");
		res.sendRedirect("/unihub/searchHistory");
	}
}	
