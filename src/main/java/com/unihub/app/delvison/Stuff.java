package com.unihub.app;

public class Stuff{
  String name;
  String price;
  String user;
  String university;
  String location;
  
  public Stuff(String user, String name, String price, String university,
  String location){
  this.user = user;
  this.name = name;
  this.price = price;
  this.university = university;
  this.location = location;
  }
  
  public String getContent(){
    String c = name+" - "+price+" - "+university+" - "+location+" - "+ user;
    return c;
  }
}
