/*
Prints out comments
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class PrintCommentsTag extends SimpleTagSupport{
  private int itemId;
  
  public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }
  
  public void doTag() throws JspException, IOException{
    CommentObj cmt = CommentObj.create();
    
    for (Comment c: cmt.comments){
      if (c.itemId == itemId){
        String[] co = c.getContentArray();
        getJspContext().setAttribute("commentsUser",co[0]); //userComment
        getJspContext().setAttribute("theComment",co[1]); //theComment
        getJspBody().invoke(null);
      }
    }
  }
}

