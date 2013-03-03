// Mock database for app prototype
// Currently only houses a array list of users.
package com.unihub.app;

import java.util.ArrayList;

public class Dbase {

  private ArrayList<User> users;

  /**
   * Empty constructor initializes a new arraylist
   */
  public Dbase() {
    users = new ArrayList<User>();
  }

  /**
   * Add a user to the array list and return the index
   * it was added at (for id purposes)
   */
  public void addUser(User user) {
    users.add(user);
    user.setId(users.indexOf(user));
  }

  /**
   * Returns user at a specific index in the arraylist
   */
  public User getUser(int index) {
    return users.get(index);
  }  

  public String toString() {
    return users.toString();
  }

}
