package com.unihub.app;

import javax.ejb.*;
import java.util.ArrayList;
//import javax.jws.*; for @WebService
import javax.persistence.PersistenceContext;
import javax.persistence.EntityManager;
import javax.persistence.Query;

@Remote
@Stateless
public class EventsBean implements Events {
	@PersistenceContext
	EntityManager em;
	@EJB
	UserStatefulBI userBean;

	public void addEvent(String title, String[] date, String time, 
		String location, String description) {

		//EventListHolder holder = EventListHolder.getInstance();

		//holder.addEvent(title, date, time, location, description);

		/*
		Just creating this to test addition of my events entity to database*/
		Event event = new Event(0, title, date, time, location, description);
		em.persist(event);

	}//end of addEvent


	public ArrayList<Event> getEvents() {
		//EventListHolder holder = EventListHolder.getInstance();
		String query = "SELECT * FROM events";
		Query q = em.createNativeQuery(query, Event.class);


		return (ArrayList<Event>)q.getResultList();

	}//end of getEvents

	public boolean attemptAttending(int eventId, String userName){
		//this will return true if attempt succeeded and I know user has not followed
		//false if user has followed already
		/*
		I honestly cannot do much without Marks stuff yet
		*/
		return false;

	}//end of attemptAttend()




}//end of EventsBean