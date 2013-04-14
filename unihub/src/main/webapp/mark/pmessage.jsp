<%@ page language="java" import="com.unihub.app.Dbase, com.unihub.app.User, com.unihub.app.Message" %>

    <% String toName = request.getParameter("name"); %>
      <%@ include file="../delvison/header.jsp" %>
      <title>Message for <%= toName %></title>
    <body>
        <% String fromName = (String)session.getAttribute("username"); %>
        <div style="valign:center" class="span6 offset3 hero-unit">
        <form action="message" method="POST" style="valign:center">
          From: <%=fromName%><br>
          <input type="hidden" name="fromName" value="<%=fromName%>">
          To: <%=toName%><br>
          <input type="hidden" name="toName" value="<%=toName%>">
          Message: <textarea name="contents"></textarea><br>
          <input type="submit" value="Send Message">
        </form>
        </div>
    </body>
</html>

