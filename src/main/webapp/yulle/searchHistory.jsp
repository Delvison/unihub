<HTML>
  <HEAD>
  	<%@ page import="java.util.*" %>
  </HEAD>
 
  <BODY>
  	<%! HttpSession session; %>
  	<DIV ALIGN="left">
  		<B>Search History:</B><BR>
  		<% 
  		  session = request.getSession();
  		  List<String> klist = new ArrayList();
        klist = (List<String>) session.getAttribute("keywords");
      %>
        <% if(session.getAttribute("keywords") != null){ %>	
          <% ListIterator it = klist.listIterator(); %>
          <UL>
            <% while(it.hasNext()){ %>
          	  <% String key = (String) it.next(); %>
              <% String link = key.replace(" ","%20"); %>
              <LI><A href="/unihub/searchServlet?search=<%=link%>"><%=key%></A></LI>      
            <% } %>
          </UL> 
        <% }else { %>
		  <BR><I>No History Found!</I>
        <% } %>
        <DIV ALIGN="right" STYLE="float:right; text-align:right;">
          <A HREF="/unihub/gsearch">Back to Search</A> |
          <A HREF="/unihub/clearHistory">Clear History</A>
        </DIV>  
    </DIV>
  </BODY>
</HTML>