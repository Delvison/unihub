<!-- construct an object(tag?) that holds all activity objects in order of time performed -->

<%@ page language="java" import="com.unihub.app.*,
                                java.util.ArrayList,
                                java.security.*,
                                javax.servlet.*,
                                javax.servlet.http.*" 
          isELIgnored="false"%>
<%@ taglib uri="/WEB-INF/tlds/devjsp-taglib.tld" prefix="devjsp"%>

<hr>
<% ArrayList<String> watchedusers = usr.getWatched(curruname);
   for( String w: watchedusers) {
     ArrayList<Stuff> watchedlistings = ListingsObj.create().userSearch(w);
     for( Stuff stuffy:watchedlistings ) {
     String stuffid = Integer.toString(stuffy.getId()); %>
     <devjsp:printActivities itemId="<%=stuffid%>">
       <a href="item?id=${itemId}">${itemName}</a> - ${itemActivity}<hr><br/>
     </devjsp:printActivities>
  <% } 
   } %>
