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

@Stateful (name="ListingObjEJB") //should be stateless
@Remote(ListingObjEJB.class)
@WebService
public class ListingSession implements ListingObjEJB {
  
 @WebMethod
 public int addStuff(String user, String name, String price, String university,
  String location, String category, String description, String bid) {
    ListingsObj lis = ListingsObj.create();
    Date now = new Date();
    int i = lis.addStuff(user, name, price, university, location, category,
                         description, now, bid);    
    return i;
  }
      
  @WebMethod    
  public Stuff getStuff(int passedId) {
    ListingsObj lis = ListingsObj.create();
    Stuff stuff = lis.stuffs.get(0);
    for (Stuff s: lis.stuffs){
      if (s.getId() == passedId)
        stuff = s;
    }
    return stuff;
  }
  
  @WebMethod
  public ArrayList<Stuff> userSearch(String userSearched){
    ListingsObj lis = ListingsObj.create();
    ArrayList<Stuff> listingsByTheUser = new ArrayList<Stuff>();
    for (Stuff s: lis.stuffs){
      if(s.getUser().equals(userSearched)){
        listingsByTheUser.add(s);
      }
    }
    return listingsByTheUser; 
  }
  
  public ArrayList<Stuff> getArrayList(){
    ListingsObj lis = ListingsObj.create();
    return lis.stuffs;
  }
  
  @WebMethod       
   public void updateContent(int id, String name, String price, String university, 
     String location, String category, String description, String bid){
    ListingsObj lis = ListingsObj.create();
    Stuff s = lis.getStuff(id);
    s.updateContent(name,price,university,location,category,description,bid);
  }
    @WebMethod    
  public int getPicAmount(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getPicAmount();
  }
   @WebMethod     
  public String getName(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getName();
  }
  @WebMethod      
  public String getPrice(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getPrice();
  }
    @WebMethod     
  public String getUser(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getUser();
  }
    @WebMethod    
  public String getUniversity(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getUniversity();
  }
  
  public String getLocation(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getLocation();
  }
  @WebMethod      
  public int getId(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getId();
  }
   @WebMethod     
  public String getDescription(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getDescription();
  }
   @WebMethod     
  public String getBidMode(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getBidMode();
  }
  @WebMethod      
  public String getHighBidder(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getHighBidder();
  }
  @WebMethod      
  public String getCategory(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getCategory();
  }
  @WebMethod      
  public String getTimePosted(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    String datePosted = formatter.format(a.getTimePosted());
    return datePosted;
  }
  @WebMethod      
  public String getDir(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getDir();
  }
  @WebMethod      
  public void setDir(int itemId, String dir){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    a.setDir(dir);
  }
  
  public void setPicAmount(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a =lis.getStuff(itemId);
    a.setPicAmount();  
    }
}
