package com.unihub.app;

import javax.ejb.*;
import java.util.ArrayList;

@Remote
public interface Events {



	public void addEvent(int id, String title, String[] date, String time, 
		String location, String description);

	public ArrayList<Event> getEvents();

	

}