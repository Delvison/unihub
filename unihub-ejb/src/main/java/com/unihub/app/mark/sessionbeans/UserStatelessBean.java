package com.unihub.app;

import javax.ejb.*;
import javax.annotation.*;
import java.util.*;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.persistence.*;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

@Stateless
@Remote(UserStatelessBI.class)
@WebService
public class UserStatelessBean implements UserStatelessBI {

  Dbase ubase = Dbase.create();
  @PersistenceContext
  EntityManager em;
  @EJB
  Authenticate bean;

  @WebMethod
  public User createUser(String name, String pass, String email, String school) {
    byte[] sal = null;
    byte[] encryptedpass = null;
    try {
      sal = bean.generateSalt();
      encryptedpass = bean.getEncryptedPassword(pass, sal);
    }
    catch(NoSuchAlgorithmException e) {}
    catch(InvalidKeySpecException e) {}
    User u = new User(name, encryptedpass, email, school, sal);
    em.persist(u);
    ubase.addUser(u);
    return u;
  }

  public User getUser(String name) {
    String quer = "select * from users where name = \"" + name + "\"";
    Query q = em.createNativeQuery(quer, User.class);
    List<User> userslist = q.getResultList();
    if(userslist.size() == 0) return new User();
    else return userslist.get(0);
  }

  @WebMethod
  public int getId(String name) {
    return getUser(name).getId();
  }

  @WebMethod
  public String getName(int uId) {
    User u = em.find(User.class, uId);
    return u.getName();
  }

  @WebMethod
  public String getEmail(int uId) {
    User u = em.find(User.class, uId);
    return u.getEmail();
  }

  @WebMethod
  public String getSchool(int uId) {
    User u = em.find(User.class, uId);
    return u.getSchool();
  }

}
