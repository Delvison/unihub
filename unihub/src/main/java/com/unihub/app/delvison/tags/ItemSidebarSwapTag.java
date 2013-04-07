// @author Delvison
/*
Checks if a listing belongs to a user.
If it does, this will display an edit listing link.
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import javax.ejb.*;

public class ItemSidebarSwapTag extends SimpleTagSupport{
  @EJB
  ListingObjEJB lis;
  private int itemId;

  public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }

  public void doTag() throws JspException, IOException{
    String bidMode = lis.getBidMode(itemId);
    if (bidMode.equals("yes")){
      getJspContext().setAttribute("sidebarJsp", "commentWithBidInclude.jsp" ); 
    }else{
      getJspContext().setAttribute("sidebarJsp", "commentNoBidInclude.jsp" ); 
    }
      getJspBody().invoke(null);
  }
}
