<div class="navbar">
  <div class="navbar-inner">
    <div style="float:left; text-align:left;">
      <a href="index"><img style="width:140px;height:35px"src="design/images/logo.png"></a>
    </div>
    <div align="right" style="float:right; text-align:right;" >
      <ul class="nav">
        <li><a href="google.jsp">Search</a></li> 
             <% if (myCookie == null) { %>
               <li><a href="populateUniversities">Set school</a></li>
             <% } else { %> 
               <li><a href="populateUniversities">Change school</a></li>
             <% } %>
               <li><a href="validate?where=/createpost">Post a listing</a></li>
               <li><a href="viewalllistings?cat=All">View all listings</a></li>
               <li><a href="user?u_id=all">Browse users</a></li>
        <li>
             <%= AuthUtilities.isLoggedIn(session) %>
        </ul>
    </div>
  </div>
</div>
