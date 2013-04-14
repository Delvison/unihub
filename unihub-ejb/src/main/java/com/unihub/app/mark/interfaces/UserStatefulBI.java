package com.unihub.app;

import java.util.ArrayList;
import javax.ejb.*;
import javax.naming.*;
import javax.naming.directory.*;

@Remote
public interface UserStatefulBI {
  public void createUser(String name, String pass, String email, String school);
  public User getUser(String name);
  public String getName(int uId);
  public int getId(String name);
  public String getEmail(int uId);
  public String getSchool(int uId);
  public byte[] getEncryptedPassword(int uId);
  public void incRep(String name);
  public void addToVoted(String name, int id); 
  public void updateUser(int uId, String name, String email, String pass, String school);
  public boolean isWatching(String watcher, String watchee);
  public void watch(String watcher, String watchee);
  public void unwatch(String watcher, String watchee);

  public int getNumUsers();
  public ArrayList<User> getAllUsers();
}
