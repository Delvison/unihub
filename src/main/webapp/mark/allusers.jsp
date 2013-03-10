<html>
<head>
  <%@include file="../delvison/header.jsp" %>
  <%@ page import="com.unihub.app.Dbase, com.unihub.app.User, java.util.*" %>
  <% Dbase ubase = Dbase.create(); %>

  <style type='text/css'>
    body {
      background-color: #ccc;
    }
  </style>

</head>

<body>
<center>
<div class='span8 main' style="background-color:White">
        <h2>All Users</h2>
        <p><i><%=sc%></i></p>
          <% if (ubase.getUsersList().size() == 0) {%>
            <p><i>No users exist.</i></p>
          <%}%>
        <table class="table table-striped">
            <% for (User u: ubase.getUsersList()){
                   String email = u.getEmail();
                   String name = u.getName(); 
                   int id = u.getId(); %>
          <tr>
            <td valign="center">
              <p><a href="user?u_id=<%=id%>"><%=name+" - "+email%> </a>
              </p>
            </td>
          </tr>
             <%}%>
        </table>
      </div></center>
</body>
</html>
