<%@ page language="java" import="com.unihub.app.Dbase" %>

<html>
    <head>
      <%@ include file="../delvison/header.jsp" %>
      <title>Sign Up</title>
    </head>
    <body>
        <div style="valign:center" class="span6 offset3 hero-unit">
        <form action="createuser" method="POST" style="valign:center">
          Username: <input type="text" name="username"><br>
          School: <input type="text" name="school"><br>
          Email: <input type="text" name="email">.edu<br>
          Password: <input type="password" name="password"><br>
          Confirm Password: <input type="password" name="password_confirmation"><br>
          <input type="submit" value="Create User">
        </form>
        </div>
    </body>
</html>
