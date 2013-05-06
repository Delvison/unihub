package com.unihub.app;

import javax.ejb.*;
import javax.naming.*;
import javax.naming.directory.*;
import javax.persistence.*;

@Remote
public interface MessageBI {
  public void createMessage(User u, String f, String t, String c);
  public String getContents();
  public String getToName();
  public String getFromName();
  public String toString();
}
