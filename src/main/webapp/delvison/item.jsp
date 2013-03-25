<!--jsp for individual items-->
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
  <div id='content' class='row-fluid'>
      
      <!--ITEM INFO PANE -->
      <div class='span8 main' style="background-color:White">
              <devjsp:itemInfo itemId="<%=id%>">
                <center><p>
                  <h2>${itemName} - $${itemPrice} (${itemUniversity},
                   ${itemLocation})</h2>
                </p>
                </center>
              </devjsp:itemInfo>
              <devjsp:upvote itemId="<%=id%>" user="<%=user%>" />
              <devjsp:belongsToUser itemId="<%=id%>" user="<%=user%>" />
              <devjsp:itemInfo itemId="<%=id%>">
                <br>
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
      
        <!--SIDEBAR-->
        <% ListingsObj lis = ListingsObj.create();
           if (lis.getStuff(Integer.parseInt(id)).getBidMode().equals("yes")){ %>  
           <%@include file="commentWithBidInclude.jsp" %>
           <% }else{ %>
           <%@include file="commentNoBidInclude.jsp" %>
           <%}%>
  </div>
  <div>
</body>
</html>
