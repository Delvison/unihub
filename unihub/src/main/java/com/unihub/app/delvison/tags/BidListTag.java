// @author Delvison
/* for editListing.jsp */
package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class BidListTag extends SimpleTagSupport{
  private String option;
  private String[] options = {"no","yes"};
  
  public void setOption(String option){
    this.option = option;  
  }
  
  public void doTag() throws JspException, IOException{
    JspWriter out = getJspContext().getOut();
    
    int total = options.length;

    for (int i=0; i<total; i++){
      if (option != null && option.equals(options[i])){
        out.print("<option selected=\"selected\">"+options[i]+"</option>");
      }else{
        out.print("<option>"+options[i]+"</option>");
      }
    }
  }
}
