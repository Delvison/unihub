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
    private String fromName, toName, contents;
    private Dbase ubase = Dbase.create();
    @PersistenceContext
    EntityManager em;
     
    public void createMessage(String f, String t, String c) {
      fromName = f;
      toName = t;
      contents = c;
      id = 0;
      Message m = new Message(f, t, c);
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
