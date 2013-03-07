// Mock users database for app prototype
// Currently houses an arraylist of users and a static instance of itself.
package com.unihub.app;

import java.util.ArrayList;

public class Dbase {

  public ArrayList<User> userslist;

  /**
   * Empty constructor initializes a new arraylist
   */
  private Dbase() {
    userslist = new ArrayList<User>();
  }
  
  private static Dbase users;

  /**
   * Add a user to the array list and return the index
   * it was added at (for id purposes)
   */
  public void addUser(User user) {
    userslist.add(user);
    user.setId(userslist.indexOf(user));
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

  public String toString() {
    return userslist.toString();
  }

}
