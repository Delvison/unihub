package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@Remote(BidEJB.class)
@WebService
public class BidSession implements BidEJB {
	ListingsObj lis = ListingsObj.create();;
	String oldPrice;	

	@WebMethod
	public void placeBid(int itemId, String user, String bidPlaced) throws RuntimeException{
    	oldPrice = lis.getStuff(itemId).getPrice();
    	
    	//if the user logged in != the user that owns the listing &&
      	//the inputted bid value > the oldPrice 
      	if (!user.equals(lis.getStuff(itemId).getUser()) && 
        (Integer.parseInt(bidPlaced) > Integer.parseInt(oldPrice))){
        	//place the bid (Stuff.bid(user,bidprice))
        	lis.getStuff(itemId).bid(user, bidPlaced);
        }
        else{
        	throw new RuntimeException();
        }	
	}
}