<html>
<head>
	<%!
		public String isLoggedIn(HttpSession session) {
			String userName = (String)session.getAttribute("username");
			if(userName != null)
				userName = "You are logged in as "+userName+ " "+
				"<a href='logout'>Logout :(</a>";
			else
				userName = "<a href=\"login\">Login</a>";

			return userName;
		}
	%>
	<title>Home</title>
</head>
<body>
	<h3><%= isLoggedIn(session) %></h3>
	<CENTER>
	<h2>Welcome to UniHub!</h2>

	<FORM ACTION="URL HERE" METHOD="GET" >
	<INPUT TYPE="hidden" name="" value="">
	<INPUT TYPE="text" name="q" >

	<INPUT TYPE="SUBMIT"><BR>

	</FORM>
	</CENTER>

</body>

</html>
