/***********************************
*UTILITY METHODS FOR AUTHENTICATION*
*			BY ANDY				   *
************************************/
package com.unihub.app;

import javax.servlet.http.*;

import java.util.Arrays;


public class AuthUtilities {




	public static String isLoggedIn(HttpSession session, HttpServletRequest request) {
		String userName = (String)session.getAttribute("username");
		
			if(userName != null) {
				userName = 
		             "<li class=\"dropdown\">"+
		             "<a class=\"dropdown-toggle\" data-toggle=\"dropdown\" href=\"#\">"+
		             "<i class=\"icon-user\"></i>" + userName +
		             "<span class=\"caret\"></span>" +
		             "</a>" +
		             "<ul class=\"dropdown-menu\">" +
		             "<li><a href=\"profile\">View profile</a></li>" +
		             "<li class=\"divider\"></li>" +
		             "<li><a href=\"logout"+(request.getQueryString() == null ? "" : "?"+request.getQueryString())+"\">Log out</a></li>" +
		             "</li>";
			} else {
				userName = "<li><a href=\"login\">Login</a></li>";
			}

			return userName;
	}



}//end of class
