package com.unihub.app;

import javax.ejb.Remote;
import java.util.ArrayList;
import javax.naming.*;
import javax.naming.directory.*;

@Remote
public interface BidEJB {
	public void placeBid(int itemId, String user, String bidPlaced) throws RuntimeException;
}