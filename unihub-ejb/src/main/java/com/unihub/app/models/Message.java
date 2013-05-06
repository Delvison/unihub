package com.unihub.app;

import java.io.*;
import java.security.*;
import javax.ejb.*;
import javax.annotation.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.persistence.*;

/**
 *
 * @author Mark
 * 
 * A message model.
 */

@Entity
public class Message implements Serializable {

    @ManyToOne(targetEntity=User.class)
    private User owner;
    private String fromName;
    private String toName;
    private String contents;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    public Message() {
    }

    public Message(User u, String from, String to, String c) {
      owner = u;
      fromName = from;
      toName = to;
      contents = c;
    }

    public int getId () {
      return id;
    }

    public User getOwner() {
      return owner;
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
