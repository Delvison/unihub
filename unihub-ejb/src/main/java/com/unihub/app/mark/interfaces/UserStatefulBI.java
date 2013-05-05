package com.unihub.app;

import java.util.*;
import javax.ejb.*;
import javax.naming.*;
import javax.naming.directory.*;
import java.security.*;

@Remote
public interface UserStatefulBI {
  public User getUser(String name);
  public String getName(int uId);
  public int getId(String name);
  public String getEmail(int uId);
  public String getSchool(int uId);
  public byte[] getEncryptedPassword(int uId);
  public String getGravatar(String name) throws NoSuchAlgorithmException;
  public List<Message> getSentMessages(String name);
  public List<Message> getReceivedMessages(String name);
  public int getRep(String name);
  public void incRep(String name);
  public void addToVoted(String name, int id); 
  public void updateUser(int uId, String name, String email, String pass, String school);
  public boolean isWatching(String watcher, String watchee);
  public void watch(String watcher, String watchee);
  public void unwatch(String watcher, String watchee);
  public ArrayList<String> getWatched(String name);

  public int getNumUsers();
  public List<User> getAllUsers();
}
