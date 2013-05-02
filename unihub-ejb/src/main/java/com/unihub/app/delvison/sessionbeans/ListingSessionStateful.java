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
  /*
  public ArrayList<Activity> printActivities(String byWhat, int itemId){
    ArrayList<Activity> results = new ArrayList<Activity>();
    ArrayList<Stuff> stuffObjects = new ArrayList<Stuff>();
    String query = " ";
    if (byWhat.equals("university")){
      query ="SELECT * FROM Stuff WHERE university=\'"+byWhat+"\' ORDER BY"+
             " timePosted DESC LIMIT "+limit+";";
      Query q = em.createNativeQuery(query, Stuff.class); 
      stuffObjects = (ArrayList)q.getResultList();
    
    //else, get all Activity objects that belong to a user
    } else {
      query ="SELECT * FROM Stuff WHERE user=\'"+byWhat+"\' ORDER BY"+
             " timePosted DESC LIMIT "+limit+";";
      Query q = em.createNativeQuery(query, Stuff.class); 
      //get all stuff belonging to the university
      stuffObjects = (ArrayList)q.getResultList();
    }
    //loop thru 'stuffObjects' and add each corresponding Activty obj to 'results'
    for (Stuff s : p) {
      query ="SELECT * FROM Activity WHERE itemId=\'"+itemId+"\' ORDER BY"+
             " timePosted DESC LIMIT "+limit+";";
      q = em.createNativeQuery(query, Activity.class);
      ArrayList<Activity> temp = q.getResultList();
      results.add(temp(0));
    }
    return results;
  }
  */
}