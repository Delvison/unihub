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

  public List<Stuff> searchListing(String keywords){
    String query = "SELECT * FROM Stuff WHERE name LIKE \'%"+keywords+"%\';";
    Query q = em.createNativeQuery(query, Stuff.class);
    return q.getResultList();
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
}