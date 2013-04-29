// @author Delvison
/*
Prints out comments
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import javax.ejb.*;
import java.util.*;

public class PrintCommentsTag extends SimpleTagSupport{
  private int itemId;
  @EJB
  CommentEJB coms;

  public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }
  
  public void doTag() throws JspException, IOException{
    /*ArrayList<Comment> cmt = coms.getListOfComments();
    for (Comment c: cmt){
      if (c.itemId == itemId){
        String[] co = c.getContentArray();
        getJspContext().setAttribute("commentsUser",co[0]); //userComment
        getJspContext().setAttribute("theComment",co[1]); //theComment
        getJspBody().invoke(null);
      }
    }*/
  }
}

