<html>
<head>
<%
  String cookieName = "school&state";
  String sc = " "; 
  String st= " ";
  Cookie cookies [] = request.getCookies ();
  Cookie myCookie = null;

  if (cookies != null){
    for (int i = 0; i < cookies.length; i++){
      if (cookies [i].getName().equals (cookieName)){
         myCookie = cookies[i];
         break;
      }
    }
  }
  if (myCookie != null){
  String temp = myCookie.getValue();
  String[] vals = temp.split("&");
  sc = vals[0];
  st = vals[1];
  String userName = (String)session.getAttribute("username");
  }
%>
</head>

  <body>

  <form action="createlisting" method="GET">
    Name of item:<input type="text" name="name" ><br>
    Price of item:<input type="text" name="price" ><br>
    <% if (myCookie == null) { %>
      Location:<input type="text" name="location" ><br>
    <% } else { %> 
      Location: <%=sc%><br>
      <input type="hidden" name="location" value="<%=st%>">
    <% } %>
    <input type="hidden" name="university" value="<%=sc%>">
    <input type="submit" value="Submit">
  </form>
    <br>
    <a href="home"> home</a>
  </body>
