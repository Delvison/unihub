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

  public ArrayList<Stuff> userSearch(String userSearched){
    ListingsObj lis = ListingsObj.create();
    ArrayList<Stuff> listingsByTheUser = new ArrayList<Stuff>();
    for (Stuff s: lis.stuffs){
      if(s.getUser().equals(userSearched)){
        listingsByTheUser.add(s);
      }
    }
    return listingsByTheUser; 
  }
  
  public ArrayList<Stuff> getArrayList(){
    ListingsObj lis = ListingsObj.create();
    return (ArrayList) this.getList();
  }

  public int getArrayListSize(){
    int i = 0;
    String query ="SELECT * FROM Stuff ORDER BY id DESC LIMIT 1;";
    Query q = em.createNativeQuery(query, Stuff.class);
    ArrayList<Stuff> p = (ArrayList)q.getResultList();
    Stuff a = p.get(0);
    if (q != null){ i = a.getId(); }
    return i;
  }

  public List getList(){
   String query = "SELECT * FROM Stuff;";
   Query q = em.createNativeQuery(query, Stuff.class);
   return q.getResultList(); 
  }
}