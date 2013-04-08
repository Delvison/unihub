package com.unihub.app;

import javax.ejb.Remote;
import java.util.ArrayList;
import javax.naming.*;
import javax.naming.directory.*;

@Remote
public interface CommentEJB {
	public void addComment(String user, String comment, int itemId);
	public Comment getComment(int passedId);
	public ArrayList<Comment> getListOfComments();
	public String[] getContentArray(int passedId);
}
