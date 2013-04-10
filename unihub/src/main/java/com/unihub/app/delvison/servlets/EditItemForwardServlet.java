// @author Delvison
/* this servlet forwards(through dispatcher) to edit
 a listing if it belongs to the user that is logged in */
package com.unihub.app;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.ejb.*;

public class EditItemForwardServlet extends HttpServlet{ 
  @EJB ListingObjEJBStateless lis;
  HttpSession session;
  
  protected void doGet(HttpServletRequest req,
  HttpServletResponse res) throws ServletException, IOException {
    session = req.getSession(); /* get current session */	
    String itemId = req.getParameter("id");
    String userName="";
    try{
      userName = (String)session.getAttribute("username");
      String itemsUser = lis.getUser(Integer.parseInt(itemId));
      if (userName.equals(itemsUser)){
        req.setAttribute("id", itemId); 
        getServletContext().getRequestDispatcher("/editItemjsp").forward(req,res);
      }else{
        PrintWriter out = res.getWriter();
        out.print("Sorry, but this item does not belong to you.");      
      }
    }catch(NullPointerException e){
      res.sendRedirect("sorry");    
    }
  }
}
