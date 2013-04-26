package com.unihub.app;

import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;

@Stateless
public class HelloServiceBean implements HelloServiceInterface{
	@PersistenceContext
	EntityManager em;

  public String create(MyEntity e){
  	em.persist(e);

    return null;
  }


}
