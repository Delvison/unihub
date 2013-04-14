// @author Delvison
/*allows access to individual*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import javax.ejb.*;


public class IndividualListingTag extends SimpleTagSupport{
  @EJB ListingObjEJBStateless lis;
  @EJB UserStatefulBI usr;
  private int itemId;
  
  public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }
  
  public void doTag() throws JspException, IOException{   
    getJspContext().setAttribute("itemId", Integer.toString(this.itemId)); 
    getJspContext().setAttribute("itemName",lis.getName(itemId)); 
    getJspContext().setAttribute("itemPrice",lis.getPrice(itemId)); 
    getJspContext().setAttribute("itemUser",lis.getUser(itemId));
    getJspContext().setAttribute("itemUserId", usr.getId(lis.getUser(itemId)));
    getJspContext().setAttribute("itemUniversity",lis.getUniversity(itemId));
    getJspContext().setAttribute("itemLocation",lis.getLocation(itemId));   
    getJspContext().setAttribute("itemCategory",lis.getCategory(itemId));
    getJspContext().setAttribute("itemDescription",lis.getDescription(itemId));
    getJspContext().setAttribute("itemTime",lis.getTimePosted(itemId));
    getJspContext().setAttribute("itemBidMode",lis.getBidMode(itemId));
    getJspContext().setAttribute("itemPicAmount",lis.getPicAmount(itemId));
    String bidder = lis.getHighBidder(itemId);
    if(bidder != null){
      getJspContext().setAttribute("itemHighBidder",bidder);
    }else{
      getJspContext().setAttribute("itemHighBidder",lis.getUser(itemId));
    }

    getJspBody().invoke(null);
  }
}

