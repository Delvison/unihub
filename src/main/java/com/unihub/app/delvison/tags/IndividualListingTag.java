/*
allows access to individual 
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class IndividualListingTag extends SimpleTagSupport{
  private int itemId;
  
  public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }
  
  public void doTag() throws JspException, IOException{
    ListingsObj lis = ListingsObj.create();
    /* find 'Stuff' by id */
    Stuff stuff = lis.getStuff(itemId);
    
    getJspContext().setAttribute("itemId",Integer.toString(stuff.id)); 
    getJspContext().setAttribute("itemName",stuff.name); 
    getJspContext().setAttribute("itemPrice",stuff.price); 
    getJspContext().setAttribute("itemUser",stuff.user);
    getJspContext().setAttribute("itemUniversity",stuff.university);
    getJspContext().setAttribute("itemLocation",stuff.location);   
    getJspContext().setAttribute("itemCategory",stuff.category);
    getJspContext().setAttribute("itemDescription",stuff.description);
    getJspContext().setAttribute("itemTime",stuff.timePosted);
    getJspContext().setAttribute("itemBidMode",stuff.bidMode);
    getJspContext().setAttribute("itemHighBidder",stuff.getHighBidder());

    getJspBody().invoke(null);
  }
}

