/***********************************
*UTILITY METHODS FOR AUTHENTICATION*
*			BY ANDY				   *
************************************/
package com.unihub.app;

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


}//end of class