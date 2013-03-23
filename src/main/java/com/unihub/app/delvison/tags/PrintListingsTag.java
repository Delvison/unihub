/*
Prints out comments
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;


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
    
    if (category != null && (!(category.equals("All"))) && (!(category.equals("search"))) ){
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
          getJspContext().setAttribute("listingCategory",c[6]);
          DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
          String datePosted = formatter.format(s.timePosted);
          getJspContext().setAttribute("listingDate",datePosted);
          getJspBody().invoke(null);
        }
      }
    }else if (user != null){
      /* print all listings belonging to user passed in */
      for (Stuff s: lis.stuffs){
        if (s.user.equals(this.user)){
          String[] c = s.getContentArray();
          getJspContext().setAttribute("listingName",c[0]); 
          getJspContext().setAttribute("listingPrice",c[1]); 
          getJspContext().setAttribute("listingUser",c[2]); 
          getJspContext().setAttribute("listingUniversity",c[3]); 
          getJspContext().setAttribute("listingLocation",c[4]);   
          getJspContext().setAttribute("listingId",c[5]);
          getJspContext().setAttribute("listingCategory",c[6]);
          DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
          String datePosted = formatter.format(s.timePosted);
          getJspContext().setAttribute("listingDate",datePosted);
          getJspBody().invoke(null);
        }
      }
    }else if(this.category.equals("search")){
      /* print listings from search query result */
    
    }else{
      /* print all listings */
      for (Stuff s: lis.stuffs){
          String[] c = s.getContentArray();
          getJspContext().setAttribute("listingName",c[0]); 
          getJspContext().setAttribute("listingPrice",c[1]); 
          getJspContext().setAttribute("listingUser",c[2]); 
          getJspContext().setAttribute("listingUniversity",c[3]); 
          getJspContext().setAttribute("listingLocation",c[4]);   
          getJspContext().setAttribute("listingId",c[5]);
          getJspContext().setAttribute("listingCategory",c[6]);  
          DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
          String datePosted = formatter.format(s.timePosted);
          getJspContext().setAttribute("listingDate",datePosted);        
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