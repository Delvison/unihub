<%-- 
    Document   : user.jsp
    Created on : Mar 10, 2013, 3:08:10 PM
    Author     : Mark
--%>

<%@ page language="java" import="com.unihub.app.User,
                                 com.unihub.app.Dbase,
                                java.security.*,
                                javax.servlet.*,
                                javax.servlet.http.*" %>
<!DOCTYPE html>

  <html>
  <head>
    <%@ include file="../delvison/header.jsp"%>
    <title>User Profile</title>
  </head>
    <body style="background-color:#CCC">
        <% Dbase ubase = Dbase.create(); %>
        <% User currentuser = ubase.getUser(Integer.parseInt(request.getParameter("u_id"))); %>
        <%  String gravatar = "";
            try {
              gravatar = currentuser.gravatar(); 
            } catch(NoSuchAlgorithmException e) {
              out.println("No Such Algorithm Exception");
            } %>
        <div class="row">
        <div class="span8 main" style="background-color:white">
            <table>
             <tr>
              <td>
               <img src=<%=gravatar%> style="float:top"></img>
              </td>
              <td>
               <div class="span1 offset1"><h3><%=currentuser.getName()+" "%>(<%=currentuser.getReputation()%>)</h3>
               </div>
              </td>
             </tr>
             <tr>
               <td>
               <a href="http://gravatar.com">Need a Gravatar?</a><br/>
               <p><%=currentuser.getSchool()%>
               <br><%=currentuser.getEmail()%>
               </p>
               </td>
             </tr>
            </table>
        </div>
        <div class="span4 sidebar" style="background-color:white">
          <center><h3>Listings</h3></center>
        </div>
        </div>
    </body>
</html>
