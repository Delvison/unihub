<td style="padding:10px">
<center>
   <% User currentUser = ubase.getUser(Integer.parseInt(request.getParameter("u_id"))); %>
   <% String sessUser = (String)session.getAttribute("username"); %>
   <a href="pmessage?name=<%=currentuser.getName()%>" role="button" class="btn btn-small">Message</a>                   
   <% String val = "";
      User sessUserDBase = ubase.getUser(sessUser);
      String curruname = currentUser.getName();
      boolean doeswatch = sessUserDBase.isWatching(curruname);
      if(doeswatch == true) val = "unwatch";
      else val = "watch";
   %>
   <form action="watch" method="POST">
   <input type="hidden" name="watchname" value="<%=currentUser.getName()%>">  
   <input type ="submit" value="<%=val%>" role="button" class="btn btn-small">
   </form>
</center>
</td>
