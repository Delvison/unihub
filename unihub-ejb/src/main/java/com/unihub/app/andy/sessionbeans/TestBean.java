package com.unihub.app;

/*
Just a test bean in order to get a feel for it
*/
import javax.ejb.*;

@Remote
@Stateless
public class TestBean implements TestInterface{

	public String getResponse(String name) {
		return "You have successfully called yo bean "+name;
	}//end of getResponse

}//end of class