package com.unihub.app;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.*;
import javax.naming.directory.*;

@Remote
public interface ListingObjEJB {

  public int addStuff(String user, String name, String price, String university,
  String location, String category, String description, String bid);
  public void updateContent(int id, String name, String price, String university, String location, String category, String description, String bid);
  public Stuff getStuff(int passedId);
  public ArrayList<Stuff> userSearch(String userSearched);
  public int getPicAmount(int itemId);
  public String getName(int itemId);
  public String getPrice(int itemId);
  public String getUser(int itemId);
  public String getUniversity(int itemId);
  public String getLocation(int itemId);
  public int getId(int itemId);
  public String getDescription(int itemId);
  public String getBidMode(int itemId);
  public String getHighBidder(int itemId);
  public String getCategory(int itemId);
  public String getTimePosted(int itemId);
  public String getDir(int itemId);
  public ArrayList<Stuff> getArrayList();
  //public String getActivityLog();
}
