package com.unihub.app;

import javax.ejb.*;
import java.util.ArrayList;

@Remote
@Stateless
public class EventsBean implements Events {

	public void addEvent(int id, String title, String[] date, String time, 
		String location, String description) {


	}//end of addEvent

	public ArrayList<Event> getEvents() {
		EventListHolder holder = EventListHolder.getInstance();

		return holder.getEventList();

	}//end of getEvents

}//end of EventsBean