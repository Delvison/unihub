// @author Delvison
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
    Stuff stuff = lis.getStuff(itemId);
    
    /* Pictures Algorithm */
    if (stuff.getPicAmount() != 0){ //if more than 0 pics exist
      String path = stuff.getDir();
      File dir = new File(path); 
      for (File f : dir.listFiles()){ //for each file in the dir
        String img_url = "listings/"+Integer.toString(itemId)+"/"+f.getName();
        getJspContext().setAttribute("imagePath",img_url);
        getJspContext().setAttribute("imageDir",path+"/"+f.getName());
        getJspBody().invoke(null);
      }
    }    
  }
}

//Iterator it = FileUtils.iterateFiles(new File(path),null, false)
// while it.hasNext()...