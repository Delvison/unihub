package com.unihub.app;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.*;
import javax.naming.directory.*;

@Remote
public interface ListingObjInterfaceRemote {

  public int addStuff(String user, String name, String price, String university,
  String location, String category, String description, Date now, String bid);
  public void updateContent(int id, String name, String price, String university, String location, String category, String description, String bid);
  public Stuff getStuff(int passedId);
  public ArrayList<Stuff> userSearch(String userSearched);
}
