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
public class UserStatelessBean implements UserStatelessBI {

  Dbase ubase = Dbase.create();
  @PersistenceContext
  EntityManager em;
  @EJB
  Authenticate bean;

  public void createUser(String name, String pass, String email, String school) {
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
  }

}
