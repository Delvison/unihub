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

@Stateful (name="UserStatefulBI")
@Remote(UserStatefulBI.class)
public class UserStatefulBean implements UserStatefulBI {

  private Dbase ubase = Dbase.create();

  public void createUser(String name, String pass, String email, String school) {
    byte[] sal = null;
    byte[] encryptedpass = null;
    try {
      sal = AuthUtilities.generateSalt();
      encryptedpass = AuthUtilities.getEncryptedPassword(pass, sal);
    }
    catch(NoSuchAlgorithmException e) {}
    catch(InvalidKeySpecException e) {}
    ubase.addUser(new User(name, encryptedpass, email, school, sal));
  }

  public User getUser(String name) {
    return ubase.getUser(name);
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

  public void updateUser(int uId, String name, String email, String pass, String school) {
    byte[] sal = null;
    byte[] epass = null;
    try {
      sal = AuthUtilities.generateSalt();
      epass = AuthUtilities.getEncryptedPassword(pass, sal);
    }
    catch(NoSuchAlgorithmException e) {}
    catch(InvalidKeySpecException e) {}

    ubase.getUser(uId).update(name, email, epass, school);
  }

}
