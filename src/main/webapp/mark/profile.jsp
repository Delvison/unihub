<%-- 
    Document   : profile.jsp
    Created on : Feb 23, 2013, 8:08:10 PM
    Author     : Mark
--%>

<!-- Not Currently Used
See ProfileServlet in java/mark -->

<%@ page language="java" import="com.unihub.app.User,
                                java.security.*,
                                javax.servlet.*,
                                javax.servlet.http.*" 
          isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>
<%@ include file="../delvison/header.jsp"%>

    <body>
        <% User currentuser = (User)session.getAttribute("user"); %>
        <%  String gravatar = "";
            try {
              gravatar = currentuser.gravatar(); 
            } catch(NoSuchAlgorithmException e) {
              out.println("No Such Algorithm Exception");
            } %>
        <div class="row">
        <div class="span8 offset2 main" style="background-color:white">
            <table style="margin:10px">
             <tr>
              <td>
               <img src=<%=gravatar%> style="float:top"></img>
              </td>
              <td style="padding:10px">
               <center><h3><%=currentuser.getName()+" "%>(<%=currentuser.getReputation()%>)</h3></center>
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
