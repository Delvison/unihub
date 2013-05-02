/* temporary class to hold listings made */
package com.unihub.app;

import java.util.ArrayList;
import java.util.Date;
import javax.ejb.*;
import java.io.*;
import javax.persistence.*;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

public class ListingsObj implements Serializable{
  @PersistenceContext
  EntityManager em;

  public ArrayList<Stuff> stuffs;
  int id;
  
  private ListingsObj(){
    stuffs = new ArrayList<Stuff>();
    this.id = 0;
  }
  private static ListingsObj listings;
  
 public int addStuff(String user, String name, String price, String university,
  String location, String category, String description, Date now, String bid){
    id = id+1;
    Stuff a = new Stuff(user, name, price, university, location, category,
                         description, now, bid);
    stuffs.add(a);
    //em.persist(a);
    return id;
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
  
  public Stuff getStuff(int passedId) {
    Stuff stuff = stuffs.get(0); 
    for (Stuff s: stuffs){
      if (s.id == passedId)
        stuff = s;
    }
    return stuff;
  }
  
  public ArrayList<Stuff> userSearch(String userSearched){
    ArrayList<Stuff> listingsByTheUser = new ArrayList<Stuff>();
    
    for (Stuff s: stuffs){
      if(s.user.equals(userSearched)){
        listingsByTheUser.add(s);
      }
    }
    return listingsByTheUser; 
  }
}
