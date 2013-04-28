package com.unihub.app;

import java.io.*;
import java.security.*;
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

    private String fromName;
    private String toName;
    private String contents;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
 
    public Message() {
      fromName = "";
      toName = "";
      contents = "";
      id = 0;
    }

    public Message(String from, String to, String c) {
      fromName = from;
      toName = to;
      contents = c;
      id = 1;
    }

    public int getId () {
      return id;
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
