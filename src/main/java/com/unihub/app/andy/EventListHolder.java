/*
Temporary Singleton class thats purpose is to
just hold a list of events to show in the homepage
and access when trying to view events on some events page
*/
package com.unihub.app;

import java.util.ArrayList;


public class EventListHolder {

	private static EventListHolder instance = null;
	private ArrayList<Event> list = null;

	private EventListHolder() {
		/*Private constructor to keep direct instantiation*/
		list = new ArrayList<Event>();
		list.add( new Event("Unihub Release Party", "8:00PM", "Pimp Pad", 
								"Come join as we celebrate our beta release!"));
		list.add(new Event("Resume Builder", "9:00AM", "OLS", 
								"Come so we can help you build your resume!"));
		list.add(new Event("Pizza Party", "12:00PM", "Lounge", 
								"After a long morning in classes stop by to get a bite to eat!"));
	}

	public static EventListHolder getInstance() {

		if(instance == null) {
			instance = new EventListHolder();
		}


		return instance;
	}

	public void addEvent(Event event) {
		list.add(event);
	}

	public Event getEvent(int pos) {
		return list.get(pos);
	}

	public int numOfEvents() {
		return list.size();
	}

}//end of class