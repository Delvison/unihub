<%@ page language="java" import="com.unihub.app.Dbase" %>

<html>
    <head>
      <title>Sign Up</title>
    </head>
    <body>
        <form action="createuser" method="POST">
          Username: <input type="text" name="username"><br>
          Email: <input type="text" name="email">.edu<br>
          Password: <input type="password" name="password"><br>
          Confirm Password: <input type="password" name="password_confirmation"><br>
          <input type="submit" value="Create User">
        </form>
    </body>
</html>
