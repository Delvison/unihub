<%@ page import="com.unihub.app.AuthUtilities" %>


<!doctype html>
<html>

<head>
	<title>Login</title>
</head>

<body>
	
	<form action="login" method="POST">
		<label for="username">Username</label>
		<input type="text" name="username"><br>
		<label for="password">Password</label>
		<input type="password" name="password"><br>
		<input type="submit" value="login">
	</form>
        <p>Not a member? <a href="signup">Sign Up Now</a></p>

	<p><%= session.getAttribute("user") %></p>
</body>

</html>
