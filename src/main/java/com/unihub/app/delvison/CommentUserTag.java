package com.unihub.app;

import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;

public class CommentUserTag extends SimpleTagSupport{
  String user; 


  public void setUser(String u){
    this.user = u;  
  }

  public void doTag() throws JspException, IOException{
    JspWriter out = getJspContext().getOut();
    if (user != null){
      out.print("<p style=\"font-size:xx-small;color:Green\">Logged in as "+user+"</p>");
    }else{
      out.print("<p style=\"font-size:xx-small;color:Red\">Please login to post a comment</p>");                                                  
    }
  }
}
