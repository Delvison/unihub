<%@include file="header.jsp" %>
  
  <body>

    <CENTER>
    <h2>Welcome to UniHub!</h2>


    <FORM ACTION="https://www.googleapis.com/shopping/search/v1/public/products" METHOD="GET" >
      <INPUT TYPE="hidden" name="key" value="AIzaSyAdUWvd01fA0X3wvtEdGACC9Vk4FMX5ytM">
      <INPUT TYPE="hidden" name="country" value="US">
      <INPUT TYPE="text" name="q" >
      <INPUT TYPE="hidden" name="alt" value="atom">

      <INPUT TYPE="SUBMIT"><BR>

    </FORM>
    </CENTER>
    <a href="amazon">Search Amazon</a>
    <a href="google.html">Search Ebay</a>

  </body>

</html>
