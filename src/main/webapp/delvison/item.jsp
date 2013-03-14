<!--jsp for individual items-->
<head>
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
</head>    

<body>
  <div id='content' class='row-fluid'>
      
      <!--ITEM INFO PANE -->
      <div class='span8 main' style="background-color:White">
              <devjsp:itemInfo itemId="<%=id%>">
                <center><p>
                  <h2>${itemName} - $${itemPrice} (${itemUniversity},
                   ${itemLocation})</h2><br>
                </center><p>
                <i>Category:</i> ${itemCategory}<br>
                <i>Posted ${itemTime} by</i> <a href="profile">${itemUser}</a>
              </devjsp:itemInfo >
              
              <div class="accordion" id="accordion2">
                <div class="accordion-group">
                  <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse" 
                       data-parent="#accordion2" href="#collapseOne">
                         Images
                    </a>
                  </div>
                  <div id="collapseOne" class="accordion-body collapse">
                    <div class="accordion-inner">
                      <!-- PLACE IMAGE THuMBNAILS IN HERE -->
                        <ul class="thumbnails">
                          <li class="span3">
                            <a href="listings/1/1.jpg" rel="lightbox" class="thumbnail">
                              <img src="listings/1/1.jpg"  rel="lightbox">
                            </a>
                          </li>
                          <li class="span3">
                            <a href="listings/1/2.jpg" rel="lightbox" class="thumbnail">
                              <img src="listings/1/2.jpg" rel="lightbox">
                            </a>
                          </li>
                          <li class="span3">
                            <a href="listings/1/3.jpg" rel="lightbox" class="thumbnail">
                              <img src="listings/1/3.jpg" rel="lightbox">
                            </a>
                          </li>
                        </ul>
                    </div>
                  </div>
                </div>
              </div>
              <div class="accordion" id="accordion3">
                <div class="accordion-group">
                  <div class="accordion-heading">
                    <a class="accordion-toggle" data-toggle="collapse"
                       data-parent="#accordion3" href="#collapseTwo">
                       Description
                    </a>
                  </div>
                  <div id="collapseTwo" class="accordion-body collapse in">
                    <div class="accordion-inner">
                      <devjsp:itemInfo itemId="<%=id%>">
                        <p>${itemDescription}</p>
                      </devjsp:itemInfo >
                    </div>
                  </div>
                </div>
              </div>               
        </div>
      
      <!--<div name="side-panel">-->
        <!--BID DIV GOES HERE -->  
        <!--COMMENTS PANE-->
        <div class='span4 sidebar' style="background-color:White">
            <center><h2>Comments</h2></center>
              <!--section that displays comments posted-->
              <div name="displayComments">
                  <i class="icon-user"></i><a href="#">sketchyBuyer1:</a> 
                     <i> sell for $2?</i><hr>
                  <devjsp:forEachComment itemId="<%=id%>" >
                     <p>
                      <i class="icon-user"></i><a href="#">${commentsUser}:</a> 
                      <i>${theComment}</i>
                     </p>
                     <hr>
                  </devjsp:forEachComment>
              </div>
            
              <!--section where a comment can be posted -->
              <div name="postComments">
                <FORM ACTION="addcomment" METHOD="get">
                  <center>
                    <textarea name="comment" style="width:260px;height:70px" 
                               placeholder="Post Comment"></textarea>
                    <input type="hidden" name="user" value="<%=user%>">
                    <input type="hidden" name="itemId" value="<%=id%>">
                    <devjsp:cmntUser user="<%=user%>" />
                    <a href="#processComment" role="button" class="btn btn-primary" 
                      data-toggle="modal">Comment</a>
                  </center>
                  <!-- popup that confirms comment -->
                  <div id="processComment" class="modal hide fade" role="dialog"
                     aria-labelledby="myModalLabel" aria-hidden="true">
                    <div class="modal-header">
                      <h3 id="myModalLabel">Post Comment</h3>
                    </div>
                    <div class="modal-body">
                      <%if (user != null) {%>
                        <p>Are you sure you want to post this comment?</p>
                      <%}else{%>
                        <p>Sorry, but you are not logged in :(</p>
                      <%}%>
                    </div>
                    <div class="modal-footer">
                      <button class="btn" data-dismiss="modal" aria-hidden="true">
                        Cancel</button>
                      <%if (user != null) {%>
                        <input type="submit" class="btn btn-primary" value="Comment">
                      <%}else{%>
                        <a class="btn btn-primary" href="login">Login</a>
                      <%}%>
                      </FORM>
                    </div>
              </div>      
        </div> <!--COMMENT PANE DIV-->
      <!--</div> <!--WHOLE SIDE PANE DIV-->
  </div>
  
  <div>
</body>
</html>
