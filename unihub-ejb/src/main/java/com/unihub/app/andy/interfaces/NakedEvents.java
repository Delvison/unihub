package com.unihub.app;

import javax.ejb.*;

@Remote
public interface NakedEvents {

	public String getTitle(int i);

	public String getLocation(int i);

	public String getDescription(int i);

	public String getDateAndTime(int i);

}