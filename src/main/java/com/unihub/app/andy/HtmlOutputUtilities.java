/*********************************************
* utility class used to dynamically generate *
* html like for dynamic <title> tag etc.	 *
*********************************************/
package com.unihub.app;

public class HtmlOutputUtilities {

	public static String bootStrapRow(String mario, String luigi) {

		return "<div class=\"container-fluid\" >"+
					"<div class=\"span5 top-buffer\" style=\"background-color:White\">" +
						"<h4 class=\"cat-title\">"+mario+"</h3>"+
					"</div>" + (luigi != null ? 

					"<div class=\"span5 top-buffer\" style=\"background-color:White\">" +
						"<h4 class=\"cat-title\">"+luigi+"</h3>" : "") +
					"</div>"+

				"</div>";

	}//end of bootStrapRow

	public static String bootStrapRow(String mario) {

		return "<div class=\"row-fluid\">"+
					"<div class=\"span4\" style=\"background-color:White\">" +
						"<h3>"+mario+"</h3>"+
					"</div>"+
				"</div>";
		

	}//end of bootStrapRow


}//end of class