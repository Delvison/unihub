package com.unihub.app;

import java.security.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.ejb.*;


public class MessagesTag extends SimpleTagSupport{
  @EJB UserStatefulBI usr;
  String user, type;

  public void setUser(String user) {
    this.user = user;
  }

  public void setType(String type) {
    this.type = type;
  }

  public void doTag() throws JspException, IOException{
    List<Message> msgs;
    if(type.equals("sent")) {
      msgs =  usr.getSentMessages(user);
    } else if(type.equals("received")) {
      msgs = usr.getReceivedMessages(user);
    } else {
      msgs = new ArrayList<Message>();
    }
    for(Message m: msgs) {
      getJspContext().setAttribute("fromName", m.getFromName());
      getJspContext().setAttribute("toName", m.getToName());
      getJspContext().setAttribute("msgContents", m.getContents());
      getJspBody().invoke(null);
    } 
  }
}
