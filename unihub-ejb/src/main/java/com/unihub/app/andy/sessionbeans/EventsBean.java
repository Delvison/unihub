package com.unihub.app;

import javax.ejb.*;
import java.util.ArrayList;
//import javax.jws.*; for @WebService

@Remote
@Stateless
public class EventsBean implements Events {

	public void addEvent(String title, String[] date, String time, 
		String location, String description) {

		EventListHolder holder = EventListHolder.getInstance();

		holder.addEvent(title, date, time, location, description);


	}//end of addEvent


	public ArrayList<Event> getEvents() {
		EventListHolder holder = EventListHolder.getInstance();

		return holder.getEventList();

	}//end of getEvents

}//end of EventsBean