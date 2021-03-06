package com.unihub.app;

import java.util.ArrayList;

public class CommentObj{
  public ArrayList<Comment> comments;
  int id;
  
  private CommentObj(){
    comments= new ArrayList<Comment>();
    this.id=0;
  }
  private static CommentObj comment;
  
  public static CommentObj create(){
    if (comment == null) {
       comment = new CommentObj();
    }
    return comment;
  }
  
  public void addComment(String user, String comment, int itemId){
    id = id+1;
    Comment a = new Comment(user,comment,itemId);
    comments.add(a);
    /* ADD THE COMMENT TO THE ACTIVITY LOG */
    String activity = user+" has posted a comment";
    ListingsObj lis = ListingsObj.create();
    lis.getStuff(itemId).addActivity(activity);
  }
  
  public Comment getComment(int passedId) {
    Comment comment = comments.get(0); 
    for (Comment c: comments){
      if (c.commentId == passedId)
        comment = c;
    }
    return comment;
  }

  public ArrayList<Comment> getListOfComments(){
    return this.comments;
  }
}
