// Mock users database for app prototype
// Currently houses an arraylist of users and a static instance of itself.
package com.unihub.app;

import java.util.ArrayList;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Dbase implements Serializable {

  private ArrayList<User> userslist;
  private static Dbase users;
  private int idCounter = 0;

  /**
   * Empty constructor initializes a new arraylist
   */
  private Dbase() {
    userslist = new ArrayList<User>();
    populate();
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

  // find user object by username
  public com.unihub.app.User getUser(String name) {
    for (int i = 0; i < userslist.size(); i++) {
      if(userslist.get(i).getName().equals(name)) {
        return userslist.get(i);
      }
    }
    return null;
  }

  /**
   * populates the arraylist with some dummy data
   */
  public void populate() {
    byte[] salt = null;
    byte[] encryptedPassword = null;
    try {
      salt = AuthUtilities.generateSalt();
      encryptedPassword = AuthUtilities.getEncryptedPassword("pass", salt);
    }
    catch(NoSuchAlgorithmException e) {}
    catch(InvalidKeySpecException e) {}

    addUser( new User("Mark",
                      encryptedPassword,
                      "mwillson@oswego.edu",
                      "Oswego",
                      salt) );
    addUser( new User("Yulle",
                      encryptedPassword,
                      "byullegl@oswego.edu",
                      "Oswego",
                      salt) );
    addUser( new User("Delvison",
                      encryptedPassword,
                      "castillo@oswego.edu",
                      "Oswego",
                      salt) );
    addUser( new User("Andy",
                      encryptedPassword,
                      "avaldez@oswego.edu",
                      "Oswego",
                      salt) );
    for(int i = 0; i < 4; i++) {
    addUser( new User("User"+i,
                      encryptedPassword,
                      "user@example.edu",
                      "Example University",
                      salt) );
    }
  }

  public String toString() {
    return userslist.toString();
  }

}
