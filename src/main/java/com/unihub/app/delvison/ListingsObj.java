/* temporary class to hold listings made */
package com.unihub.app;

import java.util.ArrayList;

public class ListingsObj{
  ArrayList<Stuff> stuffs;
  int id;
  
  private ListingsObj(){
    stuffs = new ArrayList<Stuff>();
    this.id = 0;
  }
  private static ListingsObj listings;
  
 public void addStuff(String user, String name, String price, String university,
  String location){
    id = id+1;
    Stuff a = new Stuff(id, user, name, price, university, location);
    stuffs.add(a);
  }
  
  private static ListingsObj getInstance(){
    return listings;
  }
  
  public static ListingsObj create(){
    if (listings == null) {
       listings = new ListingsObj();
    }
    return listings;
  }

}
