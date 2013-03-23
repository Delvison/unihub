<%-- 
    Document   : profile.jsp
    Created on : Feb 23, 2013, 8:08:10 PM
    Author     : Mark
--%>

<!-- Not Currently Used
See ProfileServlet in java/mark -->

<%@ page language="java" import="com.unihub.app.User,
                                 com.unihub.app.Dbase,
                                java.security.*,
                                javax.servlet.*,
                                javax.servlet.http.*" 
          isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>
<%@ include file="../delvison/header.jsp"%>

    <body>
        <% User currentuser = (User)session.getAttribute("user");
           Dbase ubase = Dbase.create();
           String gravatar = "";
            try {
              gravatar = currentuser.gravatar(); 
            } catch(NoSuchAlgorithmException e) {
              out.println("No Such Algorithm Exception");
            } %>
        <div class="row">
        <div class="span8 offset2 main" style="background-color:white">
            <table style="margin:10px" width="100%">
             <tr>
              <td style="padding:10px">
               <h4><%=currentuser.getName()+" "%>(<%=currentuser.getReputation()%>)
               <a href="usermessages"/><img width="25px" height="20px" src="design/images/mail.png"></a>
               </h4>
               <p><%=currentuser.getSchool()%>
               <br><%=currentuser.getEmail()%>
               </p>
              </td>
              <td valign="center" colspan="3">
              <img src="<%=gravatar%>" style="float:top"></img><br/>
              <a href="http://gravatar.com">Need a Gravatar?</a>
              <td>
             </tr>
             <tr>
              <td>Watched Users: <%= ubase.getUser(currentuser.getName()).getWatched() %></td>
             </tr>
            </table>
        </div>
        <div class="span4 sidebar" style="background-color:white">
          <center><h4>My Listings</h4></center>
          <table class="table table-striped">
            <devjsp:forEachListing user="<%=currentuser.getName()%>">
            <tr>
              <td valign="center">
                <p>
                  <a href="item?id=${listingId}">
                     ${listingName} - $${listingPrice} </a>
                  ${listingUniversity}, ${listingLocation}
              </p>
              </td>
            </tr>
            </devjsp:forEachListing>
          </table>
        </div>
        </div>
    </body>
</html>
