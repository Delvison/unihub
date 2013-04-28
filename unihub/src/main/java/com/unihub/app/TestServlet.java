package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.ejb.*;
import com.unihub.app.MyEntity;

@WebServlet("/test-entities")
public class TestServlet extends HttpServlet {
	@EJB 
	HelloServiceInterface bean;




	public void doGet(HttpServletRequest req,
		HttpServletResponse res) throws ServletException, IOException {

		
		PrintWriter out = res.getWriter();
		//out.println(bean.sayHello());

		MyEntity e = new MyEntity("Hello","en");
		bean.create(e);


		out.println("Did yo shit");

	}//end of doGet method






}//end of class