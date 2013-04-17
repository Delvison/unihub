/*
Checks if a listing has already been upvoted by the currently
logged in user.
If it has, or if the logged in user is the owner of the listing,
or if no user is logged in, no thumbs up will be displayed.
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class UpvoteTag extends SimpleTagSupport{
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
    //ListingsObj lis = ListingsObj.create();
    Dbase ubase = Dbase.create();
    /* find 'Stuff' by id */
    //Stuff stuff = lis.getStuff(itemId);
    out.println(userLoggedIn);
    if ( userLoggedIn != null &&
         !(ubase.getUser(userLoggedIn).owns(itemId)) &&
         !(ubase.getUser(userLoggedIn).hasVoted((Integer)itemId)) ){
      out.println("<a href=\"reputation?itemId="+
         Integer.toString(this.itemId)+"\"><img height=\"20px\" width=\"17px\" src=\"design/images/blue-thumbs-up.png\" title=\"Scholarly!\"></a>");
    }
  }
}
