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
import javax.persistence.*;
import javax.transaction.*;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.*;
import javax.persistence.*;

@Stateful (name="UserStatefulBI")
@Remote(UserStatefulBI.class)
public class UserStatefulBean implements UserStatefulBI {

  @PersistenceContext
  EntityManager em;
  @EJB
  Authenticate bean;
  private Dbase ubase = Dbase.create();

  public User getUser(String name) {
    String quer = "select * from users where name = \"" + name + "\"";
    Query q = em.createNativeQuery(quer, User.class);
    List<User> userslist = q.getResultList();
    if(userslist.size() == 0) return new User();
    else return userslist.get(0);
  }
 
  public int getId(String name) {
    return getUser(name).getId();
  }

  public String getName(int uId) {
    User u = em.find(User.class, uId);
    return u.getName();
    //return ubase.getUser(uId).getName();
  }

  public String getEmail(int uId) {
    User u = em.find(User.class, uId);
    return u.getEmail();
  }

  public String getSchool(int uId) {
    User u = em.find(User.class, uId);
    return u.getSchool();
  }

  public byte[] getEncryptedPassword(int uId) {
    User u = em.find(User.class, uId);
    return u.getEncryptedPassword();
  }

  public String getGravatar(String name) throws NoSuchAlgorithmException {
    return getUser(name).gravatar();
  }

  public List<Message> getSentMessages(String name) {
    String quer = "select * from Message where fromName = \"" + name + "\"";
    Query q = em.createNativeQuery(quer, Message.class);
    return q.getResultList();
  }

  public List<Message> getReceivedMessages(String name) {
    String quer = "select * from Message where toName = \"" + name + "\"";
    Query q = em.createNativeQuery(quer, Message.class);
    return q.getResultList();
  }

  /**
   * Increment the reputation of the user of the given name
   */
  public void incRep(String name) {
    getUser(name).incRep();
  }

  public int getRep(String name) {
    return getUser(name).getReputation();
  }

  /**
   * Add an item id to a user's "voted" list
   *
   * name - the name of the user to use
   * id - the id of the item being added to the user's voted list
   */
  public void addToVoted(String name, int id) {
    getUser(name).addToVoted(id);
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

  public ArrayList<String> getWatched(String name) {
    return ubase.getUser(name).getWatched();
  }

  // DATABASE CODE 
  // DOES THIS GO IN A SEPARATE BEAN? MAYBE.

  public int getNumUsers() {
    return getAllUsers().size();
  }

  public List<User> getAllUsers() {
    String quer = "select * from users";
    Query q = em.createNativeQuery(quer, User.class);
    return q.getResultList();
  }
  
}
