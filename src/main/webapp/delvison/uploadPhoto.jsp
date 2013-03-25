<%@include file="header.jsp" %>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<%String id = (String)request.getParameter("id");%>

<body>
  <div class='span6 main' style="background-color:White">
   <center>
  	<h2>Would you like to add a photo?</h2>
  	</center>
    <form action="upload" enctype="multipart/form-data" method="post">
      <input type="file" id="file" name="file" class="span9" >
      <input type="hidden" name="id" value="<%=id%>">
      <input class="btn btn-primary" type="submit" id="upload" value="Upload Now" />
    </form>
    <a href="item?id=<%=id%>">
    	<button class="btn btn-success">skip</button>
    </a>
  </div>
</body>
