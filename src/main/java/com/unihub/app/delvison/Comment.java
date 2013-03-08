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
  
    //function to return all content
  public String[] getContentArray(){
    String[] a = new String[2];
    a[0] = this.user;
    a[1] = this.comment;
    return a;       
  }
  
}
