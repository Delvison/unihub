/* Activity model
   @Author Delvison */

package com.unihub.app;

import java.util.*;
import java.io.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
public class Activity implements Serializable{
  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  @NotNull private String user; //user who committed the action
  @NotNull private int itemId; //id of item activity belongs to
  @NotNull private String actualActivity; //the actual activity
  
  @Transient 
  @PersistenceContext EntityManager em;

  public Activity(){}

  /* action can be 'comment' , 'bid' , 'comment' */
  public Activity(int itemId, String user, int action){
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
    this.itemId = itemId;
    this.user = user;
    String query ="SELECT * FROM Stuff WHERE id=?;";
    Query q = em.createNativeQuery(query, Stuff.class);
    q.setParameter(1, itemId);
    ArrayList<Stuff> b = (ArrayList<Stuff>)q.getResultList();
    Stuff a = b.get(0);
    this.actualActivity = finalAction + a.getName();
  }

  public String getUser(){
  	return this.user;
  }

  public int getItemId(){
  	return this.itemId;
  }

  public String getActualActivity(){
  	return this.actualActivity;
  }
}