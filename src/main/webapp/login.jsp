<!doctype html>
<html>
<head>
	<title>Login</title>
	<%!
		public String isLoggedIn(HttpSession session) {
			String userName = (String)session.getAttribute("username");
			if(userName != null)
				userName = "<h1>You are already logged in as "+userName+"</h1>";
			else
				userName = "";

			return userName;
		}
	%>
</head>
<body>
	<%= isLoggedIn(session) %>
	<form action="authenticate" method="POST">
		<label for="username">Username</label>
		<input type="text" name="username"><br>
		<label for="password">Password</label>
		<input type="password" name="password"><br>
		<input type="submit" value="login">
	</form>
</body>
</html>