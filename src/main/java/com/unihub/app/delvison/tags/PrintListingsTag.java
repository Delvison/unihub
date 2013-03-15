/*
Prints out comments
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class PrintListingsTag extends SimpleTagSupport{
  String user;
  String category;

  public void setUser(String user){
    this.user = user;
  }

  public void setCategory(String category){
    this.category = category;
  }

  public void doTag() throws JspException, IOException{
    ListingsObj lis = ListingsObj.create();
    
    if (category != null && (!(category.equals("All")))){
      String cat = this.filter(category);
      for (Stuff s: lis.stuffs){
        if (s.category.equals(cat)){
          String[] c = s.getContentArray();
          getJspContext().setAttribute("listingName",c[0]); 
          getJspContext().setAttribute("listingPrice",c[1]); 
          getJspContext().setAttribute("listingUser",c[2]); 
          getJspContext().setAttribute("listingUniversity",c[3]); 
          getJspContext().setAttribute("listingLocation",c[4]);   
          getJspContext().setAttribute("listingId",c[5]);
          getJspBody().invoke(null);
        }
      }
    }else if (user != null){
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
          getJspBody().invoke(null);
        }
      }
    }else{
      for (Stuff s: lis.stuffs){
          String[] c = s.getContentArray();
          getJspContext().setAttribute("listingName",c[0]); 
          getJspContext().setAttribute("listingPrice",c[1]); 
          getJspContext().setAttribute("listingUser",c[2]); 
          getJspContext().setAttribute("listingUniversity",c[3]); 
          getJspContext().setAttribute("listingLocation",c[4]);   
          getJspContext().setAttribute("listingId",c[5]);
          getJspBody().invoke(null);
      }
    }  
  }

  private String filter(String cat){
    String properCat="";
    if (cat != null){
      if (cat.equals("Art")){
        properCat = "Art Supplies";
      } else if (cat.equals("Phone")){
        properCat = "Cell Phones";
      } else if (cat.equals("Musical")){
        properCat = "Musical Instruments";
      } else{
        properCat = cat;
      }
    }
      return properCat;
  }
}