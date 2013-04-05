<HTML>
  
  <HEAD>
  </HEAD>
 
  <BODY>
  	<CENTER>
      <H1>Amazon Search:</H1>
      <FORM ACTION="/unihub/amazon">
        <INPUT TYPE="text" name="search">
        <INPUT TYPE="SUBMIT">        
        <DIV>

        </DIV>	
      </FORM>	
    </CENTER>
    <BR>
    <% String title = request.getParameter("title"); %>
    <% String description = request.getParameter("description"); %>
    <% String price = request.getParameter("price"); %>
    <% if ( title != null ){ %>
    <DIV ALIGN="left">
    	<B>Found on Amazon</B>: <A HREF="<%=description%>"> <%=title%> </A> New from <%=price%> 
    </DIV>
    <% } %>
    <DIV ALIGN="right" STYLE="float:right; text-align:right;">
      <A HREF="/unihub/searchHistory">Search History</A> |	
    </DIV>  
  </BODY>

</HTML>  	
