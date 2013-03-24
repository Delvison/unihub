/*
allows access to individual 
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class IndividualListingTag extends SimpleTagSupport{
  private String itemId;
  
  public void setItemId(String itemId){
    this.itemId = itemId;  
  }
  
  public void doTag() throws JspException, IOException{
    ListingsObj lis = ListingsObj.create();
    /* find 'Stuff' by id */
    Stuff stuff = lis.getStuff(Integer.parseInt(itemId));
    
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
    if(stuff.getHighBidder() != null){
      getJspContext().setAttribute("itemHighBidder",stuff.getHighBidder());
    }else{
      getJspContext().setAttribute("itemHighBidder",stuff.user);
    }

    getJspBody().invoke(null);
  }
}

