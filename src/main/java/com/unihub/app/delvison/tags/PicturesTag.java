/*
allows access to individual 
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class PicturesTag extends SimpleTagSupport{
  private int itemId;
  String dir;
  
  public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }
  
  public void doTag() throws JspException, IOException{
    ListingsObj lis = ListingsObj.create();
    /* find 'Stuff' by id */
    Stuff stuff = lis.getStuff(itemId);
    
      /* Find Pictures Algorithm */
    dir = stuff.dir;
    for (int i=1; i<4; i++){
      File pic = new File(dir+"/"+Integer.toString(i)+".jpg");
      if (!pic.exists()){
        getJspContext().setAttribute("image"+Integer.toString(i),"#");
      } else {
        getJspContext().setAttribute("image"+Integer.toString(i),pic);
      }     
    }
    
    getJspBody().invoke(null);
  }
}
