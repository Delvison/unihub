package com.unihub.app;

import java.io.*;
import java.security.*;
import javax.servlet.*;
import javax.servlet.http.*;

/**
 *
 * @author Mark
 * 
 * A message model.
 */
public class Message implements Serializable {

    private String fromName, toName, contents;

    public Message(String from, String to, String c) {
      fromName = from;
      toName = to;
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

    public String toString() {
      return "To: " + toName + "\nFrom: " + fromName + "\nContents: " + contents;
    }
}
