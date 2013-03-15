package com.unihub.app;

import java.util.Date;

public class DummyData{
  public static void generate(){
    ListingsObj lis = ListingsObj.create();
    String user = "User1";
    String university = "SUNY Oswego";
    String location = "NY";    
    String category = "Misc.";
    String description = "words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words ";
    String price = "100";
    Date now = new Date();
    boolean bid = false;
    
    String description1="Cervelo Soloist Carbon SL bike for sale SIZE: 54. Person 5'8\" to 6 SRAM Red components throughout except Ultegra Deraileur and Cassette (works better with Q-Rings) Mavic Cosmic Carbon Ultimate Wheels (MSRP $5000). Look Pedals. Brand New Chain. John Cobb V-Flow Max Seat, Deda Zero 100 Stem, Deda Newton Handlebars. Comes with HED Aerobars. I have this bike built for power. It weighs in at a tad under 15lbs. You could easily drop it below 14 if you wanted. I think it performs better like this, plus it is race legal. CASH only";
    String item1="Cervelo SLC-SL Carbon Racing";
    lis.addStuff(user, item1, "1500", university, location, "Bicycles", description1, now, bid);
    lis.addStuff(user, "PS3", price, university, location, "Electronics", description, now, bid);
    lis.addStuff(user, "Thinkpad", price, university, location, "Electronics", description, now, bid);
    lis.addStuff(user, "Nexus 4", price, university, location, "Cell Phones", description, now, bid);  
    lis.addStuff(user, "Bike", price, university, location, "Bicycles", description, now, bid);  
    lis.addStuff(user, "Mouse", price, university, location, "Electronics", description, now, bid);  
    lis.addStuff(user, "Keyboard", price, university, location, "Electronics", description, now, bid);  
    lis.addStuff(user, "Desk", price, university, location, "Furniture", description, now, bid);  
    lis.addStuff(user, "Skateboard", price, university, location, "Misc.", description, now, bid);
    lis.addStuff(user, "iPhone", price, university, location, "Cell Phones", description, now, bid);
    lis.addStuff(user, "Shoes", price, university, location, "Misc.", description, now, bid);          
  }

}
