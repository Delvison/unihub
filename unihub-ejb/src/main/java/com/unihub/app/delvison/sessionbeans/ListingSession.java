//@author Delvison
//This sessionbean allows CRUD operations for individual listings.

package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


@Stateful
@Remote(ListingObjEJB.class)
@WebService
public class ListingSession implements ListingObjEJB {

  int id;
  ListingsObj lis = ListingsObj.create();
  
 @WebMethod
 public int addStuff(String user, String name, String price, String university,
  String location, String category, String description, String bid) {
    Date now = new Date();
    int i = lis.addStuff(user, name, price, university, location, category,
                         description, now, bid);    
    return i;
  }
      
  @WebMethod    
  public Stuff getStuff(int passedId) {
    Stuff stuff = lis.stuffs.get(0);
    for (Stuff s: lis.stuffs){
      if (s.getId() == passedId)
        stuff = s;
    }
    return stuff;
  }
  
  @WebMethod
  public ArrayList<Stuff> userSearch(String userSearched){
    ArrayList<Stuff> listingsByTheUser = new ArrayList<Stuff>();
    for (Stuff s: lis.stuffs){
      if(s.getUser().equals(userSearched)){
        listingsByTheUser.add(s);
      }
    }
    return listingsByTheUser; 
  }
   
   public void updateContent(int id, String name, String price, String university, 
     String location, String category, String description, String bid){
    Stuff s = lis.getStuff(id);
    s.updateContent(name,price,university,location,category,description,bid);
  }
  
  public int getPicAmount(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getPicAmount();
  }
  
  public String getName(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getName();
  }
  
  public String getPrice(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getPrice();
  }
  
  public String getUser(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getUser();
  }
  
  public String getUniversity(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getUniversity();
  }
  
  public String getLocation(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getLocation();
  }
  
  public int getId(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getId();
  }
  
  public String getDescription(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getDescription();
  }
  
  public String getBidMode(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getBidMode();
  }
  
  public String getHighBidder(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getHighBidder();
  }
  
  public String getCategory(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getCategory();
  }
  
  public String getTimePosted(int itemId){
    Stuff a = lis.getStuff(itemId);
    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    String datePosted = formatter.format(a.getTimePosted());
    return datePosted;
  }
  
  public String getDir(int itemId){
    Stuff a = lis.getStuff(itemId);
    return a.getDir();
  }
}
