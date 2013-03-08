/* 
This class is a model for comments
*/

package com.unihub.app;

public class Comment{
  String user;
  int commentId;
  String comment;
  
  public Comment(String user, String comment, int commentId){
    this.user = user;
    this.comment = comment;
    this.commentId = commentId;
  }
}
