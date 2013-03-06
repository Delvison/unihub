<%--This jsp is literally just to maintain my specific auth headers
	and to take away any complexity from everybody elses code so they 
	don't have to do anything more--%>
<% 

String path = request.getServletPath();

if(path.equals("/login")) {
	/*this part is a special case for login
	incase user goes straight to login*/
	if((String)session.getAttribute("path_for_login") == null)
		session.setAttribute("path_for_login", "/home");

} else {

	session.setAttribute("path_for_login", path); 
}

%>