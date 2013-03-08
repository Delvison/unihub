  <!--import twitter bootstrap css and js-->
  <link rel="stylesheet" type="text/css" href="design/bootstrap/css/bootstrap.min.css" ></link>
  <script language="JavaScript" type="text/JavaScript" src="design/bootstrap/js/bootstrap.js"></script>
  <script src="design/jquery-1.9.1.js"></script>
  <script src="design/bootstrap/js/bootstrap-dropdown.js"></script>
  
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
      <a href="home"><img style="width:165px;height:45px"src="design/images/logo.png"></a>
    </div>
    <br>
    <hr>
    <div align="right" style="float:right; text-align:right;" >
      <ul class="nav">
        <li><a href="google.jsp">Search</a></li> 
             <% if (myCookie == null) { %>
               <li><a href="populateUniversities">Set school</a></li>
             <% } else { %> 
               <li><a href="populateUniversities">Change school</a></li>
             <% } %>
               <li><a href="validate?where=/createpost">Post a listing</a></li>
               <li><a href="viewalllistings">View all listings</a></li>  
             <% if (user == null) { %>
               <li><a href="login">Login</a></li>
             <% }else{ %>
             <li>
               <li class="dropdown">
               <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                 <i class="icon-user"></i> <%=user%>
                 <span class="caret"></span>
               </a>
               <ul class="dropdown-menu">
                 <li><a href="profile">View profile</a></li>  
                 <li class="divider"></li>
                 <li><a href="logout">Log out</a></li>
             </li>
           </ul>
             <%}%>
        </ul>
    </div>
  </div>
</div>
