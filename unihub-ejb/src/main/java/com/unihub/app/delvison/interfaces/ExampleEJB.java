package com.unihub.app;

import javax.ejb.Remote;
import javax.naming.*;
import javax.naming.directory.*;
import javax.jws.WebService;

@Remote
public interface ExampleEJB {
  public void addExample(String name);
}
