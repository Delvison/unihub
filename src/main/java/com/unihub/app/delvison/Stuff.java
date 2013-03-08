/*
temporary model class for invidual items posted
*/

package com.unihub.app;
import java.util.Date;

public class Stuff{
  public String name;
  public String price;
  public String user;
  public String university;
  public String location;
  public int id;
  // have to add these
  public String description;
  public boolean wantBid; //if true, item to be sold in bidding mode
  public String highBidder; //holds value of the user who ahs the highest bid
  public String category;
  public Date timePosted;
  
  public Stuff(int id, String user, String name, String price, String university,
  String location){
  this.user = user;
  this.name = name;
  this.price = price;
  this.university = university;
  this.location = location;
  this.id = id;
  }
  
  public String getContent(){
    String c = name+" - "+price+" - "+university+" - "+location+" - "+ user;
    return c;
  }
  
  //function to return all content
  public String[] getContentArray(){
    String[] a = new String[5];
    a[0] = this.name;
    a[1] = this.price;
    a[2] = this.user;
    a[3] = this.university;
    a[4] = this.location; 
    return a;       
  }
  
  //function to get id
  public int getId(){
    return this.id;
  }
  
  //function to update price
  public void updatePrice(String newPrice){
    this.price = newPrice;
  }
  
  //method to be called upon bidding
  public void bid(String bidder, String newPrice){
    this.updatePrice(newPrice);
    this.highBidder = bidder;
  }
}
