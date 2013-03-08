<html>
<head>
  <%@include file="header.jsp" %>
  
  <!--import twitter bootstrap css and js-->
  <link rel="stylesheet" type="text/css" href="http://localhost:8080/unihub/design/bootstrap/css/bootstrap.css" ></link>
  <script language="JavaScript" type="text/JavaScript" src="http://localhost:8080/unihub/design/bootstrap/js/bootstrap.js"></script>
    
  <style type='text/css'>
    body {
      background-color: #CCC;
    }
  </style>
</head>

<body>
<center>
<div class="row-fluid">
      
      <!--Listings Pane -->
      <div class='span7 main' style="background-color:White">
       <h2>Sell Your Stuff!</h2>
       <form action="createlisting" method="GET">
        <center>
        <div class="alert alert-block span10 offset1">
          <button type="button" class="close" data-dismiss="alert">&times;</button>
          <strong>Hey!</strong> Before you make a sale, here are some guidelines.
          Please be advised that UniHub does not encourage nor endorse any online
           transactions. For your convenience and security, it is recommended that
            all exchanges be done in person and in a public setting. Be sure to agree
            on a solid meeting time and place and always bring a friend. Watch out
            for lowballers and study hard!
        </div>
        <table class="table span9 offset1">
          <tr>
            <td>Location</td>
            <td>
              <% if (myCookie == null) { %>
                <a href="cookieform.jsp">Location not set</a><br>
              <% } else { %> 
                <%=sc%>
              <% } %>
            </td>
          </tr>
          <tr>
            <td>Category</td>
            <td>
               <select name = "category" class="span12">
                 <option>Art Supplies</option>
                 <option>Books</option>
                 <option>Bicycles</option>
                 <option>Cell Phones</option>
                 <option>Electronics</option>
                 <option>Furniture</option>
                 <option>Musical Instruments</option>
                 <option>Misc.</option>
               </select>
            </td>   
          </tr>          
          <tr>
            <td>Name</td>
            <td><input type="text" name="name" class="span12" placeholder="Name"></td>
          </tr>
          <tr>
            <td>Price</td>
            <td><input type="text" name="price" class="span12" placeholder="$$$"></td>
          </tr>
          <tr>
            <td></td>
            <td><input type="checkbox" name="bid" value="yes">
                Bid Mode <p style="font-size:xx-small">
                <i>Bid starts at price mentioned above</i></p></td>
          </tr>
          <tr>
            <td>Description</td>
            <td><TEXTAREA name="description" class="span12" placeholder="Description"></TEXTAREA></td>
          </tr>
          <input type="hidden" name="location" value="<%=st%>">
          <input type="hidden" name="university" value="<%=sc%>">
          <tr>
            <td colspan="2"><center><input type="submit" value="Sell"
                            class="btn btn-primary btn-large"><center></td>
          </tr>
      </table>
      </center>
      </form>
      </div>
      
      <!--Search Pane-->
      <div class='span4 sidebar' style="background-color:White">
        <h2>sidebar maybe?</h2>
          <p><i>Maybe put a form to upload pics here or move
                the description here..</i></p>
      </div>
</div>
</center>
</body>
</html>

