// Mock users database for app prototype
// Currently houses an arraylist of users and a static instance of itself.
package com.unihub.app;

import java.util.ArrayList;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class Dbase {

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
  public User getUser(String name) {
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

    for(int i = 0; i < 10; i++) {
      addUser( new User("User"+i,
                         encryptedPassword,
                         "mwillson@oswego.edu",
                         "Oswego",
                         salt) );
    }
  }

  public String toString() {
    return userslist.toString();
  }

}
