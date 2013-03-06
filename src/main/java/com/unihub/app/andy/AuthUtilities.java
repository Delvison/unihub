/***********************************
*UTILITY METHODS FOR AUTHENTICATION*
*			BY ANDY				   *
************************************/
package com.unihub.app;

import javax.servlet.http.*;

public class AuthUtilities {

	public static boolean authenticate(String userName, String password) {
		/*
		Ideally I will add better error checking, 
		but this is good enough for a simple example
		*/
		if((userName == null || password == null) || 
			(userName.equals("") || password.equals("")))
			return false;
		else
			return true;

	}//end of authenticate method

	public static String isLoggedInForLogin(HttpSession session) {
		String userName = (String)session.getAttribute("username");
			if(userName != null)
				userName = "<h1>You are already logged in as "+userName+"</h1>";
			else
				userName = "";

			return userName;
	}//end of isloggedIn

	public static String isLoggedIn(HttpSession session) {
		String userName = (String)session.getAttribute("username");
			if(userName != null)
				userName = "You are logged in as <a href='profile'>"+
					userName + "</a> | " +
					"<a href='logout'>Logout :(</a>";
			else
				userName = "<a href=\"login\">Login</a>";

			return userName;
	}




}//end of class
