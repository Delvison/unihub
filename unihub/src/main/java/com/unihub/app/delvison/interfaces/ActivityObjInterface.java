package com.unihub.app;

import javax.ejb.Remote;
import javax.naming.*;
import javax.naming.directory.*;

@Remote
public interface ActivityObjInterface {
  public String[] getActivityArray();
}
