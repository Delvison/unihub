package com.unihub.app;

import java.security.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.ejb.*;


public class UsersTag extends SimpleTagSupport{
  @EJB UserStatefulBI usr;
  String user;
  String school;
  int limit;

  public void setUser(String user){
    this.user = user;
  }

  public void setSchool(String school){
    this.school = school;
  }

  public void setLimit(String lim){
    this.limit = Integer.parseInt(lim);
  }

  public void doTag() throws JspException, IOException{
      List<User> users = usr.getAllUsers();
      for(User u: users) {
        getJspContext().setAttribute("userName", u.getName());
        getJspContext().setAttribute("userId", u.getId());
        getJspContext().setAttribute("userSchool", u.getSchool());
        try {
          getJspContext().setAttribute("userGravatar", u.sizedGravatar(30));
        }catch(NoSuchAlgorithmException e) {
          System.out.println("Gravatar failed");
        }
        getJspBody().invoke(null);
      }
  }

}
