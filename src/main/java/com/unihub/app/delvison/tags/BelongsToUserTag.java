// @author Delvison
/*
Checks if a listing belongs to a user.
If it does, this will display an edit listing link.
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class BelongsToUserTag extends SimpleTagSupport{
  private int itemId;
  private String userLoggedIn;
  
  public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }

  public void setUser(String user){
    this.userLoggedIn = user;
  }
  
  public void doTag() throws JspException, IOException{
    JspWriter out = getJspContext().getOut();
    ListingsObj lis = ListingsObj.create();
    /* find 'Stuff' by id */
    Stuff stuff = lis.getStuff(itemId);
    if (userLoggedIn != null && userLoggedIn.equals(stuff.getUser())){
      out.print("<i><a href=\"edititem?id="+
         Integer.toString(this.itemId)+"\">Edit Listing</a></i>");
    } 
  }
}