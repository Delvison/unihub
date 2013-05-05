// Mock users database for app prototype
// Currently houses an arraylist of users and a static instance of itself.
package com.unihub.app;

import java.util.*;
import java.io.*;
import javax.annotation.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.persistence.*;
import javax.naming.*;
import javax.ejb.*;

public class Dbase implements Serializable {

  private ArrayList<User> userslist;
  private static Dbase users;
  private int idCounter = 0;

  /**
   * Empty constructor initializes a new arraylist
   */
  private Dbase() {
    userslist = new ArrayList<User>();
  } 

  public ArrayList<User> getUsersList() {
    return userslist;
  }

  /**
   * Add a user to the array list and return the index
   * it was added at (for id purposes)
   */
  public void addUser(User user) {
    userslist.add(user);
  }

  private static Dbase getInstance() {
    return users;
  }

  public static Dbase create() {
    if(users == null) users = new Dbase();
    return users;
  }

  /**
   * Returns user at a specific index in the arraylist
   */
  public User getUser(int index) {
    return userslist.get(index);
  }  

  // find user object by username
  public com.unihub.app.User getUser(String name) {
    for (int i = 0; i < userslist.size(); i++) {
      if(userslist.get(i).getName().equals(name)) {
        return userslist.get(i);
      }
    }
    return null;
  }

  /*
    populates the arraylist with some dummy data
   
  public void populate() {
    String pass = "pass";

    usr.createUser("Mark",
                  "pass",
                  "mwillson@oswego.edu",
                  "Oswego");
    usr.createUser("Yulle",
                  "pass",
                  "byullegl@oswego.edu",
                  "Oswego");
    usr.createUser("Delvison",
                  "pass",
                  "castillo@oswego.edu",
                  "Oswego");
    usr.createUser("Andy",
                  "pass",
                  "avaldez@oswego.edu",
                  "Oswego");
    for(int i = 0; i < 4; i++) {
    usr.createUser("User"+i,
                  "pass",
                  "user@example.edu",
                  "Example University");
    }
  }*/

  public String toString() {
    return userslist.toString();
  }

}
