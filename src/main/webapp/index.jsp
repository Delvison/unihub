<!--This shall be our main home screen -->
<%@ page import="com.unihub.app.HtmlOutputUtilities" %>
<%
	String[] cats = new String[] {"Textbooks", "Jobs", "Electronics", "Cars"};
	int counter = 0;
%>



<%@ include file="/delvison/header.jsp" %>

<body>
	<div class="container-fluid">



		<div class="hero-unit" style="background-color:White">
			<img src="design/images/y_u_no.jpg">
		</div>


		

			<% for(int i = 0; i < cats.length; i++) {
				if(i % 2 == 0) { %>

					<%= HtmlOutputUtilities.bootStrapRow(cats[i], cats[i+1]) %>
			<%
				}

			} %>




	</div>

</body>

</html>
