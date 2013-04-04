/*
This is my test bean in order to test out whether I can use
the JNDI syntax in order to expose my stuff
*/
package com.unihub.app;

import javax.ejb.*;

@Stateless
public class MyBean {
	private String response = "You succeeded with accessing me ";

	public String getResponse(String name){
		return response + name +"!";
	}//end of getResponse




}//end of class