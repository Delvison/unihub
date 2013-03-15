<%@ page import="com.unihub.app.AuthUtilities" %>
<%@ include file="/delvison/bootstrap.jsp"  %>


<!doctype html>
<html>

<head>
	<title>Login</title>
</head>

<body>

		<div class="container" style="background-color:white">

			<div class="login-form offset4">
				
				<form action="login" method="POST">
					<h2>Login</h2>
					<fieldset>

						<div class="clearfix">
							<input type="text" name="username" placeholder="Username">
						</div>

						<div class="clearfix">
							<input type="password" name="password" placeholder="Password">
						</div>

						<button class="btn btn-primary" type="submit">Sign in</button>

					</fieldset>
				</form>

				   <p>Not a member? <a href="signup">Sign Up Now</a></p>

			</div>

		</div>

</body>

</html>
