package com.unihub.app;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.*;
import javax.naming.directory.*;
import javax.jws.WebService;
import java.util.List;

@Remote
public interface ListingObjEJBStateful {
  public ArrayList<Stuff> userSearch(String userSearched);
  public ArrayList<Stuff> getArrayList();
  public int getArrayListSize();
  public List getList();
  public ArrayList<Stuff> getListForUser(int limit, String user);


}
