package com.unihub.app;

import javax.ejb.*;

@Remote
public interface HelloServiceInterface{

	public String create(MyEntity e);


}