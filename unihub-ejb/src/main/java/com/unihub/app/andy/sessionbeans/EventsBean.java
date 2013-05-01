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

	public Event getEvent(int eventId) {

		String query = "SELECT * FROM events WHERE id = ?";
		Query q = em.createNativeQuery(query, Event.class);
		q.setParameter(1, eventId);

		return (Event)q.getSingleResult();
	}//end of getEvent(String)

	public boolean attemptAttending(Event event, String userName){
		//this will return true if attempt succeeded and I know user has not followed
		//false if user has followed already
		User u = null;
		

			try {
				String query = "SELECT * FROM users WHERE name = ?";
				Query q = em.createNativeQuery(query, User.class);
				q.setParameter(1, userName);
				u = (User)q.getSingleResult();
			}
			catch(Exception ex) {
				return false;
			}

			event.getFollowers().add(u);
			em.merge(event);

		return true;

	}//end of attemptAttend()




}//end of EventsBean