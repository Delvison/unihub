/*
This class holds an arraylist that contains all the universities
of the u.s.
*/

package com.unihub.app;
import java.util.ArrayList;

public class UniDefaults{

 public ArrayList<String> universities;

 private UniDefaults(){
    universities = new ArrayList<String>();
  }
  
  private static UniDefaults defaults;
  
  public static UniDefaults create(){
    if (defaults == null){
      defaults = new UniDefaults();
    }
    return defaults;
  }
   
  public ArrayList<String> getUni() {
    return universities;
  }
  
}
