
  <%@include file="../delvison/header.jsp" %>
  <%@ page import="com.unihub.app.Dbase, com.unihub.app.User, java.util.*, 
                   javax.ejb.EJB, javax.naming.*, com.unihub.app.UserStatefulBI, com.unihub.app.UserStatefulBean" %>
  <%@ page isELIgnored="false" %>
  <%@ taglib uri="/WEB-INF/tlds/markjsp-taglib.tld" prefix="markjsp"%>

  <%! @EJB UserStatefulBI usr; %>
  <% Context context = new InitialContext();
     usr = (UserStatefulBI)context.lookup("ejb:unihub-ear/unihub-ejb//UserStatefulBI!com.unihub.app.UserStatefulBI?stateful");
  %>

  <style type='text/css'>
    body {
      background-color: #ccc;
    }
  </style>

<body>
<center>
  <div class='span8 offset4 main' style="background-color:White">
        <h2>All Users</h2>
          <% if (usr.getNumUsers() == 0) {%>
            <p><i>No users exist.</i></p>
          <%}%>
        <table class="table table-striped">
          <markjsp:users>
          <tr>
            <td valign="center">
              <div class="row-fluid">
               <div class="span3">
                 ${userId}
               </div>
               <div class="span3">
                 <a href="user?u_id=${userId}">${userName}</a>
               </div>
               <div class="span3">
                 ${userSchool}
               </div>
               <div class="span3">
                 <img src="${userGravatar}"></img>
               </div>
              </div>
            </td>
          </tr>
          </markjsp:users>
        </table>
  </div>
</center>
</body>
</html>
