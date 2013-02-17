<%@ page language="java" %>
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
}
%>



<html>
<body>
<p>
<a href="google.jsp">Search</a> |
<% if (myCookie == null) { %>
<a href="cookieform.jsp">Set School</a>
<% } else { %> 
<a href="cookieform.jsp">Change School</a>
<% } %>
| <a href="login.jsp">login</a>
<br>
<% if (myCookie == null) { %>
<li>No School set yet.
<% } else { %> 
<li>Your current university is <%=sc%>
<li>Your current location is <%=st%>.<br>
<% } %>
</body>
