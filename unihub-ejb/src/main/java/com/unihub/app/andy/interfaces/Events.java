package com.unihub.app;

import javax.ejb.*;
import java.util.ArrayList;

@Remote
public interface Events {



	public void addEvent(String title, String[] date, String time, 
		String location, String description);

	public ArrayList<Event> getEvents();

	public Event getEvent(int eventId);

	public boolean attemptAttending(Event event, String userName);

	

}