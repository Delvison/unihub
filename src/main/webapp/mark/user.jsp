<%-- 
    Document   : user.jsp
    Created on : Mar 10, 2013, 3:08:10 PM
    Author     : Mark
--%>

<%@ page language="java" import="com.unihub.app.User,
                                 com.unihub.app.Dbase,
                                 com.unihub.app.ListingsObj,
                                 com.unihub.app.Stuff,
                                java.security.*,
                                javax.servlet.*,
                                javax.servlet.http.*"
    isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>

<!DOCTYPE html>

  <html>
  <head>
    <%@ include file="../delvison/header.jsp"%>
    <title>User Profile</title>
  </head>
    <body style="background-color:#CCC">
        <% Dbase ubase = Dbase.create(); %>
        <% ListingsObj lis = ListingsObj.create(); %>
        <% User currentuser = ubase.getUser(Integer.parseInt(request.getParameter("u_id"))); %>
        <%  String gravatar = "";
            try {
              gravatar = currentuser.gravatar(); 
            } catch(NoSuchAlgorithmException e) {
              out.println("No Such Algorithm Exception");
            } 
        %>
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
              <td style="padding:10px">
		<center><a href="" role="button" class="btn btn-small">Message</a>
                        <a href="" role="button" class="btn btn-small">Watch</a>
                </center>
              </td>
             </tr>
             <tr>
               <td>
               <br/>
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
