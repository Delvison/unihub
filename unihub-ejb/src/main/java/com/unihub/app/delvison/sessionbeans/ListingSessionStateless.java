//@author Delvison
//This sessionbean allows CRUD operations for individual listings.

package com.unihub.app;

import javax.ejb.Remote;
import javax.ejb.*;
import javax.annotation.Resource;
import java.util.Date;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.persistence.*;

@Stateless
@Remote
@WebService
public class ListingSessionStateless implements ListingObjEJBStateless {

  @PersistenceContext
  EntityManager em;

  @WebMethod
  public void ListingObjEJBStateless(){}
  
 @WebMethod
 public int addStuff(String user, String name, String price, String university,
  String location, String category, String description, String bid) {
    int i = 0;
    Date now = new Date();
    Stuff as = new Stuff(user, name, price, university, location,
     category, description, now, bid);
    em.persist(as);
    i = as.getId();
    return i;
  }
      
  private Stuff getStuff(int passedId) {
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, passedId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0);
  }

  public void removeItem(int id){
    ListingsObj lis = ListingsObj.create();
    Stuff a = getStuff(id);
    for (int i=0; i<lis.stuffs.size(); i++){
      if (lis.stuffs.get(i).getId() == id){
        lis.stuffs.remove(i);
      }
    }
  }
  
  @WebMethod       
   public void updateContent(int id, String name, String price, String university, 
                String location, String category, String description, String bid){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, id);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    Stuff s = p.get(0);
    s.updateContent(name,price,university,location,category,description,bid);
    em.merge(s);
  }
    @WebMethod    
  public int getPicAmount(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    int i = p.get(0).getPicAmount();
    return i;
  }
   @WebMethod     
  public String getName(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getName();
  }
  @WebMethod      
  public String getPrice(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getPrice();
  }
    @WebMethod     
  public String getUser(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getUser();
  }
    @WebMethod    
  public String getUniversity(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getUniversity();
  }
  
  public String getLocation(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getLocation();
  }
  @WebMethod      
  public int getId(int itemId){
    ListingsObj lis = ListingsObj.create();
    Stuff a = lis.getStuff(itemId);
    return a.getId();
  }
  @WebMethod     
  public String getDescription(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getDescription();
  }
   @WebMethod     
  public String getBidMode(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getBidMode();
  }
  @WebMethod      
  public String getHighBidder(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getHighBidder();
  }
  @WebMethod      
  public String getCategory(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getCategory();
  }
  @WebMethod      
  public String getTimePosted(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");
    String datePosted = formatter.format(p.get(0).getTimePosted());
    return datePosted;
  }
  @WebMethod      
  public String getDir(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    return p.get(0).getDir();
  }
  @WebMethod      
  public void setDir(int itemId, String dir){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    p.get(0).setDir(dir);
  }
  
  @WebMethod
  public void setPicAmount(int itemId){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    p.get(0).setPicAmount();
    }

  @WebMethod
  public void setThumbnail(int itemId, String t){
    String query = "SELECT * FROM Stuff WHERE id=?;" ;
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    p.get(0).setThumbnail(t);
  }
}
