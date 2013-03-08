<%--This jsp is literally just to maintain my specific auth headers
	and to take away any complexity from everybody elses code so they 
	don't have to do anything more--%>
<% session.setAttribute("path_for_login", request.getServletPath()); %>