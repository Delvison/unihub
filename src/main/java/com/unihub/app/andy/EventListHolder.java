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
	private int idCounter = 0; //this counter will be used to figure out how many total events there are and hence figure out the correct auto_increment thing

	private EventListHolder() {
		/*Private constructor to keep direct instantiation*/
		list = new ArrayList<Event>();
		list.add( new Event(autoIncrement(), "Unihub Release Party", 
				new String[]{"4","12","2013"}, "3:00pm", "Pimp Pad", 
				"Come join as we celebrate our beta release!"));

		list.add(new Event(autoIncrement(), "Resume Builder", 
				new String[]{"4","20","2013"}, "9:00am", "OLS", 
				"Come so we can help you build your resume!"));

		list.add(new Event(autoIncrement(), "Pizza Party", 
					new String[]{"05","01","2013"}, "12:00pm", "Lounge", 
					"After a long morning in classes stop by to get a bite to eat!"));
	}

	public static EventListHolder getInstance() {

		if(instance == null) {
			instance = new EventListHolder();
		}


		return instance;
	}

	public void addEvent(String title, String[] date, 
							String time, String location, String description) {

		Event event = new Event(autoIncrement(), title, date, time, location, description);
		list.add(0, event);
	}

	public Event getEvent(int pos) {
		return list.get(pos);
	}

	public int numOfEvents() {
		return list.size();
	}


	public int autoIncrement() {
		/*
		Sole purpose of this method is to increment the id and return its value
		*/
		idCounter+=1;

		return idCounter;
	}

	public Event findEventWithId(int id) {
		/*
		Does the actual work to find a specific Event
		with the specific id in the parameter*/
		for(Event event : list) {
			if(event.getId() == id)
				return event;
		}

		return null;

	}//end of findEventWithId()





}//end of class