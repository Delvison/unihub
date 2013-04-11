package com.unihub.app;

import javax.ejb.*;
import javax.jws.WebService;
import javax.jws.WebMethod;

@Remote
@Stateless
@WebService
public class NakedEventsBean implements NakedEvents {

	EventListHolder holder = EventListHolder.getInstance();

	@WebMethod
	public String getTitle(int i) {
		Event event = holder.findEventWithId(i);
		return event.getTitle();
	}

	@WebMethod
	public String getLocation(int i) {
		Event event = holder.findEventWithId(i);
		return event.getLoc();
	}

	@WebMethod
	public String getDescription(int i) {
		Event event = holder.findEventWithId(i);
		return event.getDes();
	}

	@WebMethod
	public String getDateAndTime(int i) {
		Event event = holder.findEventWithId(i);
		String dateAndTime = event.getThingy();
		return dateAndTime + " " + event.getTime();
	}

}//end of class