/*
My class that holds Event info for the index and View all
events
*/
package com.unihub.app;

public class Event {

	String title;
	String time;
	String location;
	String description;

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