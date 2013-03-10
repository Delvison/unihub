package com.unihub.app;

import java.util.Date;

public class DummyData{
  public static void generate(){
    ListingsObj lis = ListingsObj.create();
    String user = "user1";
    String university = "SUNY Oswego";
    String location = "NY";    
    String category = "Misc.";
    String description = "words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words ";
    String price = "$100";
    Date now = new Date();
    boolean bid = false;
    
    lis.addStuff(user, "PS3", price, university, location, category, description, now, bid);
    lis.addStuff(user, "Thinkpad", price, university, location, category, description, now, bid);
    lis.addStuff(user, "Nexus 4", price, university, location, category, description, now, bid);  
    lis.addStuff(user, "Bike", price, university, location, category, description, now, bid);  
    lis.addStuff(user, "Mouse", price, university, location, category, description, now, bid);  
    lis.addStuff(user, "Keyboard", price, university, location, category, description, now, bid);  
    lis.addStuff(user, "Desk", price, university, location, category, description, now, bid);  
    lis.addStuff(user, "Skateboard", price, university, location, category, description, now, bid);
    lis.addStuff(user, "iPhone", price, university, location, category, description, now, bid);
    lis.addStuff(user, "Shoes", price, university, location, category, description, now, bid);          
  }

}
