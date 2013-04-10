package com.unihub.app;

import javax.ejb.*;
import javax.naming.*;
import javax.naming.directory.*;

@Remote
public interface MessageBI {
  public void createMessage(String f, String t, String c);
  public String getContents();
  public String getToName();
  public String getFromName();
  public void addToReceived(String tname);
  public void addToSent(String fname);
  public String toString();
}
