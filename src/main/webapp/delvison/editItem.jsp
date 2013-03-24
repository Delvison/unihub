<!-- jsp to edit a listing -->

    <script type="text/javascript" src="design/bootstrap/js/lightbox.js"></script>
    <link rel="stylesheet" type="text/css" href="design/bootstrap/css/lightbox.css" ></link>
    <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.CommentObj,
             com.unihub.app.Comment, com.unihub.app.Stuff, java.util.*" %>
    <%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="header.jsp" %>
    <%@ page isELIgnored="false" %>
    

    <% 
    String user = (String)session.getAttribute("username");
    String id = (String)request.getParameter("id");
    String path = application.getRealPath("/");
    %>   

<body>
<center>
<div class="row-fluid">
  <div class='span12'>
    
    <!--Listings Pane -->
    <div style="background-color:White" class="span6">
      <h2>Edit your Listing</h2>
      <div class="span10">
      <devjsp:itemInfo itemId="<%=id%>">
        <form class="form-horizontal" action="createlisting" method="GET">
          <div class="control-group">
            <label class="control-label" for="location">Location</label>
            <div class="controls">        
                <input id="location" class="span9" type="text" value="${itemUniversity}, ${itemLocation}" disabled>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="category">Category</label>
            <div class="controls">
              <select name = "category" id="category" class="span9" value="${itemCategory}">
                <devjsp:catOptions category="${itemCategory}" />
              </select>
            </div>
          </div>            
          <div class="control-group">
            <label class="control-label" for="name">Name</label>
            <div class="controls">
              <input type="text" id="name"  value="${itemName}" class="span9" name="name">
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="prependedInput">Price</label>
            <div class="controls">
              <div class="input-prepend span10 offset1">
                <span class="add-on">$</span>
                <input id="prependedInput" type="text" class="span10" name="price" value="${itemPrice}">
              </div>
            </div>
          </div>
          <div class="control-group">
            <label class="control-label" for="bid">Bid Mode</label>
            <div class="controls">
              <select name = "bid" id="bid" class="span9" value="${itemBidMode}">
                <devjsp:bidOptions option="${itemBidMode}" />
              </select>
                <p style="font-size:xx-small">
                <i>Bid starts at price mentioned above</i></p>
              </div>
            </div>
          <div class="control-group">
            <label class="control-label" for="description">Description</label>
            <div class="controls">
              <TEXTAREA id="description" rows="7" class="span9"  name="description">${itemDescription}</TEXTAREA>
            </div>
          </div>
          <input type="hidden" name="location" value="${itemLocation}">
          <input type="hidden" name="university" value="${itemUniversity}">
          <input type="hidden" name="id" value="${itemId}">
          <center><input type="submit" value="Submit Changes" class="btn btn-primary btn-large"></center>
       </form>

      </devjsp:itemInfo >

     </div>
      </div>
      
      <!--Image Pane-->
      <div class='span4 sidebar' style="background-color:White">
        <h2>Photos</h2>
          <img data-src="holder.js/300x200" alt="">
          <form id="picForm" action="FileUploadServlet" enctype="multipart/form-data" method="post">
            <input type="file" id="FileUploadId" name="upload" class="span9" >
            <input type="submit" id="uploadButtonId" value="Upload Now" />
          </form>
      </div>

  </div>
</div>
</center>
</body>
</html>