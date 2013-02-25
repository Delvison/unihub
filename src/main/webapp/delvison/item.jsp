<!--delvison-->
<!--to replace ItemServlet after hw2-->
<html>
  <head>

    <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.Stuff, java.util.*" %>
    <%
      /* get id from url */
      String id = (String)request.getParameter("id");
      int x = Integer.valueOf(id);
      /* get listingobj */
      ListingsObj lis = ListingsObj.create();
      /* find 'Stuff' by id */
      Stuff stuff = lis.getStuff(x);
    
      String name = stuff.name;
      String price = stuff.price;
      String usr = stuff.user;
      String university = stuff.university;
      String location = stuff.location;
  %>
  <%@include file="header.jsp" %>
  </head>
  
  <body>
  
    <div id="info">
      <a>Name: <%=name%> - <%=price%>
      <br><a>Owner: <%=usr%>
      <br><a>University: <%=university%>, <%=location%>
    </div>

    <div id="addcomment">
      <!--add form here -->
      <!--upon submit, forward to a controller java class
          that will process the comment posted -->
    </div>
    
    <div id="displaycomments">
      <!-- java controller will feed in the date. display 
           comments here-->
    </div>
      
  </body>


</html>
