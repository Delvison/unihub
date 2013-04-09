package com.unihub.app;

/*My Test interface for my test bean*/
import javax.ejb.*;

@Remote
public interface TestInterface {
	public String getResponse(String name);
}