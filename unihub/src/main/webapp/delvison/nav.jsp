<div class="navbar"  style="margin-bottom: 0px">
  <div class="navbar-inner">
    <div style="float:left; text-align:left;">
      <a href="index"><img style="width:140px;height:35px"src="design/images/logo.png"></a>
    </div>
    <div>
      <ul class="nav pull-right">
             <% if (myCookie == null) { %>
               <li><a href="populateUniversities">Set school</a></li>
             <% } else { %> 
               <li><a href="populateUniversities">Change school</a></li>
             <% } %>
               <li><a href="events">Events</a></li>
               <li class="dropdown">
                 <a class="dropdown-toggle" data-toggle="dropdown" href="#">Listings
                    <span class="caret"></span>
                  </a>
                  <ul class="dropdown-menu">
                    <li><a href="validate?where=/createpost">Post a listing</a></li>
                    <li><a href="viewalllistings?cat=All">View all listings</a></li>
                  </ul>
                </li>
               <li><a href="user?u_id=all">Browse users</a></li>
        <li>
             <%= AuthUtilities.isLoggedIn(session, request) %>
        </ul>
      <!--Nav under 940px-->
        <div class="nav-collapse collapse">
        </div>
    </div>
  </div>
</div>
