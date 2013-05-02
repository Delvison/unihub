<%@include file="../delvison/header.jsp" %>
  <%@ page import="java.util.*" %> 
  <div class ="span8 offset3">
    <CENTER>
      <H1>Search:</H1>
      <FORM ACTION="/unihub/searchServlet">
        <INPUT TYPE="text" name="search">
        <INPUT TYPE="SUBMIT">        
      </FORM>	
    </CENTER>
  </div>
    <br>
      <br>
      <DIV class="span8 offset3">
    <% List<String> amazon = (List<String>)request.getAttribute("amazon"); %>
    <% String[] googleLinks = (String[])request.getAttribute("google"); %>
    <% String local = (String)request.getAttribute("local"); %>
    <% if (local!=null){ %>
      <%=local%>
    <% } %>  
    <% if ( amazon != null ){ %>
      <CENTER> <B>There is no match for your search in our databases. Consider checking our suggestions:</B> </CENTER>
      <BR /><BR />      
      <% String title = (String) amazon.get(0); %>
      <% String detail = (String) amazon.get(1); %>
      <% String price = (String) amazon.get(2); %>
    	 <B>Found on Amazon</B>: <A HREF="<%=detail%>"> <%=title%> </A> New from <%=price%> 
    <% } %>
    <br>
    <br>
    <% if ( googleLinks != null ){ %>
      <B>Other stores found on Google Shop Search:</B>
      <ul>
        <% for(String link : googleLinks) { %>
          <li><%= link %></li>
        <% } %>
      </ul>
      <A HREF="/unihub/searchHistory">Search History</A> |  
    </DIV>
    <% } %>
    <br>
    <br>


