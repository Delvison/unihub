<!-- jsp to create a listing -->

<%@include file="header.jsp" %>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<body>
<center>
<div class="row-fluid">
  <div class='span12'>
    
    <!--Listings Pane -->
    <div style="background-color:White" class="span10 offset1">
      <h2>Sell Your Stuff!</h2>
      <div class="span10">
        <form class="form-horizontal" action="createlisting" method="GET">
          <center>
          <div class="alert alert-block span11 offset1">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
            <strong>Hey!</strong> Before you make a sale, here are some guidelines.
              Please be advised that UniHub does not encourage nor endorse any online
              transactions. For your convenience and security, it is recommended that
              all exchanges be done in person and in a public setting. Be sure to agree
              on a solid meeting time and place and always bring a friend. Watch out
              for lowballers and study hard!
          </div>
          </center>
          <div class="control-group">
            <label class="control-label" for="location">Location</label>
            <div class="controls">        
              <% if (myCookie == null) { %>
                <a class="span9" href="cookieform.jsp" id="location">Location not set</a><br>
              <% } else { %> 
                <input id="location" class="span9" type="text" placeholder="<%=sc%>" disabled>
              <% } %>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="category">Category</label>
            <div class="controls">
              <select name = "category" id="category" class="span9">
                <devjsp:catOptions />
              </select>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="name">Name</label>
            <div class="controls">
              <input type="text" id="name" placeholder="Name" class="span9" name="name">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="prependedInput">Price</label>
            <div class="controls">
              <div class="input-prepend span10 offset1">
                <span class="add-on">$</span>
                <input id="prependedInput" type="text" class="span10" name="price">
              </div>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="bid">Bid Mode</label>
            <div class="controls">
              <select name = "bid" id="bid" class="span9">
                <devjsp:bidOptions />
              </select>
               <p style="font-size:xx-small">
                <i>Bid starts at price mentioned above</i></p>
              </div>
            </div>
          <div class="control-group">
            <label class="control-label" for="description">Description</label>
            <div class="controls">
              <TEXTAREA id="description" rows="7" class="span9" placeholder="Description" name="description"></TEXTAREA>
            </div>
          </div>
          <input type="hidden" name="location" value="<%=st%>">
          <input type="hidden" name="university" value="<%=sc%>">
          <center><input type="submit" value="Sell my stuff" class="btn btn-primary btn-large"></center>
       </form>
     </div>
      </div>
  </div>
</div>
</center>
</body>
</html>

