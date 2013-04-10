package com.unihub.app;

import javax.ejb.*;
import javax.naming.*;
import javax.naming.directory.*;

@Remote
public interface UserStatefulBI {
  public void createUser(String name, String pass, String email, String school);
  public User getUser(String name);
  public String getName(int uId);
  public String getEmail(int uId);
  public String getSchool(int uId);
  public byte[] getEncryptedPassword(int uId);
  public void updateUser(int uId, String name, String email, String pass, String school);
}
