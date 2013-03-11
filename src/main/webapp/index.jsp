<!--This shall be our main home screen -->
<%@ page import="com.unihub.app.HtmlOutputUtilities" %>
<%
	/*
	This will temporarily be here since I will get this info from
	the database when its set up*/
	String[] cats = new String[] {"Textbooks", "Jobs", "Electronics", "Cars", "Your mom"};
%>



<%@ include file="/delvison/header.jsp" %>

<body>
	<div class="container-fluid">



		<div class="hero-unit" style="background-color:White">
			<img src="design/images/y_u_no.jpg">
		</div>


		

			<% for(int i = 0; i < cats.length; i++) {
				if(i % 2 == 0) { %>

					<%= 
					HtmlOutputUtilities.bootStrapRow(cats[i], i+1 < cats.length ? cats[i+1]: null) %>
			<%
				}

			} %>




	</div>

</body>

</html>
