package com.unihub.app;

import javax.ejb.Local;

@Local
public interface Hello{
  public String sayHello(String name);
}
