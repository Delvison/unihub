/*********************************************
* utility class used to dynamically generate *
* html like for dynamic <title> tag etc.	 *
*********************************************/
package com.unihub.app;

public class HtmlOutputUtilities {

	public static String bootStrapRow(String mario, String luigi) {

		return "<div class=\"span3 top-buffer\" style=\"background-color:#DBDBDB\">" +
						"<h4 class=\"cat-title\"><a href=\"viewalllistings?cat="+mario+"\">"+mario+"</a></h4>"+
					"</div>" + (luigi != null ? 

					"<div class=\"span3 top-buffer\" style=\"background-color:#DBDBDB\">" +
						"<h4 class=\"cat-title\"><a href=\"viewalllistings?cat="+luigi+"\">"+luigi+"</a></h4> </div>" : "");

	}//end of bootStrapRow

	public static String bootStrapRow(String mario) {

		return "<div class=\"row-fluid\">"+
					"<div class=\"span4\" style=\"background-color:White\">" +
						"<h3>"+mario+"</h3>"+
					"</div>"+
				"</div>";
		

	}//end of bootStrapRow


}//end of class