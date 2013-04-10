package com.unihub.app;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@WebService
public class HelloServiceBean {

  @WebMethod
  public String sayHellow(String n){
    return n;
  }
}
