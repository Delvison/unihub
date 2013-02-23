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
<%!
public String isLoggedIn(HttpSession session) {
	String userName = (String)session.getAttribute("username");
	  return userName;	}
%>

  <p>	
  <div style="float:left; text-align:left;">
    <b>UniHub</b>
  </div>      
  <div align="right" style="float:right; text-align:right;">
    <a href="home">Home</a> |
    <a href="google.jsp">Search</a> |
    <% if (myCookie == null) { %>
       <a href="cookieform.jsp">Set school</a>
    <% } else { %> 
       <a href="cookieform.jsp">Change school</a>
    <% } %>
      | <a href="validate?where=createpost">Post a listing</a>
      | <a href="viewalllistings">View all listings</a>
      | <% String user = isLoggedIn(session);  %>
      <% if (user == null) { %>
        <a href="login">Login</a>
      <% }else{ %>
        <a href="profile.jsp">View profile</a>
        | <a href="logout.jsp">Log out(<%=user%>)</a>
      <%}%>
    </div>
    <br>
    <hr>

