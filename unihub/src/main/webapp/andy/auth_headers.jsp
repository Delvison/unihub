<%--This jsp is literally just to maintain my specific auth headers
	and to take away any complexity from everybody elses code so they 
	don't have to do anything more--%>
<% 
	if(!request.getServletPath().equals("/login"))
		session.setAttribute("path_for_login", request.getServletPath());

	if(request.getQueryString() != null) {
		String tempPath = (String)session.getAttribute("path_for_login");
		session.setAttribute("path_for_login", tempPath+"?"+request.getQueryString());
	}
 %>
