<html>
<head>
    <%@ page import="com.unihub.app.ListingsObj, com.unihub.app.CommentObj, com.unihub.app.Comment, com.unihub.app.Stuff, java.util.*" %>
    <%
      CommentObj cmt = CommentObj.create();
      /* get id from url */
      String id = (String)request.getParameter("id");
      int x = Integer.valueOf(id);
      /* get listingobj */
      ListingsObj lis = ListingsObj.create();
      /* find 'Stuff' by id */
      Stuff stuff = lis.getStuff(x);
    
      String name = stuff.name;
      String price = stuff.price;
      String usr = stuff.user;
      String university = stuff.university;
      String location = stuff.location;
      String category = stuff.category;
      String description = stuff.description;
      Date now = stuff.timePosted;
      String bid = stuff.bidMode;
    %>
    
    <%@include file="header.jsp" %>
  
    <style type='text/css'>
    body {
      background-color: #CCC;
    }
    </style>

</head>

<body>
<div id='content' class='row-fluid'>
      
      <!--Item Pane -->
      <div class='span8 main' style="background-color:White">
       <table>
       <tr>
        <td>
        <h2>(Item For Sale)</h2>
          <p>Name: <%=name%> - <%=price%>
          <br>Owner: <%=usr%>
          <br>University: <%=university%>, <%=location%>
          <br>Category: <%=category%>
          <br>Description: <%=description%>
          <br>Time Posted: <%=now%>
          <br>Bid Mode?: <%=bid%>
          </p>
          </td>
          <td align="right">
          <img src="https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRkY31DVjEblSBHJnqrxLCWO3U4PRXcUPmKwTqTD-k3MNG9SGAdUQ">
          </td>
          </tr>
          </table>
      </div>
      
      <!--Comment Pane-->
      <div class='span4 sidebar' style="background-color:White">
        <center><h2>Comments</h2></center>
          <!--section that displays comments posted-->
          <div name="displayComments">
            <!-- java controller will feed in the data. display 
                 comments here-->
            <i class="icon-user"></i><a href="#">sketchyBuyer1:</a><i> sell for $2?</i><hr>
            <i class="icon-user"></i><a href="#">Seller:</a><i> no. -___-</i><hr>
              <% for (Comment c: cmt.comments){
                   String[] co = c.getContentArray(); %>
                   <p><i class="icon-user"></i><a href="profile"><%=co[0]%>:</a>
                   <i><%=co[1]%></i></p><hr>
             <%}%>
            
          </div>
          <!--section where a comment can be posted -->
          <div name="postComments">
                <!--upon submit, forward to a controller java class
                    that will first validate user and 
                    process the comment posted -->
            <FORM ACTION="addcomment" METHOD="get">
              <center>
                <textarea name="comment" style="width:260px;height:70px"></textarea>
                <input type="hidden" name="user" value="<%=user%>">
                <input type="hidden" name="itemId" value="<%=id%>">
                  <%if (user != null){%>
                    <p style="font-size:xx-small;color:Green">
                      Logged in as <%=user%>
                    </p>
                  <%}else{%>
                     <p style="font-size:xx-small;color:Red">
                      Please login to post a comment.
                    </p>
                  <%}%>
                <input type="submit" value="Add Comment" class="btn btn-primary">
              </center>
            </FORM>
          </div> 
      </div>
</div>
</body>
</html>
