<html>
  <head>
    <%@include file="header.jsp" %>
    <title>Set Locationt</title>
  </head>

  <body>

    <form method="post" action="setcookie.jsp">
      <select name = "school">
        <option>SUNY Oswego</option>
        <option>Stanford</option>
        <option>Washington State</option>
      </select>
      <br>

      <select name = "state">
        <option>New York</option>
        <option>California</option>
        <option>Washington</option>
      </select>
      <br>

      <input type="submit" value="Submit">
    </form>

    <hr>
</body>
