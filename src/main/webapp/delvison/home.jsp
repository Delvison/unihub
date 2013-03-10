<html>
<%@include file="header.jsp" %>


<body>
    <% if (myCookie == null) { %>
    <div class="well well-large">
    <li>No School set yet.
    <% } else { %> 
       <li>Your current university is <%=sc%>
       <li>Your current location is <%=st%>.<br>
    <% } %>
    <div>
    
    <a href="#myModal" role="button" class="btn btn-primary" data-toggle="modal">
        Login Popup Demo</a>
 
    <!--Login Modal Demo -->
    <div id="myModal" class="modal hide fade" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
          aria-hidden="true">×</button>
        <h3 id="myModalLabel">Login</h3>
      </div>
      <div class="modal-body">
        <form action="login" method="POST">
		<label for="username">Username</label>
		<input type="text" name="username"><br>
		<label for="password">Password</label>
		<input type="password" name="password"><br>
        <p>Not a member? <a href="signup">Sign Up Now</a></p>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">
           Close</button>
        <input type="submit" class="btn btn-primary" value="Login">
        </form>
    </div>
</div>
    
</body>
</html>
