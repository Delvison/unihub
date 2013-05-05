package com.unihub.app;

import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import javax.naming.directory.*;
import java.security.*;

@Remote
public interface UserStatelessBI {
 
  public User createUser(String name, String pass, String email, String school);
  public User getUser(String name);
  public int getId(String name);
  public String getName(int uId);
  public String getEmail(int uId);
  public String getSchool(int uId);
  
}
