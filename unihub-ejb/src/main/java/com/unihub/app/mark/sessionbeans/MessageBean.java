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
import javax.persistence.*;
import javax.transaction.*;

@Stateless
@Remote(MessageBI.class)
public class MessageBean implements MessageBI {

    private int id;
    private User owner;
    private String fromName, toName, contents;
    @PersistenceContext
    EntityManager em;
     
    public void createMessage(User u, String f, String t, String c) {
      owner = u;
      fromName = f;
      toName = t;
      contents = c;
      Message m = new Message(u, f, t, c);
      em.persist(m);
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
 
    public String toString() {
      return "To: " + toName + "\nFrom: " + fromName + "\nContents: " + contents;
    }
}
