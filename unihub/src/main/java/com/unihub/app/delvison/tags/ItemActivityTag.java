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
import java.util.ArrayList;

public class ItemActivityTag extends SimpleTagSupport{
  @EJB 
  ListingObjEJBStateful listingManager;
  private String itemId;
  private String byWhat;
  private int limit;
  
  public void setItemId(String itemId){
    this.itemId = itemId;  
  }
   
  public void setByWhat(String byWhat){
    this.byWhat = byWhat;  
  }

  public void setLimit(String limit){
    this.limit = Integer.parseInt(limit);  
  }
  
  public void doTag() throws JspException, IOException{
    ArrayList<Activity> activities = listingManager.getActivities();
    if (activities.isEmpty()){
      getJspContext().setAttribute("itemActivity","No activity exists.");
      getJspBody().invoke(null);
    }else{
      for (Activity a : activities){
        getJspContext().setAttribute("itemActivity",a.getActualActivity());
        getJspBody().invoke(null);
      }
    }
  }
  
  // prints all of the activity belonging to a user
  public void printUserActivity(String user){
    
  }

  public void printActivities(String byWhat, int limit) throws JspException, IOException {
    ArrayList<Activity> activities = listingManager.getActivities();
    if (activities.get(0) == null){
      getJspContext().setAttribute("itemActivity","No activity exists.");
      getJspBody().invoke(null);
    }else{
      for (Activity a : activities){
        getJspContext().setAttribute("itemActivity",a.getActualActivity());
        getJspBody().invoke(null);
      }
    }
  }
}
