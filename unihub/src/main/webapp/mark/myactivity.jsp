<!-- TODO: construct an object(tag?) that holds all activity objects in order of time performed -->

<%@ page language="java" import="com.unihub.app.*, java.util.*, java.security.*,
                                javax.servlet.*, javax.servlet.http.*, com.unihub.app.Stuff, 
                                com.unihub.app.ListingObjEJBStateful, javax.ejb.EJB, javax.naming.*" 
          isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>

<%! @EJB ListingObjEJBStateful lis; %>
<%  lis = (ListingObjEJBStateful) context.lookup
         ("ejb:unihub-ear/unihub-ejb//ListingObjEJBStateful!com.unihub.app.ListingObjEJBStateful?stateful"); 
%>

<hr> 
<% ArrayList<Stuff> mylistings = lis.userSearch(curruname); %>
<% if( mylistings.size() == 0) { %>
   <i>No Activity to Display</i>
<% } %>
<% for( Stuff s:mylistings ) {
   String id = Integer.toString(s.getId()); %>
   <devjsp:printActivities itemId="<%=id%>">
     <a href="item?id=${itemId}">${itemName}</a> - ${itemActivity}<hr><br/>
   </devjsp:printActivities>
<% } %>

