package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.persistence.*;

@Stateless
@Remote(BidEJB.class)
@WebService
public class BidSession implements BidEJB {
	ListingsObj lis = ListingsObj.create();;
	String oldPrice;
    @EJB ActivityEJB activityManager;
    @PersistenceContext
    EntityManager em;
	
	@WebMethod
	public void placeBid(int itemId, String user, String bidPlaced) throws RuntimeException{
      String query ="SELECT * FROM Stuff WHERE id=\'"+itemId+"\';";
      Query q = em.createNativeQuery(query, Stuff.class);
      ArrayList<Stuff> b = (ArrayList)q.getResultList();
        Stuff a = b.get(0);
    	oldPrice = a.getPrice();
    	//if the user logged in != the user that owns the listing &&
      	//the inputted bid value > the oldPrice 
      	if (!user.equals(a.getUser()) && 
        (Integer.parseInt(bidPlaced) > Integer.parseInt(oldPrice))){
        	//place the bid (Stuff.bid(user,bidprice))
        	a.bid(user, bidPlaced);
            activityManager.createActivity(itemId, user, 2);
            em.merge(a);
        }
        else{
        	throw new RuntimeException();
        }
        //activityManager.createActivity(itemId, user, 2);
	}
}