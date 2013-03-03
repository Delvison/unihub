<%@ page import="com.unihub.app.AuthUtilities, com.unihub.app.Dbase" %>
<% session.setAttribute("path_for_login", request.getServletPath()); %>

<% // Mark's silly database object (remove when actual db is implemented)
session.setAttribute("dbase", new Dbase()); %>

<html>
<head>

	<title>Home</title>
</head>
<body>
	<h3><%= AuthUtilities.isLoggedIn(session) %></h3>
	<CENTER>
	<h2>Welcome to UniHub! <%= request.getServletPath() %></h2>

	<form ACTION="le_test" METHOD="POST">
		<input TYPE="text" name="query">
		<input TYPE="submit" value="Search"><br>
	</form>
	</CENTER>
    <hr>
    <a href = "home">home</a>
</body>

</html>
