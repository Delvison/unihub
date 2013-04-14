/**
 * @author Mark
 *
 * User stateful CRUD operations
 */

package com.unihub.app;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.ejb.*;
import javax.annotation.*;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;

@Stateful (name="UserStatefulBI")
@Remote(UserStatefulBI.class)
public class UserStatefulBean implements UserStatefulBI {
  @EJB
  Authenticate bean;

  private Dbase ubase = Dbase.create();

  public void createUser(String name, String pass, String email, String school) {
    byte[] sal = null;
    byte[] encryptedpass = null;
    try {
      sal = bean.generateSalt();
      encryptedpass = bean.getEncryptedPassword(pass, sal);
    }
    catch(NoSuchAlgorithmException e) {}
    catch(InvalidKeySpecException e) {}
    ubase.addUser(new User(name, encryptedpass, email, school, sal));
  }

  public User getUser(String name) {
    return ubase.getUser(name);
  }
 
  public int getId(String name) {
    return ubase.getUser(name).getId();
  }

  public String getName(int uId) {
    return ubase.getUser(uId).getName();
  }

  public String getEmail(int uId) {
    return ubase.getUser(uId).getEmail();
  }

  public String getSchool(int uId) {
    return ubase.getUser(uId).getSchool();
  }

  public byte[] getEncryptedPassword(int uId) {
    return ubase.getUser(uId).getEncryptedPassword();
  }

  public ArrayList<Message> getSentMessages(String name) {
    return ubase.getUser(name).getSentMessages();
  }

  public ArrayList<Message> getReceivedMessages(String name) {
    return ubase.getUser(name).getReceivedMessages();
  }

  /**
   * Increment the reputation of the user of the given name
   */
  public void incRep(String name) {
    ubase.getUser(name).incRep();
  }

  /**
   * Add an item id to a user's "voted" list
   *
   * name - the name of the user to use
   * id - the id of the item being added to the user's voted list
   */
  public void addToVoted(String name, int id) {
    ubase.getUser(name).addToVoted(id);
  }

  /**
   * Update a user who has id uId with new information
   */
  public void updateUser(int uId, String name, String email, String pass, String school) {
    byte[] sal = null;
    byte[] epass = null;
    try {
      sal = bean.generateSalt();
      epass = bean.getEncryptedPassword(pass, sal);
    }
    catch(NoSuchAlgorithmException e) {}
    catch(InvalidKeySpecException e) {}

    ubase.getUser(uId).update(name, email, epass, school);
  }

  public boolean isWatching(String watcher, String watchee) {
    return ubase.getUser(watcher).isWatching(watchee);
  }

  public void watch(String watcher, String watchee) {
    ubase.getUser(watcher).watch(watchee);
  }
  
  public void unwatch(String watcher, String watchee) {
    ubase.getUser(watcher).unwatch(watchee);
  }

  // DATABASE CODE 
  // DOES THIS GO IN A SEPARATE BEAN? MAYBE.

  public int getNumUsers() {
    return ubase.getUsersList().size();
  }

  public ArrayList<User> getAllUsers() {
    return ubase.getUsersList();
  }
  
}
