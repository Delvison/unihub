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
  	String finalAction = " ";
    switch (action){
      //if a user comments
      case 1:  	finalAction = user+" commented on ";
      			break;
      //if a user bids
      case 2:   finalAction = user+" bidded on ";
      			break;
      default:  break;
    }
    String query ="SELECT * FROM Stuff WHERE id=\'"+itemId+"\';";
    Query q = em.createNativeQuery(query, Stuff.class);
    ArrayList<Stuff> b = (ArrayList)q.getResultList();
    Stuff a = b.get(0);
    finalAction = finalAction+a.getName();
  	Activity act = new Activity(itemId, user, finalAction);
  	em.persist(act);
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