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
  private String[] categories = {"Art Supplies","Books","Bicycles","Cell Phones",
                          "Electronics","Furniture","Musical Instruments","Misc."};
  
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