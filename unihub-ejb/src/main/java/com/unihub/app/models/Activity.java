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
  public Activity(int itemId, String user, String action){
    this.itemId = itemId;
    this.user = user;
    this.actualActivity = action;
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