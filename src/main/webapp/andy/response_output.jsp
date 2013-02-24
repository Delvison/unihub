<% 
String[] linkArray = (String[])request.getAttribute("links"); 
if(linkArray == null)
	linkArray = new String[0];
%>

<!doctype html>
<html>

<head>
	<title>Le title</title>
</head>

<body>

	<h1><%= (linkArray.length == 0)? "Oh No!":"Your List!" %></h1>

	<ul>
		<% for(String link : linkArray) { %>
			<li><%= link %></li>
		<% } %>
	</ul>


</body>

</html>