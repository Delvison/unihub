package com.unihub.app;

import javax.ejb.Remote;
import java.util.ArrayList;
import java.util.Date;
import javax.naming.*;
import javax.naming.directory.*;
import java.util.List;

@Remote
public interface ActivityEJB {
  public void createActivity(int itemId, String user, int action);
  public String getActivityById(int id);
  public ArrayList<Activity> getActivitiesByItem(int itemId);
}