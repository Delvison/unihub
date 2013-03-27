// @author Delvison
/*
This tag prints out all of the recent activites pertaining to an
individual listing
*/
package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class ItemActivityTag extends SimpleTagSupport{
  private String itemId;
  
  public void setItemId(String itemId){
    this.itemId = itemId;  
  }
  
  public void doTag() throws JspException, IOException{
    JspWriter out = getJspContext().getOut();
    
    ListingsObj lis = ListingsObj.create();
    /* find 'Stuff' by id */
    Stuff stuff = lis.getStuff(Integer.parseInt(itemId));
    String[] activities = stuff.getActivityObj().getActivityArray();

    if (activities[0] != null){
      for (int i = 0; i<activities.length; i++){
        if (activities[i] != null){
          getJspContext().setAttribute("itemActivity",activities[i]);
          getJspBody().invoke(null);
        }
      }
    }else{
      getJspContext().setAttribute("itemActivity","No activities exist.");
      getJspBody().invoke(null);
    }
  }
}