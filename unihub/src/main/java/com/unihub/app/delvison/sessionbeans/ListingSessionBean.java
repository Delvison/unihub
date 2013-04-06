//@author Delvison
//This sessionbean allows CRUD operations for individual listings.

package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.ArrayList;
import javax.naming.*;

@Startup
@Singleton
public class ListingSessionBean implements ListingObjInterface{

  public ArrayList<Stuff> stuffs;
  int id;
  
  
       
       
 public int addStuff(String user, String name, String price, String university,
  String location, String category, String description, Date now, String bid){
    if (this.stuffs == null){
      stuffs = new ArrayList<Stuff>();
      this.id = 0;
    }
    id = id+1;
    Stuff a = new Stuff(id, user, name, price, university, location, category,
                         description, now, bid);
    stuffs.add(a);
    return id;
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
