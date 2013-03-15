/*
allows access to individual 
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class PicExistTag extends SimpleTagSupport{
  private int picId;
  private int itemId;
  String dir;
  
  public void setPicId(String picId){
    this.picId = Integer.parseInt(picId);  
  }
  
    public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }
    
    public void setPath(String path){
    this.dir = path;  
  }
  
  public void doTag() throws JspException, IOException{

    JspWriter out = getJspContext().getOut();
    ListingsObj lis = ListingsObj.create();
    /* find 'Stuff' by id */
    Stuff stuff = lis.getStuff(itemId);
    
      /* Find Pictures Algorithm */

      File pic = new File(dir+"/listings"+Integer.toString(picId)+".jpg");
      if (!pic.exists()){
        out.print("data-src=\"holder.js/260x180\"");
      } else {
        out.print("src="+dir+"/"+picId+".jpg");
      }     
  }
}
