<!--jsp for individual items-->
<head>
   <!--IMPORTS-->
    <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.CommentObj,
             com.unihub.app.Comment, com.unihub.app.Stuff, java.util.*" %>
    <%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp" %>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    <%@include file="header.jsp" %>
    <%@ page isELIgnored="false" %>
    
   <!--GET VARIABLES NEEDED-->
    <% 
    String user = (String)session.getAttribute("username");
    String id = (String)request.getParameter("id");
     %>
</head>    

<body>
  <div id='content' class='row-fluid'>
      
      <!--ITEM INFO PANE -->
      <div class='span8 main' style="background-color:White">
       <table class="span9">
         <tr>
           <td>
              <devjsp:itemInfo itemId="<%=id%>">
                <p>
                  <h2>${itemName}</h2><br>
                  Price: $${itemPrice}<br>
                  Owner: ${itemUser}<br>
                  Category: ${itemCategory}<br>
                  Time Posted: ${itemTime}<br>
                  University: ${itemUniversity}, ${itemLocation}<br>
                  Bid Mode?: ${itemBidMode}<br>
                  Description: ${itemDescription}<br>
                </p>
              </devjsp:itemInfo >
           </td>
           <td align="right">
             <img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRkY31DVjEblSBHJnqrxLCWO3U4PRXcUPmKwTqTD-k3MNG9SGAdUQ">
           </td>
         </tr>
       </table>
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
                    <input type="submit" value="Add Comment"
                           class="btn btn-primary">
                  </center>
                </FORM>
              </div>      
        </div> <!--COMMENT PANE DIV-->
      
      <!--</div> <!--WHOLE SIDE PANE DIV-->
  </div>
</body>
</html>
