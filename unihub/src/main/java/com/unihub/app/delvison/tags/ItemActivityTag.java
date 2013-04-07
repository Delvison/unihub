// @author Delvison
/*
This tag prints out all of the recent activites pertaining to an
individual listing
*/
package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import javax.ejb.*;

public class ItemActivityTag extends SimpleTagSupport{
  //@EJB
  //ListingObjEJB lis;
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
    getJspContext().setAttribute("itemId",itemId);

    if (activities[0] != null){
      for (int i=0; i<activities.length; i++){
        if (activities[i] != null){
          getJspContext().setAttribute("itemActivity",activities[i]);
          getJspContext().setAttribute("itemName",stuff.getName());
          getJspBody().invoke(null);
        }
      }
    }else{
      //getJspContext().setAttribute("itemActivity","");
      //getJspContext().setAttribute("itemName","");
      //getJspBody().invoke(null);
      out.println();
    }
  }
}
