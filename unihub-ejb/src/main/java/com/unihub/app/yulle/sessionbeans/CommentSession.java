package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.*;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.text.DateFormat;
import javax.persistence.*;
import javax.transaction.*;

@Stateful
@Remote(CommentEJB.class)
@WebService
public class CommentSession implements CommentEJB {
	//CommentObj coms = CommentObj.create();

	@PersistenceContext EntityManager em;
	@EJB ActivityEJB activityManager;
	
	@WebMethod
	public void addComment(String user, String comment, int itemId){		
		Comment c = new Comment(user, comment, itemId);
		em.persist(c);
		activityManager.createActivity(itemId, user, 1);
		//coms.addComment(user,comment,itemId);
	}

	@WebMethod
	public Comment getComment(int passedId){
		return null;//coms.getComment(passedId);
	}

	@WebMethod
	public String[] getContentArray(int passedId){
		//Comment c = coms.getComment(passedId);
		return null;//c.getContentArray();
	}

	@WebMethod
	public List<Comment> getListOfComments(){		
		return em.createQuery("FROM Comment").getResultList();
		//return coms.getListOfComments();
	}

}
