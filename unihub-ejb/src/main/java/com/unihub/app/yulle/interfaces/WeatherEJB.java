package com.unihub.app;

import javax.ejb.*;
import java.util.ArrayList;
import javax.naming.*;
import javax.naming.directory.*;

@Stateless
@Remote
public interface WeatherEJB {
	
	public ArrayList<String> weatherLookup(String q) throws RuntimeException;

}
