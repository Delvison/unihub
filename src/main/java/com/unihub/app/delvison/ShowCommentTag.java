/*
Prints out comments
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class ShowCommentTag extends SimpleTagSupport{
  int itemId;
  
  public void doTag() throws JspException, IOException{
    JspWriter out = getJspContext().getOut();
    CommentObj cmt = CommentObj.create();
    for (Comment c: cmt.comments){
      if (c.itemId == itemId){
        String[] co = c.getContentArray();
        /* lazy html */
        out.print("<p><i class=\"icon-user\"></i><a href=\"profile\">"+co[0]+
                   ": </a><i>"+co[1]+"</i></p><hr>");
      }
    }
  }
  
  public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }
}
