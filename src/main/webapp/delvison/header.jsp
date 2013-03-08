  <!--import twitter bootstrap css and js-->
  <link rel="stylesheet" type="text/css" href="http://localhost:8080/unihub/design/bootstrap/css/bootstrap.min.css" ></link>
  <script language="JavaScript" type="text/JavaScript" src="http://localhost:8080/unihub/design/bootstrap/js/bootstrap.js"></script>
  <script src="http://localhost:8080/unihub/design/jquery-1.9.1.js"></script>
  <script src="http://localhost:8080/unihub/design/bootstrap/js/bootstrap-dropdown.js"></script>
  
<!---##############JAVA PORTION###############################-->
<%
session.setAttribute("path_for_login", request.getServletPath());
%>
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
<% String user = isLoggedIn(session);%>
<!---##############JAVA PORTION END###############################-->
  
<div class="navbar">
  <div class="navbar-inner">
    <div style="float:left; text-align:left;">
      <a href="home"><img style="width:150px;height:45px"src="http://localhost:8080/unihub/design/images/logo.png"></a>
    </div>
    <div align="right" style="float:right; text-align:right;" >
      <table border="0" cellpadding="2" cellspacing="2">
      <tr><td valign="baseline">
        <a href="google.jsp">Search</a> |
         <% if (myCookie == null) { %>
               <a href="populateUniversities">Set school</a> |
             <% } else { %> 
               <a href="populateUniversities">Change school</a> |
             <% } %>
               <a href="validate?where=/createpost">Post a listing</a> |
               <a href="viewalllistings">View all listings</a>  
             <% if (user == null) { %>
               <a href="login" class="btn">Login</a> 
               </td>
             <% }else{ %>
             <td>
             <div class="btn-group pull-right">
               <a class="btn dropdown-toggle" data-toggle="dropdown" href="#">
                 <i class="icon-user"></i><%=user%>
                 <span class="caret"></span>
               </a>
               <ul class="dropdown-menu">
                 <li><a href="profile">View profile</a></li>  
                 <li class="divider"></li>
                 <li><a href="logout">Log out</a></li>
               </ul>
             </div>
             <%}%>
             </td>
        </tr>
      </table>
    </div>
  </div>
</div>
