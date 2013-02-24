<%@ page import="com.unihub.app.AuthUtilities" %>
<% 
	/*this part is a special case for login
	incase user goes straight to login*/
	if((String)session.getAttribute("path_for_login") == null)
		session.setAttribute("path_for_login", request.getServletPath());
%>

<!doctype html>
<html>

<head>
	<title>Login</title>
</head>

<body>
	<%= AuthUtilities.isLoggedInForLogin(session) %>
	<form action="authenticate" method="POST">
		<label for="username">Username</label>
		<input type="text" name="username"><br>
		<label for="password">Password</label>
		<input type="password" name="password"><br>
		<input type="submit" value="login">
	</form>

	<p><%= request.getServletPath() %></p>
</body>

</html>