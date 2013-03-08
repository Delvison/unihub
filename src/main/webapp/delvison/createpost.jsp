<html>
<head>
  <%@include file="header.jsp" %>
  
  <!--import twitter bootstrap css and js-->
  <link rel="stylesheet" type="text/css" href="http://localhost:8080/unihub/design/bootstrap/css/bootstrap.css" ></link>
  <script language="JavaScript" type="text/JavaScript" src="http://localhost:8080/unihub/design/bootstrap/js/bootstrap.js"></script>
</head>

  <body>
    <center>
    <DIV name="createpost" style="background-color:LightGray; width:500px" class="hero-unit">
      <form action="createlisting" method="GET">
        <table cellpadding="2" cellspacing="0" border="0" width="430">
          <tr>
            <td width="150">Location:</td>
            <td colspan="3">
              <% if (myCookie == null) { %>
                <a href="cookieform.jsp">Location not set</a><br>
              <% } else { %> 
                <%=sc%>
              <% } %>
            </td>
          </tr>
          <tr>
            <td width="150">Category:</td>
            <td colspan="3">
               <select name = "school">
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
            <td width="150">Name:</td>
            <td colspan="3"><input type="text" name="name" style="width: 300px" ></td>
          </tr>
          <tr>
            <td width="150">Price:</td>
            <td><input type="text" name="price" style="width: 100px" ></td>
            <td width="170"><input type="checkbox" name="bid" value="yes">Bid Mode</td>
          </tr>
          <tr>
            <td width="150">Description:</td>
            <td colspan="3"><TEXTAREA name="description" style="width:400px; height:150px"></TEXTAREA></td>
          </tr>
          <input type="hidden" name="location" value="<%=st%>">
          <input type="hidden" name="university" value="<%=sc%>">
          <tr>
            <td colspan="3"><center><input type="submit" value="Submit" class="btn btn-primary btn-large"><center></td>
          </tr>
      </table>
      </form>
    </	DIV>
    <center>
  </body>
