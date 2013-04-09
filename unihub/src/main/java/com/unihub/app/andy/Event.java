/*
My class that holds Event info for the index and View all
events
*/
package com.unihub.app;
import java.util.ArrayList;
import java.util.Calendar;

public class Event {

	int id;
	String title;
	String location;
	String description;
	Calendar cal = Calendar.getInstance();


	/*the followers array just holds the ID of user following
	I need to work with Mark to get it correctly show users
	since I am not sure how he does this*/
	ArrayList<Integer> followers = new ArrayList<Integer>();

	public Event(int id, String title, String[] date, String time, 
		String location, String description) {
		this.id = id;
		this.title = title;
		this.location = location;
		this.description = description;

		String[] splitTime = time.split(":");
		boolean isAm = splitTime[1].contains("a");

		if(isAm == false)//only run this if "am" wasn't found so try "AM" and if its false I know its PM
			isAm = splitTime[1].contains("A");

		splitTime[1] = splitTime[1].substring(0,2); //this gets rid of the AM or PM

		int hour = 0;
		if(isAm) {
			hour = splitTime[0].equals("12") ? 0 : Integer.parseInt(splitTime[0]);
		} else {
			//else is PM
			hour = splitTime[0].equals("12") ? Integer.parseInt(splitTime[0]):
											 Integer.parseInt(splitTime[0])+12;
		}
							
		
		cal.set(Integer.parseInt(date[2]), Integer.parseInt(date[0])-1, 
					Integer.parseInt(date[1]), 
					hour, 
					Integer.parseInt(splitTime[1]));

	}//end of constructor

	public int getId() {
		return id;
	}

	public String getTitle(){

		return title;
	}//end of getTitle()

	public String getThingy() {
		return String.format("%tA, %<tB %<td", cal);
	}

	public String getDate() {

		return null;
	}


	public String getTime(){

		return String.format("%tI:%<tM %<tp", cal);
		//return pad(cal.get(Calendar.HOUR)) + ":" + pad(cal.get(Calendar.MINUTE))+
		//								(cal.get(Calendar.AM_PM) == 0 ? "am" : "pm");
	}//end of getTime()

	public String pad(int num) {
		//this method simply checks an int and ads a zero in front of it if not double digit
		if(num < 10)
			return "0"+num;
		return ""+num;
	}//end of pad

	public String getLoc(){

		return location;
	}//end of getLoc()

	public String getDes(){

		return description;
	}//end of getDes()

	public void addFollower(int id) {
		followers.add(id);
	}//end of addFollower()

	public boolean isAlreadyFollowing(int id) {

		for(Integer attenders : followers) {
			if(attenders == id)
				return true;
		}
		return false;
	}

	public String howManyGoing() {
		int num = followers.size();
		if(num == 1)
			return num+" person going!";
		else
			if(num > 1)
				return num+" people going!";

		return "";
	}//end of printFollowers()



}//end of class