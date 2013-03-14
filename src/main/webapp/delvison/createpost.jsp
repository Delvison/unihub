<!-- jsp to create a listing -->

<%@include file="header.jsp" %>

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
            <td>
            <div class="input-prepend input-append span12">
              <span class="add-on">$</span>
                <input class="span10" id="appendedPrependedInput" type="text" name="price">
            </div>
            </td>  
          </tr>
          <tr>
            <td></td>
            <td><input type="checkbox" name="bid" value="yes">
                Bid Mode <p style="font-size:xx-small">
                <i>Bid starts at price mentioned above</i></p></td>
          </tr>
          <tr>
            <td>Description</td>
            <td><TEXTAREA name="description" rows="7" placeholder="Description"></TEXTAREA></td>
          </tr>
          <input type="hidden" name="location" value="<%=st%>">
          <input type="hidden" name="university" value="<%=sc%>">
          <tr>
            <td colspan="2"><center><input type="submit" value="Sell"
                            class="btn btn-primary btn-large"></center></td>
          </tr>
        </table>
       </form>
      </div>
      
      <!--Search Pane-->
      <div class='span4 sidebar' style="background-color:White">
        <h2>Photos</h2>
          <div class="alert alert-block span10 offset1">
            <button type="button" class="close" data-dismiss="alert">&times;</button>
              <p><i>Pictures are a great way for sellers to know exactly what you're
                selling. They reassure the buyer of what it is you're actually selling
                and they may even help for a quicker sale! So go ahead, snap one or two
                and watch your stuff sell like hotcakes! </i></p>
          </div>
          <img data-src="holder.js/300x200" alt="">
          <input type="file" name="somefile" class="span9" >
      </div>
</div>
</center>
</body>
</html>

