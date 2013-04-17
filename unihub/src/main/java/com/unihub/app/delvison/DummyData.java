package com.unihub.app;

import java.util.Date;
import javax.ejb.*;
import javax.naming.*;


public class DummyData{
  public static void generate() throws NamingException{

    Context context = new InitialContext();
    ListingObjEJBStateless lis = (ListingObjEJBStateless) context.lookup("ejb:unihub-ear/unihub-ejb//ListingSessionStateless!com.unihub.app.ListingObjEJBStateless");
    
    String user = "User1";
    String university = "SUNY Oswego";
    String location = "NY";    
    String category = "Misc.";
    String description = "words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words words ";
    String price = "100";
    String bid = "no";
    
    String description1="Cervelo Soloist Carbon SL bike for sale SIZE: 54. Person 5'8\" to 6 SRAM Red components throughout except Ultegra Deraileur and Cassette (works better with Q-Rings) Mavic Cosmic Carbon Ultimate Wheels (MSRP $5000). Look Pedals. Brand New Chain. John Cobb V-Flow Max Seat, Deda Zero 100 Stem, Deda Newton Handlebars. Comes with HED Aerobars. I have this bike built for power. It weighs in at a tad under 15lbs. You could easily drop it below 14 if you wanted. I think it performs better like this, plus it is race legal. CASH only";
    String item1="Cervelo SLC-SL Carbon Racing";
    lis.addStuff(user, item1, "1500", university, location, "Bicycles", description1, "yes");
    lis.addStuff(user, "Dell PC with 17 LCD monitor ", "100", university, location, "Computers", "Professionally Refurbished Dell 755 USFF Desktop + 17 Monitor + Keyboard + Mouse. Important Specifications: Processor: 1.8-2.66GHz Core 2 Duo, Memory: 2 GB, Hard Drive: 160GB, Optical Drive: CD/DVD Combo Drive, Operating System: Windows 7 Professional", "yes");
    lis.addStuff(user, "White sprint iPhone 4s 16gb", "300", university, location, "Cell Phones", "This 4s is in absolutely beautiful condition and works perfectly. It has a clean esn so it's ready to go on your account. It comes with the original box and charger.", "yes");
    lis.addStuff(user, "Multivariable Calculus, Ninth Edition ", "70", university, location, "Books", "Multivariable Calculus, Ninth Edition, Hardcover by Larson & Edwards ISBN-10: 0547209975 | ISBN-13: 978-0547209975  Book is in excellent condition.", bid);  
    lis.addStuff("Delvison", "Stereo System", "495", university, location, "Eletronics", "Complete Stereo System, Relistic SCT 40, Relistic STA 2250 ,Relistic Turntable Lab 2100, Stereo Cabinet, Speakers 8 OHMS, COMPLETE SET UP $495.00", bid);  
    lis.addStuff("Mark", "Fender Mustang II amp", "150", university, location, "Musical Instruments", "Essentially brand new Fender Mustang II 1x12 40 watt modeling amp. Has seen very little use, excellent condition. I have no use for it, have upgraded to a larger amp. FEATURES: 40W, 12\" Fender Special Design speaker, All-new authentic amp modeling, 8 amp models, 24 effects from an all-new DSP platform, USB connectivity, 1/8\" headphone jack (doubles as a speaker-emulated line out), 1/8\" aux input, 17.25\"H x 18.25\"W x 8.7\"D, 24 lb.",  "yes");  
    lis.addStuff("Andy", "2010 Honda Civic R1995P LX", "11999", university, location, "Cars", "Body: 2 Dr Coupe, Color: Gray, Transmission: Automatic, Mileage: 79906, Vin: 2HGFG1B60AH505676, Drivetrain: FWD, Interior: Gray, Engine: 4 Cyl., Stock Id: R1995P", bid);  
    lis.addStuff("Yulle", "NY Yankees/Jeter Fan", "125", university, location, "Clothes", "Majestic Derek Jeter Replicia Jersey Size L + Majestic/Cool Base Batting Practice Jersey Size L + Majestic Yankees Zip-Up Jacket Size L. All lightly worn and in excellent condition", bid);  

  }

}
