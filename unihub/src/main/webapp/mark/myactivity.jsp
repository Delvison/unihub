<!-- TODO: construct an object(tag?) that holds all activity objects in order of time performed -->

<%@ page language="java" import="com.unihub.app.*,
                                java.util.ArrayList,
                                java.security.*,
                                javax.servlet.*,
                                javax.servlet.http.*" 
          isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>

<hr> 
<% ArrayList<Stuff> mylistings = ListingsObj.create().userSearch(curruname); %>
<% for( Stuff s:mylistings ) {
   String id = Integer.toString(s.getId()); %>
   <devjsp:printActivities itemId="<%=id%>">
     <a href="item?id=${itemId}">${itemName}</a> - ${itemActivity}<hr><br/>
   </devjsp:printActivities>
<% } %>

