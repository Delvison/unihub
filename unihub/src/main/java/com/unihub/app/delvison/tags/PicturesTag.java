// @author Delvison
/*
allows access to individual 
*/

package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import javax.ejb.*;

public class PicturesTag extends SimpleTagSupport{
  @EJB ListingObjEJBStateless lis;
  private int itemId;
  String dir;
  
  public void setItemId(String itemId){
    this.itemId = Integer.parseInt(itemId);  
  }
  
  public void doTag() throws JspException, IOException{
    int picAmount = lis.getPicAmount(this.itemId);
    
    /* Pictures Algorithm */
    if (picAmount != 0){ //if more than 0 pics exist
      String path = lis.getDir(itemId);
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
