<%-- 
    Document   : user.jsp
    Created on : Mar 10, 2013, 3:08:10 PM
    Author     : Mark
--%>

<%@ page language="java" import="com.unihub.app.User,
                                 com.unihub.app.Dbase,
                                 com.unihub.app.ListingsObj,
                                 com.unihub.app.Stuff,
                                 com.unihub.app.Message,
                                java.security.*,
                                javax.servlet.*,
                                javax.servlet.http.*"
    isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>

<!DOCTYPE html>

    <%@ include file="../delvison/header.jsp"%>

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
                <% if(session.getAttribute("user") != null) { %>
                <%@ include file="logged_in_user_page_actions.jsp" %>
                <% } %>
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
          <center><h4>Listings by this User</h4></center>
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

    <!--PM Modal -->
    <% User sessionuser = new User();
       if ((User)session.getAttribute("user") != null) {
         sessionuser = (User)session.getAttribute("user");
       } %>
    <div id="messageModal" class="modal hide fade" tabindex="-1" role="dialog"
         aria-labelledby="myModalLabel" aria-hidden="true">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal"
          aria-hidden="true">×</button>
        <h3 id="myModalLabel">Private Message</h3>
      </div>
      <div class="modal-body">
        <form action="validate?where=message" method="GET">
           <input type="hidden" name="fromName" value="<%=sessionuser.getName()%>">
           To: <%=currentuser.getName()%><br>
           <input type="hidden" name="toName" value="<%=currentuser.getName()%>">
           Message: <textarea name="contents"></textarea><br>
      </div>
      <div class="modal-footer">
        <button class="btn" data-dismiss="modal" aria-hidden="true">
           Close</button>
        <input type="submit" class="btn btn-primary" value="Send">
        </form>
    </div>
</div>


    </body>
</html>
