/*
Prints out comments
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class PrintListingsTag extends SimpleTagSupport{
  String user;

  public void setUser(String user){
    this.user = user;
  }

  public void doTag() throws JspException, IOException{
    ListingsObj lis = ListingsObj.create();
    
    if (user == null){
      for (Stuff s: lis.stuffs){
          String[] c = s.getContentArray();
          getJspContext().setAttribute("listingName",c[0]); 
          getJspContext().setAttribute("listingPrice",c[1]); 
          getJspContext().setAttribute("listingUser",c[2]); 
          getJspContext().setAttribute("listingUniversity",c[3]); 
          getJspContext().setAttribute("listingLocation",c[4]);   
          getJspContext().setAttribute("listingId",c[5]);
          File file = new File("C:\\Directory1");
          getJspBody().invoke(null);
      }
    }else{
    //do marks stuff
      for (Stuff s: lis.stuffs){
        if (s.user.equals(this.user)){
          String[] c = s.getContentArray();
          getJspContext().setAttribute("listingName",c[0]); 
          getJspContext().setAttribute("listingPrice",c[1]); 
          getJspContext().setAttribute("listingUser",c[2]); 
          getJspContext().setAttribute("listingUniversity",c[3]); 
          getJspContext().setAttribute("listingLocation",c[4]);   
          getJspContext().setAttribute("listingId",c[5]);
          File file = new File("C:\\Directory1");
          getJspBody().invoke(null);
        }
      }
    }
  }
}
