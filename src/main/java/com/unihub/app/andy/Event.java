/*
My class that holds Event info for the index and View all
events
*/
package com.unihub.app;
import java.util.ArrayList;
import java.util.Calendar;

public class Event {

	String title;
	String time;
	String location;
	String description;
	Calendar cal = Calendar.getInstance();
	/*the followers array just holds the ID of user following
	I need to work with Mark to get it correctly show users
	since I am not sure how he does this*/
	ArrayList<Integer> followers = new ArrayList<Integer>();

	public Event(String title, String time, String location, String description) {
		this.title = title;
		this.time = time;
		this.location = location;
		this.description = description;
	}//end of constructor

	public String getTitle(){

		return title;
	}//end of getTitle()

	public String getTime(){

		return time;
	}//end of getTime()

	public String getLoc(){

		return location;
	}//end of getLoc()

	public String getDes(){

		return description;
	}//end of getDes()

}//end of class