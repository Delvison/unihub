<%@ page language="java" import="com.unihub.app.Dbase, com.unihub.app.User, com.unihub.app.Message" %>

      <%@ include file="../delvison/header.jsp" %>
      <title>Message for User1</title>
    <body>
        <% User curruser = (User)session.getAttribute("user"); %>
        <div style="valign:center" class="span6 offset3 hero-unit">
        <form action="message" method="POST" style="valign:center">
          From: <%=curruser.getName()%><br>
          <input type="hidden" name="fromName" value="<%=curruser.getName()%>">
          To: <%=request.getParameter("name")%><br>
          <input type="hidden" name="toName" value="<%=request.getParameter("name")%>">
          Message: <textarea name="contents"></textarea><br>
          <input type="submit" value="Send Message">
        </form>
        </div>
    </body>
</html>

