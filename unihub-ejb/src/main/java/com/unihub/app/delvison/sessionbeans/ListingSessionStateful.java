//@author Delvison
//This sessionbean allows CRUD operations for individual listings.

package com.unihub.app;

import javax.ejb.Remote;
import javax.ejb.Stateful;
import javax.annotation.Resource;
import java.util.Date;
import java.util.ArrayList;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;
import java.text.SimpleDateFormat;
import java.text.DateFormat;

@Stateful (name="ListingObjEJBStateful") //should be stateless
@Remote
public class ListingSessionStateful implements ListingObjEJBStateful {

  public ArrayList<Stuff> userSearch(String userSearched){
    ListingsObj lis = ListingsObj.create();
    ArrayList<Stuff> listingsByTheUser = new ArrayList<Stuff>();
    for (Stuff s: lis.stuffs){
      if(s.getUser().equals(userSearched)){
        listingsByTheUser.add(s);
      }
    }
    return listingsByTheUser; 
  }
  
  public ArrayList<Stuff> getArrayList(){
    ListingsObj lis = ListingsObj.create();
    return lis.stuffs;
  }

  public int getArrayListSize(){
    ListingsObj lis = ListingsObj.create();
    return lis.stuffs.size();
  }

}
