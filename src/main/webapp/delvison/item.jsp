<!--to replace ItemServlet-->
<html>
  <head>
  <%
    /* get id from url */
    String id = (String)request.getParameter("id");
    int x = Integer.valueOf(id);
    /* get listingobj */
    ListingsObj lis = ListingsObj.create();
    /* find 'Stuff' by id */
    Stuff stuf = lis.getStuff(x);
    
    String name = stuf.name;
    String price = stuf.price;
    String user = stuf.user;
    String university = stuf.university;
    String location = stuf.location;
  %>
  </head>
  
  <body>
    <h2><%=name%></h2>
  </body>


</html>
