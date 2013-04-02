//@author Delvison
//This sessionbean allows for the upload and removal of photos

package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;


@Stateless
public class FileUploadSessionBean {
  private int itemId;
  
  public void uploadPhoto(int itemId){
  	this.itemId = itemId;

  }

  public void removePhoto(int itemId){
  	this.itemId = itemId;

  }

}
