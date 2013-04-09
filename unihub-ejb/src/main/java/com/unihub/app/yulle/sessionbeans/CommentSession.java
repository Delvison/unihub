package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.text.DateFormat;


@Stateful
@Remote(CommentEJB.class)
@WebService
public class CommentSession implements CommentEJB {
	CommentObj coms = CommentObj.create();

	@WebMethod
	public void addComment(String user, String comment, int itemId){
		coms.addComment(user,comment,itemId);
	}

	@WebMethod
	public Comment getComment(int passedId){
		return coms.getComment(passedId);
	}

	@WebMethod
	public String[] getContentArray(int passedId){
		Comment c = coms.getComment(passedId);
		return c.getContentArray();
	}

	@WebMethod
	public ArrayList<Comment> getListOfComments(){
		return coms.getListOfComments();
	}

}