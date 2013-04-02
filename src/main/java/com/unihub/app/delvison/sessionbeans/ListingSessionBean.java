//@author Delvison
//This sessionbean allows CRUD operations for listings.

package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.Date;

@Stateless
public class ListingSessionBean{
  private int currentId; //holds current Listing ID
  
  /* Allows for the creation of a listing */
  public void createListing(String name, String price, String university, String location,
	  String category, String description, String bid, String userName){
	  
    ListingsObj lis = ListingsObj.create();
    if (name == null || university == null ||userName==null||description==null){
        //throw custom exception
        System.out.println("Error."); //temporary
    }else{
      Date now = new Date();
      this.currentId = lis.addStuff(userName,name,price,university,location,
        	category,description,now,bid);
    }
  }

  /* Allows a listing to be edited */
  public void editListing(String id, String name, String price, String university, String location,
	String category, String description, String bid){
  	this.currentId = Integer.parseInt(id);
  	Stuff found = this.getObj(currentId);
    found.updateContent(name, price, university, location, category, description, bid);
  }

  /* Allows for a listing to be removed */
  public void removeListing(){

  }

  /* Takes an int. Returns Stuff obj that corresponds to that int */
  private Stuff getObj(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff found;
    found = lis.getStuff(itemId);
    return found;
  }

  public void readListing(int itemId){
    System.out.println(this.getObj(itemId).toString());
  }
  
  /* Returns the current Listing ID being looked at */
  public int getCurrentId(){
  	return this.currentId;
  }
}