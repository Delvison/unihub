<td style="padding:10px">
<center>
   <% String sessUser = (String)session.getAttribute("username"); %>
   <a href="pmessage?name=<%=curruname%>" role="button" class="btn btn-small">Message</a>                   
   <% String val = "";
      boolean doeswatch = usr.isWatching(sessUser, curruname);
      if(doeswatch == true) val = "unwatch";
      else val = "watch";
   %>
   <form action="watch" method="POST">
   <input type="hidden" name="watchname" value="<%=curruname%>">  
   <input type ="submit" value="<%=val%>" role="button" class="btn btn-small">
   </form>
</center>
</td>
