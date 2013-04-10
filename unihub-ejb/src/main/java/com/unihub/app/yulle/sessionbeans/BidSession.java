package com.unihub.app;

import javax.ejb.*;
import javax.annotation.Resource;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateful
@Remote(BidEJB.class)
@WebService
public class BidSession implements BidEJB {

	@WebMethod
	public void placeBid(int itemId, String user, String bidplaced){

	}
}