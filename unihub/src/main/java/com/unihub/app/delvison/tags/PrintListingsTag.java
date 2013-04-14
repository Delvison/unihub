// @author Delvison
/*
Prints out comments
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.ejb.*;


public class PrintListingsTag extends SimpleTagSupport{
  @EJB ListingObjEJBStateful lis;
  String user;
  String category;
  int limit;

  public void setUser(String user){
    this.user = user;
  }

  public void setCategory(String category){
    this.category = category;
  }

  public void setLimit(String lim){
    this.limit = Integer.parseInt(lim);
  }

  public void doTag() throws JspException, IOException{
      ArrayList<Stuff> stuffs = lis.getArrayList();
    if (category != null && !category.equals("All") && !category.equals("search") ){
      this.printForCategory(stuffs);
    }else if (user != null){
      this.printForUser(stuffs);
    }else if(this.limit != 0){
      this.printLimited(this.limit);
    }else{
      this.printAll(stuffs);
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

  private void printLimited(int lim) throws JspException, IOException {
    ArrayList<Stuff> stuffs = lis.getArrayList();
    ArrayList<Stuff> limitedList= new ArrayList<Stuff>();
    limitedList.add(stuffs.get(1));
    for(int i=2;i<lim;i++){
      limitedList.add(stuffs.get(i));
    }

    for (Stuff s: limitedList){
      String[] c = s.getContentArray();
      getJspContext().setAttribute("listingName",c[0]); 
      getJspContext().setAttribute("listingPrice",c[1]); 
      getJspContext().setAttribute("listingUser",c[2]); 
      getJspContext().setAttribute("listingUniversity",c[3]); 
      getJspContext().setAttribute("listingLocation",c[4]);   
      getJspContext().setAttribute("listingId",c[5]);
      getJspContext().setAttribute("listingCategory",c[6]);
      String desc = c[7];
      char[] chars = desc.toCharArray();
      int sz = chars.length;
      String d="";
      if(sz > 550){
        d = String.copyValueOf(chars, 0, 550);
        d = d+" ...";
      }else{
        d = c[7];
      }
      getJspContext().setAttribute("listingDescription",d);
      DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
      String datePosted = formatter.format(s.timePosted);
      String pic="";

      if (c[8].equals("none")){
        pic = "http://placehold.it/320x200";
      }else{
        pic = "listings/"+c[5]+"/"+c[8];
      }
      getJspContext().setAttribute("listingPhoto",pic);
      getJspContext().setAttribute("listingDate",datePosted);
      getJspBody().invoke(null);
    }
  }

  private void printForCategory(ArrayList<Stuff> stuffs) throws JspException, IOException{
    String cat = this.filter(category);
      for (Stuff s: stuffs){
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
  }

  private void printForUser(ArrayList<Stuff> stuffs) throws JspException, IOException{
     /* print all listings belonging to user passed in */
      for (Stuff s: stuffs){
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
  }

  private void printAll(ArrayList<Stuff> stuffs) throws JspException, IOException{
    /* print all listings */
      for (Stuff s: stuffs){
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
