<%-- 
    Document   : profile.jsp
    Created on : Feb 23, 2013, 8:08:10 PM
    Author     : Mark
--%>

<!-- Profile Page for logged in user -->

<%@ page language="java" import="com.unihub.app.*, java.util.*, java.security.*,
                                javax.servlet.*, javax.servlet.http.*,
                                com.unihub.app.UserStatefulBI, javax.ejb.EJB,
                                javax.naming.*" 
          isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>
<%@ include file="../delvison/header.jsp"%>
<%! @EJB UserStatefulBI usr; %>

    <body> 
      <div class="top-buffer container-fluid">
        <% String curruname = (String)session.getAttribute("username");  
           Context context = new InitialContext();
           usr = (UserStatefulBI) context.lookup
                 ("ejb:unihub-ear/unihub-ejb//UserStatefulBI!com.unihub.app.UserStatefulBI?stateful");
           String gravatar = "";
            try {
              gravatar = usr.getGravatar(curruname); 
            } catch(NoSuchAlgorithmException e) {
              out.println("No Such Algorithm Exception");
            } %>
        <div class="row-fluid">
        <div class="span12">
          <div class="row-fluid">
          <div class="span8">
            <table class="shadow" style="margin:10px" width="100%">
             <tr>
              <td style="padding:10px">
               <h4><%=curruname+" "%>(<%=usr.getRep(curruname)%>)
               <a href="usermessages"/><img width="25px" height="20px" src="design/images/mail.png"></a>
               </h4>
               <p><%=usr.getSchool(usr.getId(curruname))%>
               <br><%=usr.getEmail(usr.getId(curruname))%>
               </p>
              </td>
              <td valign="center" colspan="3">
              <img src="<%=gravatar%>" style="float:top"></img><br/>
              <a href="http://gravatar.com">Need a Gravatar?</a>
              <td>
             </tr>
            </table>
            <div class="row-fluid" style="padding-top:20px">
              <div class="span6 offset1 shadow">
                <div class="tabbable">
                <ul class="nav nav-tabs">
                  <li class="active">
                    <a href="#myActivityTab" data-toggle="tab">My Activity</a>
                  </li>
                  <li>
                    <a href="#watchedActivityTab" data-toggle="tab">Watched Users</a>
                  </li>
                </ul>
                </div>
                <div class="tab-content">
                  <div class="tab-pane" id="myActivityTab">
                  <%@ include file="myactivity.jsp"%>
                  </div>
                  <div class="tab-pane" id="watchedActivityTab">
                  <%@ include file="watchedactivity.jsp"%>
                  </div>
                </div>
              </div>
            </div>
          </div>
          <div class="span4 shadow">
            <center><h4>My Listings</h4></center>
            <table class="table table-striped">
              <devjsp:forEachListing user="<%=curruname%>">
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
        </div>
        </div>
      </div>
    </body>
</html>
