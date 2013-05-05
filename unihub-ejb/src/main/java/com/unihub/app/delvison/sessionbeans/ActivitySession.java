package com.unihub.app;

import javax.ejb.Remote;  
import javax.ejb.Stateful;
import javax.annotation.Resource;
import java.util.*;
import javax.naming.*;
import javax.persistence.*;

@Stateful (name="ActivityEJB")
@Remote
public class ActivitySession implements ActivityEJB {
  @PersistenceContext
  EntityManager em;
  
  public void createActivity(int itemId, String user, int action){
  	Activity a = new Activity(itemId, user, action);
  	em.persist(a);
  }

  public String getActivityById(int id){
  	String query ="SELECT * FROM Activity WHERE id=\'"+id+"\';";
    Query q = em.createNativeQuery(query, Activity.class);
    ArrayList<Activity> b = (ArrayList)q.getResultList();
    Activity a = b.get(0);
    return a.getActualActivity();
  }

  public ArrayList<Activity> getActivitiesByItem(int itemId){
  	 String query ="SELECT * FROM Activity WHERE itemId=\'"+itemId+"\';";
    Query q = em.createNativeQuery(query, Activity.class);
    return (ArrayList)q.getResultList();
  }
}