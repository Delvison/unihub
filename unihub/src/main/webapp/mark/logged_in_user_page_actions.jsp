<td width="100%" style="padding:10px">
<center>
   <% String sessUser = (String)session.getAttribute("username"); %>
   <div class="row-fluid"> 
     <div class="span8">
     <div class="span4">
     <a href="pmessage?name=<%=curruname%>" role="button" class="btn btn-small">Message</a>                   
     </div>
     <div class="span4">
      <% String val = "";
      boolean doeswatch = usr.isWatching(sessUser, curruname);
      if(doeswatch == true) val = "unwatch";
      else val = "watch";
      %>
      <form action="watch" method="POST">
      <input type="hidden" name="watchname" value="<%=curruname%>">  
      <input type ="submit" value="<%=val%>" role="button" class="btn btn-small">
      </form>
     </div>
     </div>
   </div>
</center>
</td>
