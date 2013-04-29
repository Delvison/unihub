/*
temporary model class for invidual items posted
*/

package com.unihub.app;
import java.util.Date;
import java.io.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Stuff implements Serializable{
  static final long serialVersionUID = 1;
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  public int id;
  @NotNull public String name;
  @NotNull public String price;
  @NotNull public String user;
  @NotNull public String university;
  @NotNull public String location;
  // have to add these
  @Column(name="description", nullable=false, length=1000) public String description;
  @NotNull public String bidMode; //if true, item to be sold in bidding mode (yes or no)
  public String highBidder; //holds value of the user who ahs the highest bid
  @NotNull public String category;
  public Date timePosted;
  private String dir;
  @Transient private ItemActivityObj activityLog;
  private int picAmount; //amount of pictures uploaded for the item
  private String thumbnail;

  public Stuff(){}
  
  public Stuff(String user, String name, String price, String university,
  String location, String category, String description, Date now, String bid){
    this.user = user;
    this.name = name;
    this.price = price;
    this.university = university;
    this.location = location;
    //this.id = id;
    this.category = category;
    this.description = description;
    this.timePosted = now;
    this.bidMode = bid;
    this.activityLog = new ItemActivityObj(this.id);
    this.picAmount = 0;
  }

  public void updateContent(String name, String price, String university,
  String location, String category, String description, String bid){
    this.name = name;
    this.price = price;
    this.university = university;
    this.location = location;
    this.category = category;
    this.description = description;
    this.bidMode = bid;
  }
  
  public String getContent(){
    String c = name+" - "+price+" - "+university+" - "+location+" - "+ user;
    return c;
  }
  
  //function to return all content
  public String[] getContentArray(){
    String[] a = new String[9];
    a[0] = this.name;
    a[1] = this.price;
    a[2] = this.user;
    a[3] = this.university;
    a[4] = this.location;
    a[5] = Integer.toString(this.id); 
    a[6] = this.category;
    a[7] = this.description;
    if (this.thumbnail != null){
      a[8] = this.thumbnail;
    }else{ a[8] = "none";}
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
    String activity = bidder+" has placed a bid of $"+newPrice;
    this.addActivity(activity);
  }

  public void addActivity(String someActivity){
    activityLog.addActivity(someActivity);
  }

  public ItemActivityObj getActivityObj(){
    return this.activityLog;
  }
  
  public String getName(){
    return this.name;
  }

  public void setName(String n){
    this.name = n;
  }
  
  public String getPrice(){
    return this.price;
  }

  public void setPrice(String p){
    this.price = p;
  }
  
  public String getUniversity(){
    return this.university;
  }

  public void setUniversity(String u){
    this.university = u;
  }
  
  public String getLocation(){
    return this.location;
  }

  public void setLocation(String l){
    this.location = l;
  }
  
  public String getDescription(){
    return this.description;
  }

  public void setDescriptiom(String d){
    this.description = d;
  }
  
  public String getBidMode(){
    return this.bidMode;
  }

  public void setBidMode(String b){
    this.bidMode = b;
  }
  
  public String getHighBidder(){
    return this.highBidder;
  }

  public void setHighBidder(String h){
    this.highBidder = h;
  }
  
  public String getCategory(){
    return this.category;
  }

  public void setCategory(String c){
    this.category = c;
  }
  
  public Date getTimePosted(){
    return this.timePosted;
  }
  
  public String getDir(){
    return this.dir;
  }

  public void setDir(String d){
    this.dir = d;
  }
  
  public String getUser(){
    return this.user;
  }

  public int getPicAmount(){
    return this.picAmount;
  }

  public void setPicAmount(){
    this.picAmount = picAmount +1;
  }

  public void setThumbnail(String t){
    this.thumbnail=t;
  }

  public String toString(){
    String info="Name: "+this.name+"\n Price: "+this.price+"\n Seller: "+this.user+
      "\n Description"+this.description;
    return info;
  }
}
