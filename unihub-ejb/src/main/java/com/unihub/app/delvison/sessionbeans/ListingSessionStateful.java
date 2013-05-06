//@author Delvison
//This sessionbean allows CRUD operations for individual listings.

package com.unihub.app;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.annotation.Resource;
import java.util.Date;
import java.util.ArrayList;
import java.util.List;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.persistence.*;

@Stateful (name="ListingObjEJBStateful") //should be stateless
@Remote
public class ListingSessionStateful implements ListingObjEJBStateful {
  @PersistenceContext
  EntityManager em;
  
  //get an arraylist of 'Stuff' posted by a particular user
  public ArrayList<Stuff> userSearch(String userSearched){
    String query ="SELECT * FROM Stuff WHERE user=\'"+userSearched+"\' ORDER BY"+
             " timePosted DESC;";
    Query q = em.createNativeQuery(query, Stuff.class);
    return (ArrayList)q.getResultList();
  }

  public List<Stuff> searchListing(String keywords){
    String query = "SELECT * FROM Stuff WHERE name LIKE \'%"+keywords+"%\';";
    Query q = em.createNativeQuery(query, Stuff.class);
    return q.getResultList();
  }
  
  //get an arraylist of all listings
  public ArrayList<Stuff> getArrayList(){
    ListingsObj lis = ListingsObj.create();
    return (ArrayList) this.getList();
  }

  //verifies that the Database is not empty
  public int getArrayListSize(){
    int i = 0;
    String query ="SELECT * FROM Stuff ORDER BY id DESC LIMIT 7;";
    Query q = em.createNativeQuery(query, Stuff.class);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    if (q != null && p.size()>1){
      i = p.size(); 
    }
    return i;
  }

  //get a list of all 'Stuff' objects
  public List getList(){
    String query = "SELECT * FROM Stuff;";
    Query q = em.createNativeQuery(query, Stuff.class);
    return q.getResultList(); 
  }

  // return an arraylist of 'Stuff' belonging to a user
  public ArrayList<Stuff> getListForUser(int limit, String user){
    String query = " ";
    if (limit > 1){
      query ="SELECT * FROM Stuff WHERE user=\'"+user+"\' ORDER BY"+
             " timePosted DESC LIMIT "+limit+";";
    } else {
      query ="SELECT * FROM Stuff WHERE user=\'"+user+"\' ORDER BY"+
             " timePosted DESC;";
    }
    Query q = em.createNativeQuery(query, Stuff.class);
    return (ArrayList)q.getResultList();
  }
  
  
  /* returns an arraylist of Activity objects for the item whose id is 
  passed in. 'byWhat' can be a university or a user */
  public ArrayList<Activity> getActivities(){
    ArrayList<Activity> results = new ArrayList<Activity>();
    String query ="SELECT * FROM Activity ORDER BY id DESC LIMIT 8;";
    Query q = em.createNativeQuery(query, Activity.class);
    results = (ArrayList) q.getResultList();
    return results;
  }

  public ArrayList<Activity> getActivitiesByUniversity(String uni, int limit){
    ArrayList<Activity> results = new ArrayList<Activity>();
    ArrayList<Stuff> stuffObjects = new ArrayList<Stuff>();
    String query ="SELECT * FROM Stuff WHERE university=\'"+uni+"\' ORDER BY"+
             " timePosted DESC;";
    Query q = em.createNativeQuery(query, Stuff.class); 
    stuffObjects = (ArrayList)q.getResultList();
    //loop thru 'stuffObjects' and add each corresponding Activty obj to 'results'
    for (Stuff s : stuffObjects) {
      int itemId = s.getId();
      query ="SELECT * FROM Activity WHERE itemId=? ORDER BY id DESC;";
      Query qw = em.createNativeQuery(query, Activity.class);
      qw.setParameter(1, itemId);
      ArrayList<Activity> temp = (ArrayList) qw.getResultList();
      results.add(temp.get(0));
    }
    return results;
  }

  public ArrayList<Activity> getActivitiesByUser(String user, int limit){
    ArrayList<Activity> results = new ArrayList<Activity>();
    ArrayList<Stuff> stuffObjects = new ArrayList<Stuff>();
    String query ="SELECT * FROM Stuff WHERE user=\'"+user+"\' ORDER BY"+
             " timePosted DESC;";
    Query q = em.createNativeQuery(query, Stuff.class); 
    stuffObjects = (ArrayList)q.getResultList();
    //loop thru 'stuffObjects' and add each corresponding Activty obj to 'results'
    if (!stuffObjects.isEmpty()){
      for (Stuff s : stuffObjects) {
        int itemId = 1;
        query ="SELECT * FROM Activity WHERE itemId=1;";
        Query qw = em.createNativeQuery(query, Activity.class);
        //qw.setParameter(1, itemId);
        ArrayList<Activity> temp = (ArrayList) qw.getResultList();
        Activity one = temp.get(0);
        results.add(one);
      }
    }
    return results;
  }
}