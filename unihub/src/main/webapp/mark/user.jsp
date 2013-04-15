<%-- 
    Document   : user.jsp
    Created on : Mar 10, 2013, 3:08:10 PM
    Author     : Mark
--%>

<%@ page language="java" import="com.unihub.app.*, java.util.*, java.security.*,
                                javax.servlet.*, javax.servlet.http.*,
                                com.unihub.app.UserStatefulBI, javax.ejb.EJB,
                                javax.naming.*"
    isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>

<!DOCTYPE html>

    <%@ include file="../delvison/header.jsp"%>
    <%! @EJB UserStatefulBI usr; %>

    <body style="background-color:#CCC">
       
        <% Context context = new InitialContext();
           usr = (UserStatefulBI) context.lookup
                 ("ejb:unihub-ear/unihub-ejb//UserStatefulBI!com.unihub.app.UserStatefulBI?stateful");
           String curruname = usr.getName(Integer.parseInt(request.getParameter("u_id")));
           String gravatar = "";
            try {
              gravatar = usr.getGravatar(curruname); 
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
               <center><h3><%=curruname+" "%>(<%=usr.getRep(curruname)%>)</h3></center>
              </td>
                <% if(session.getAttribute("username") != null) { %>
                <%@ include file="logged_in_user_page_actions.jsp" %>
                <% } %>
             </tr>
             <tr>
               <td>
               <br/>
               <p><%=usr.getSchool(usr.getId(curruname))%>
               <br><%=usr.getEmail(usr.getId(curruname))%>
               </p>
               </td>
             </tr>
            </table>
        </div>
        <div class="span4 sidebar" style="background-color:white">
          <center><h4>Listings by this User</h4></center>
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

    <!--PM Modal  CURRENTLY HIDDEN AND NOT USED -->
    <% String sessionuser = "";
       if ((String)session.getAttribute("username") != null) {
         sessionuser = (String)session.getAttribute("username");
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
           <input type="hidden" name="fromName" value="<%=sessionuser%>">
           To: <%=curruname%><br>
           <input type="hidden" name="toName" value="<%=curruname%>">
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
