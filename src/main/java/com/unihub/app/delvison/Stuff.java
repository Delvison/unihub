package com.unihub.app;

public class Stuff{
  String name;
  String price;
  String user;
  String university;
  String location;
  int id;
  
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
  
  public String[] getContentArray(){
    String[] a = new String[5];
    a[0] = this.name;
    a[1] = this.price;
    a[2] = this.user;
    a[3] = this.university;
    a[4] = this.location; 
    return a;       
  }
  
  public int getId(){
    return this.id;
  }
  
}
