<% String[] linkArray = (String[])request.getAttribute("links"); %>
<!doctype html>
<html>

<head>
	<title>Le title</title>
</head>

<body>

	<h1>Your List!</h1>

	<ul>
		<% for(String link : linkArray) { %>
			<li><%= link %></li>
		<% } %>
	</ul>


</body>

</html>