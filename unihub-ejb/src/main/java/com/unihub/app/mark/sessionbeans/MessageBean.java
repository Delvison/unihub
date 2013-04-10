/**
 * @author Mark
 * 
 * Implementation of interface for CRUD operations on personal messages
 */

package com.unihub.app;

import javax.ejb.*;
import javax.annotation.*;
import javax.naming.*;
import javax.jws.WebMethod;
import javax.jws.WebService;

@Stateless
@Remote(MessageBI.class)
public class MessageBean implements MessageBI {

    private String fromName, toName, contents;
    private Dbase ubase = Dbase.create();

    public void createMessage(String f, String t, String c) {
      fromName = f;
      toName = t;
      contents = c;
    }
 
    public String getContents () {
      return contents;
    }

    public String getToName () {
      return toName;
    }

    public String getFromName () {
      return fromName;
    }

    public void addToReceived(String tname) {
      ubase.getUser(tname).addToReceived(new Message(fromName, toName, contents));
    }

    public void addToSent(String fname) {
      ubase.getUser(fname).addToSent(new Message(fromName, toName, contents)); 
    }
 
    public String toString() {
      return "To: " + toName + "\nFrom: " + fromName + "\nContents: " + contents;
    }
}
