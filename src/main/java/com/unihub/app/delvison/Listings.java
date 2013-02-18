/* temporary class to hold listings made */
package com.unihub.app;

import java.util.ArrayList;

public class Listings{
  ArrayList<Stuff> stuffs;
  
  private Listings(){
    stuffs = new ArrayList<Stuff>();
  }
  private static Listings listings;
  
 public void addStuff(String user, String name, String price, String university,
  String location){
    Stuff a = new Stuff(user, name, price, university, location);
    stuffs.add(a);
  }
  
  private static Listings getInstance(){
    return listings;
  }
  
  public static Listings create(){
    if (listings == null) {
       listings = new Listings();
    }
    return listings;
  }

}
