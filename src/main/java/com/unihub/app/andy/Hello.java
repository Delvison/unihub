package com.unihub.app;

import javax.jws.WebService;
import javax.jws.WebMethod;

@WebService
public class Hello {

	private String message = new String("Hello, ");

	public void Hello() {}

	@WebMethod
	public String sayHello(String name) {
		return message + name + ".";
	}


}//end of class