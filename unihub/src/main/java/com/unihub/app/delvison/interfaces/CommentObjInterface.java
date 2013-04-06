package com.unihub.app;

import javax.ejb.Remote;
import javax.naming.*;
import javax.naming.directory.*;

@Remote
public interface CommentObjInterface {

  public void addComment(String user, String comment, int itemId);
  public Comment getComment(int passedId);

}
