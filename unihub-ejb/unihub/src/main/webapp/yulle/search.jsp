<HTML>
<%@include file="../delvison/header.jsp" %>
  <%@ page import="java.util.*" %> 
  <BODY>
  	<CENTER>
      <H1>Search:</H1>
      <FORM ACTION="/unihub/searchServlet">
        <INPUT TYPE="text" name="search">
        <INPUT TYPE="SUBMIT">        
        <DIV>

        </DIV>	
      </FORM>	
    </CENTER>
    <BR />

    <% List<String> amazon = (List<String>)request.getAttribute("amazon"); %>
    <% String[] googleLinks = (String[])request.getAttribute("google"); %>

    <% if ( amazon != null ){ %>
      <CENTER> <B>There is no match for your search in our databases. Consider checking our suggestions:</B> </CENTER>
      <BR /><BR />      
      <% String title = (String) amazon.get(0); %>
      <% String detail = (String) amazon.get(1); %>
      <% String price = (String) amazon.get(2); %>
      <DIV ALIGN="left">
    	 <B>Found on Amazon</B>: <A HREF="<%=detail%>"> <%=title%> </A> New from <%=price%> 
      </DIV>
    <% } %>

    <% if ( googleLinks != null ){ %>
    <DIV ALIGN="left">
      <BR />
      <B>Other stores found on Google Shop Search:</B>
      <ul>
        <% for(String link : googleLinks) { %>
          <li><%= link %></li>
        <% } %>
      </ul>
    </DIV>
    <% } %>
    
    <DIV ALIGN="right" STYLE="float:right; text-align:right;">
      <A HREF="/unihub/searchHistory">Search History</A> |  
    </DIV>  

  </BODY>

</HTML>  	
