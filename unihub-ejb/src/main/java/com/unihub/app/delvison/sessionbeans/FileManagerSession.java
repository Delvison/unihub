//@author Delvison
//This sessionbean allows for the upload and removal of photos

package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import javax.servlet.http.Part;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;

public class FileManagerSession {
  private int itemId;
  
  /* ALLOWS UPLOADS OF PNG & JPG FOR POST */
  public void uploadPhoto(int itemId, String path, Part filePart, String fileName)
    throws IOException, FileNotSupportedException, PhotoLimitException{
  	this.itemId = itemId;
    String image_url = "/listings/"+Integer.toString(itemId);
    
    // Check for .jpg or .png extension
    String extension = "";
    int i = fileName.lastIndexOf('.');
    if (i > 0) {
      extension = fileName.substring(i+1);
    }

    /* CHECK FOR VALIDITY HERE */
    if (extension.equals("jpg")||extension.equals("png")){
      if (ListingsObj.create().getStuff(itemId).getPicAmount() < 4){
        //check if dir already exists
        File chkDir = new File(path);
        ListingsObj.create().getStuff(itemId).setDir(path);
        if (!chkDir.exists()){
          chkDir.mkdir(); //create dir
        }

        OutputStream out = null;
        InputStream filecontent = null;
        try {
          out = new FileOutputStream(new File(path + File.separator + fileName));
          filecontent = filePart.getInputStream();
          int read = 0;
          final byte[] bytes = new byte[1024];
          
          while ((read = filecontent.read(bytes)) != -1) {
            out.write(bytes, 0, read);
          }
          /* FILE UPLOAD SUCCESS */
          // ADD 1 to the item's picture amount upon success
          ListingsObj.create().getStuff(itemId).setPicAmount();
        } catch (FileNotFoundException fne) {
          System.out.println("Error");
        } finally {
          if (out != null) {
            out.close();
          }
          if (filecontent != null) {
            filecontent.close();
          }
        }
      } else {
        /* ELSE, 4 pictures exist aleady for item */
        //custom exception
        throw new PhotoLimitException("4 images already exist");
      }
    }else{
      /* ELSE, file wasn't a jpg or png */            
      //custom exception
      throw new FileNotSupportedException("File was not a jpg or png");
    }    
  }

  /* METHOD TO REMOVE PHOTO */
  public void removePhoto(String fileToRemove){
  	//this.itemId = itemId;
    File rm = new File(fileToRemove);
    rm.delete();
    //String[] getId = rmFile.split("/");
    //String itemId = getId[getId.length-2];
    //res.sendRedirect("uploadPhoto?id="+itemId+"&msg=removed");
  }
}
