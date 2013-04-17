// @author Delvison
/*
allows access to individual 
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import javax.ejb.*;

public class CategoryListTag extends SimpleTagSupport{
  private String category;
  private String[] categories = {"Appliances",
    "Art Supplies",
    "Bikes",
    "Books",
    "Cars" ,
    "Cell Phones",
    "Clothes",
    "Computers",
    "Electronics",
    "Freebies",
    "Furniture",
    "Games",
    "Jobs",
    "Music",
    "Musical Instruments",
    "Movies",
    "Pets",
    "Sporting Goods",
    "Wanted",
    "Everything Else.."};
  
  public void setCategory(String category){
    this.category = category;  
  }
  
  public void doTag() throws JspException, IOException{
    JspWriter out = getJspContext().getOut();
    int total = categories.length;

    for (int i=0; i<total; i++){
      if (category != null && category.equals(categories[i])){
        out.print("<option selected=\"selected\">"+categories[i]+"</option>");
      }else{
        out.print("<option>"+categories[i]+"</option>");
      }
    }
  }
}